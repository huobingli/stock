<template>
    <div>
        <div id="chartInfo" style="width:1400px;margin:0 auto;">
            <p>高瓴资本布局</p>
        </div>
        <div id="chart" style="width:1400px;height:400px;margin:0 auto;"></div>
    </div>
</template>

<script> 
import Axios from 'axios';

export default {
    data(){
        return {
        charts:null
    }},
    mounted(){
        this.charts = D3Charts.init('chart');
        this.init()
    },
    methods:{        
        init(){
            var option;
            var lineData = [];
            var markData = [];

            for (var j = 1; j < 12; j++) {
                for (var i = 1; i < 32; i++) {
                    var d = [
                        j + '.' + i,
                        Math.random() * 30 + Math.sin(Math.PI * i * j / 300) * 30 + 20
                    ];

                    lineData.push(d);
                }
            }

            for (var i = 0; i < lineData.length - 50; i++) {
                if (i % 7 == 1) {
                    markData.push({
                        xValue: lineData[i][0],
                        yValue: lineData[i][1],
                        total: (Math.random() * 5 + 1).toFixed(0)
                    });
                }
            }

            // 标记最后一条数据为selected
            markData[markData.length - 1].selected = true;

            var pointNum = Math.min(40, lineData.length);
            var dataLen = lineData.length;
            var minZoom = pointNum / dataLen;

            var lastMark = markData[markData.length - 1];
            var lastIndex;

            for (var i = 0; i < lineData.length; i++) {
                if (lastMark.xValue === lineData[i][0]) {
                    lastIndex = i;
                    break;
                }
            }
    
            var start, end;

            if (dataLen - 1 - lastIndex < pointNum / 2) {
                start = 1 - minZoom;
                end = 1;
            } else {
                start = lastIndex / (dataLen - 1) - minZoom / 2;
                end = lastIndex / (dataLen - 1) + minZoom / 2;
            }
            console.log(start, end, minZoom)
            option = {
                data: [
                    {
                        originData: lineData
                    },
                    {
                        originData: markData
                    }
                ],
                grid: [
                    {
                        left: 43,
                        right: 35,
                        top: 75,
                        bottom: 80
                    },
                    {
                        left: 43,
                        right: 35,
                        bottom: 30,
                        height: 30
                    }
                ],
                series: [
                    {
                        type: 'line',
                        $dataIndex: 0,
                        dataKey: 1,
                        line: {
                            show: true,
                            style: {
                                normal: {
                                    stroke: '#1f8ceb',
                                    lineWidth: 1
                                }
                            }
                        },
                        area: {
                            show: true,
                            style: {
                                normal: {
                                    fill: {
                                        y2: 1,
                                        x2: 0,
                                        colorStops: [
                                            {
                                                offset: 0,
                                                color: '#1f8ceb'
                                            },
                                            {
                                                offset: 1,
                                                color: 'white'
                                            }
                                        ]
                                    },
                                    opacity: 0.3
                                }
                            }
                        },
                        symbol: {
                            normal: {
                                show: 'all',
                                size: 4,
                                style: {
                                    stroke: '#1f8ceb',
                                    fill: 'white'
                                }
                            },
                            emphasis: {
                                show: true,
                                style: {
                                    fill: '#1f8ceb'
                                }
                            }
                        },
                        link: {
                            normal: {
                                show: 'all',
                                style: {
                                    stroke: {
                                        y2: 1,
                                        x2: 0,
                                        colorStops: [
                                            {
                                                offset: 0,
                                                color: '#1f8ceb'
                                            },
                                            {
                                                offset: 1,
                                                color: 'white'
                                            }
                                        ]
                                    },
                                    opacity: 0.2,
                                    lineWidth: 2
                                }
                            },
                            emphasis: {
                                show: true,
                                style: {
                                    stroke: {
                                        y2: 1,
                                        x2: 0,
                                        colorStops: [
                                            {
                                                offset: 0,
                                                color: '#1f8ceb'
                                            },
                                            {
                                                offset: 1,
                                                color: 'white'
                                            }
                                        ]
                                    },
                                    opacity: 1
                                }
                            }
                        },
                        z: 10
                    },
                    {
                        type: 'line',
                        $dataIndex: 0,
                        dataKey: 1,
                        $axisIndex: [2, 3],
                        line: {
                            show: true,
                            style: {
                                normal: {
                                    stroke: 'rgba(47,69,84,0.3)',
                                    lineWidth: 0.5
                                }
                            }
                        },
                        area: {
                            show: true,
                            style: {
                                normal: {
                                    fill: 'rgba(47,69,84,0.1)'
                                }
                            }
                        },
                        z: 1
                    }
                ],
                markPoint: [
                    {
                        // $axisIndex: [0, 1],
                        $seriesIndex: 0,
                        enableSelect: true,
                        symbol: {
                            size: [20, 22],
                            type: 'path://M4.75441985,18 L18,18 L18,0 L0,0 L0,17.0975104 L0,20.5966241 L4.75441985,18 Z',
                            offset: [10, -20],
                            style: {
                                normal: {
                                    fill: 'white',
                                    stroke: 'rgba(31,140,235,1)',
                                    lineWidth: 1,
                                    // shadowBlur: 2,
                                    // shadowColor: '#E4E4E4',
                                    // shadowOffsetX: 2,
                                    // shadowOffsetY: 2
                                },
                                emphasis: {
                                    fill: 'rgba(31,155,235,1)'
                                }
                            }
                        },
                        label: {
                            normal: {
                                show: true,
                                style: {
                                    position: 'inside',
                                    fill: 'rgba(31,140,235,1)',
                                    textOffset: [0, -2]
                                },
                                formatter: function (d) {
                                    return d.total == 1 ? '!' : d.total;
                                }
                            },
                            emphasis: {
                                show: true,
                                style: {
                                    fill: 'rgba(255,255,255,1)'
                                }
                            }
                        },
                        $dataIndex: 1,
                        z: 12
                    },
                    {
                        // $axisIndex: [0, 1],
                        $seriesIndex: 0,
                        $dataIndex: 1,
                        symbol: {
                            size: 4,
                            type: 'circle',
                            style: {
                                normal: {
                                    fill: 'rgba(31,145,235,1)',
                                    stroke: 'rgba(31,140,235,0.5)',
                                    lineWidth: 4
                                }
                            }
                        },
                        z: 11
                    },
                    {
                        // $axisIndex: [2, 3],
                        $seriesIndex: 1,
                        $dataIndex: 1,
                        symbol: {
                            size: 3,
                            type: 'circle',
                            style: {
                                normal: {
                                    fill: '#cdcdcd'
                                }
                            }
                        },
                        z: 1
                    }
                ],
                dataZoom: [
                    {
                        type: 'both',
                        seriesIndex: 0,
                        left: 43,
                        right: 35,
                        height: 30,
                        bottom: 30,
                        background: {
                            style: {
                                fill: 'rgba(51,51,51,0.05)',
                                stroke: null
                            }
                        },
                        // dataBackground: {
                        // 	show: false,
                        // 	style: {
                        // 		fill: 'rgba(218,218,218,1)'
                        // 	}
                        // },
                        handler: {
                            type: 'rect',
                            size: [2, '100%'],
                            style: {
                                fill: '#1F8CEB'
                            }
                        },
                        filler: {
                            style: {
                                fill: 'rgba(31,140,235,0.5)'
                            }
                        },
                        label: {
                            show: true,
                            formatter: function (d) {
                                return d;
                            },
                            style: {
                            }
                        },
                        start: start,
                        end: end,
                        minSpan: minZoom / 2
                    }
                ],
                axis: [
                    {
                        position: 'top',
                        type: 'point',
                        $dataIndex: 0,
                        $dataZoomIndex: 0,
                        dataKey: 0,
                        line: {
                            show: false
                        },
                        tick: {
                            show: false
                        },
                        label: {
                            padding: 25
                        },
                        interval: 999,
                        alwaysShowFirst: true,
                        alwaysShowLast: true
                    },
                    {
                        position: 'left',
                        type: 'linear',
                        xOrY: 'y',
                        line: {
                            show: false
                        },
                        tick: {
                            show: false
                        },
                        domainFormatter: function (domain) {
                            return [domain[0] * 0.9, domain[1] * 1.1]
                        },
                        name: {
                            show: true,
                            text: '股价:元',
                            offset: [-8, 0]
                        },
                        splitNumber: 5
                    },
                    {
                        position: 'bottom',
                        type: 'point',
                        $gridIndex: 1,
                        $dataIndex: 0,
                        dataKey: 0,
                        line: {
                            show: false
                        },
                        tick: {
                            show: false
                        },
                        label: {
                            show: true
                        },
                        intervalLength: 9999,
                        alwaysShowLast: true
                    },
                    {
                        position: 'left',
                        type: 'linear',
                        $gridIndex: 1,
                        xOrY: 'y',
                        line: {
                            show: false
                        },
                        tick: {
                            show: false
                        },
                        label: {
                            show: false
                        }
                    }
                ],
                textStyle: {
                    fill: 'rgba(51,51,51,0.3)',
                    fontFamily: 'DIN-Regular'
                }
            }

            this.charts.setOption(option)
        }
    }
}
</script>

<style>

</style>