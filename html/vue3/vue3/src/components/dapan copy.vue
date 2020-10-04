<template>
  <div id="chart" style="width:1200px;height:400px"></div>
</template>

<script>
import Axios from 'axios';

export default {
    data(){
        return {
        charts:null,
        dapandata:null
    }},
    mounted(){
        this.charts = D3Charts.init('chart');
        // this.init()
        this.getdata()
    },
    methods:{        
        init(){
            console.log("init function....")
           let option = {
                "data": {
                    "originData": [
                        {
                            "date": "1",
                            "x": 80,
                            "y": 90
                        },
                        {
                            "date": "2",
                            "x": 120,
                            "y": 90
                        },
                        {
                            "date": "3",
                            "x": 160,
                            "y": 90
                        },
                        {
                            "date": "4",
                            "x": 180,
                            "y":90                            
                        },
                        {
                            "date": "5",
                            "x": 168,
                            "y":90
                        },
                        {
                            "date": "6",
                            "x": 160,
                            "y":90
                        },
                        {
                            "date": "7",
                            "x": 120,
                            "y":90
                        },
                        {
                            "date": "8",
                            "x": 180,
                            "y":90
                        },
                        {
                            "date": "9",
                            "x": 220,
                            "y":90
                        },
                        {
                            "date": "10",
                            "x": 245,
                            "y":90
                        },
                        {
                            "date": "11",
                            "x": 224,
                            "y":90
                        },
                        {
                            "date": "12",
                            "x": 248,
                            "y":90
                        },
                        {
                            "date": "13",
                            "x": 310,
                            "y":90
                        },
                        {
                            "date": "14",
                            "x": 340,
                            "y":90
                        },
                        {
                            "date": "15",
                            "x": 280,
                            "y":90
                        },
                        {
                            "date": "16",
                            "x": 300,
                            "y":90
                        },
                        {
                            "date": "17",
                            "x": 260,
                            "y":90
                        },
                        {
                            "date": "18",
                            "x": 160,
                            "y":90
                        },
                        {
                            "date": "19",
                            "x": 210,
                            "y":90
                        },
                        {
                            "date": "20",
                            "x": 220,
                            "y":90
                        },
                        {
                            "date": "21",
                            "x": 248,
                            "y":90
                        },
                        {
                            "date": "22",
                            "x": 290,
                            "y":90
                        },
                        {
                            "date": "23",
                            "x": 300,
                            "y":90
                        },
                        {
                            "date": "24",
                            "x": 290,
                            "y":90
                        },
                        {
                            "date": "25",
                            "x": 270,
                            "y":90
                        },
                        {
                            "date": "26",
                            "x": 280,
                            "y":90
                        },
                        {
                            "date": "27",
                            "x": 260,
                            "y":90
                        },
                        {
                            "date": "28",
                            "x": 250,
                            "y":90
                        },
                        {
                            "date": "29",
                            "x": 280,
                            "y":90
                        }]
                },
                "grid": [{
                    "top": "20%",
                    "left": "15%",
                    "right": "15%",
                    "bottom": "20%"
                }],
                "series": [{
                    "type": "line",
                    "$dataIndex": 0,
                    "dataKey": "limitdowncount",
                    "name": "跌停",
                    "curve": {
                        "type": "monotoneX"
                    },
                    "symbol": {
                        "emphasis": {
                            "show": true,
                            "size": 5,
                            "style": {
                                "fill": "#2e96ff",
                                "stroke": "rgba(46, 150, 255, 0.49)",
                                "lineWidth": 6
                            }
                        }
                    },
                    "line": {
                        "show": true,
                        "style": {
                            "normal": {
                                "stroke": "#006400"
                            }
                        }
                    },
                    "area": {
                        "show": true,
                        "style": {
                            "normal": {
                                "fill": "rgba(46, 150, 255, 0.4)",
                                "opacity": 0.2
                            }
                        }
                    }
                },
                {
                    "type": "line",
                    "$dataIndex": 0,
                    "dataKey": "limitupcount",
                    "name": "涨停",
                    "curve": {
                        "type": "monotoneX"
                    },
                    "symbol": {
                        "emphasis": {
                            "show": true,
                            "size": 5,
                            "style": {
                                "fill": "#2e96ff",
                                "stroke": "rgba(46, 150, 255, 0.49)",
                                "lineWidth": 6
                            }
                        }
                    },
                    "line": {
                        "show": true,
                        "style": {
                            "normal": {
                                "stroke": "#DC143C"
                            }
                        }
                    },
                    "area": {
                        "show": true,
                        "style": {
                            "normal": {
                                "fill": "rgba(46, 150, 255, 0.4)",
                                "opacity": 0.2
                            }
                        }
                    }
                }
                ],
                "dataZoom": [{}],
                "axis": [{
                    "position": "bottom",
                    "type": "point",
                    "$dataIndex": 0,
                    "$dataZoomIndex": 0,
                    "dataKey": "time",
                    "barGap": "20%",
                    "paddingInner": "60%",
                    "paddingOuter": "40%",
                    "intervalLength": 37,
                    "tick": {
                        "show": false,
                        "outerSize": 6,
                        "innerSize": 0,
                        "style": {
                            "lineWidth": 1,
                            "stroke": "rgba(51, 51, 51, 0.1)"
                        }
                    },
                    "line": {
                        "show": true,
                        "style": {
                            "stroke": "rgba(0, 0, 0, 0.1)",
                            "lineWidth": 2
                        }
                    },
                    "label": {
                        "show": true,
                        "padding": 10,
                        "style": {
                            "fill": "rgba(0, 0, 0, 0.3)",
                            "fontSize": 12
                        }
                    },
                    "splitLine": {
                        "show": false,
                        "style": {
                            "color": "rgba(51, 51, 51, 0.1)",
                            "lineWidth": 1
                        }
                    },
                    "splitArea": {
                        "show": false,
                        "style": {
                            "color": ["rgba(51, 51, 51, 0.05)",
                                "rgba(0, 0, 0, 0)"]
                        }
                    },
                    "name": {
                        "show": false,
                        "text": "",
                        "offset": [0,
                            0],
                        "location": "end",
                        "gap": 10,
                        "style": {
                            "fontSize": 12,
                            "fill": "rgba(51, 51, 51, 0.4)"
                        }
                    }
                },
                    {
                        "position": "left",
                        "type": "linear",
                        "xOrY": "y",
                        "min": 0,
                        "max": 500,
                        "splitNumber": 5,
                        "tick": {
                            "show": false,
                            "outerSize": 6,
                            "innerSize": 0,
                            "style": {
                                "lineWidth": 1,
                                "stroke": "rgba(51, 51, 51, 0.1)"
                            }
                        },
                        "line": {
                            "show": false,
                            "style": {
                                "stroke": "rgba(51, 51, 51, 0.1)",
                                "lineWidth": 2
                            }
                        },
                        "label": {
                            "show": true,
                            "padding": 20,
                            "style": {
                                "fill": "rgba(0, 0, 0, 0.3)",
                                "fontSize": 12
                            }
                        },
                        "splitLine": {
                            "show": true,
                            "style": {
                                "color": "rgba(0, 0, 0, 0.1)",
                                "lineWidth": 1
                            }
                        },
                        "splitArea": {
                            "show": false,
                            "style": {
                                "color": ["rgba(51, 51, 51, 0.05)",
                                    "rgba(0, 0, 0, 0)"]
                            }
                        },
                        "name": {
                            "show": false,
                            "text": "",
                            "offset": [0,
                                0],
                            "location": "end",
                            "gap": 10,
                            "style": {
                                "fontSize": 12,
                                "fill": "rgba(51, 51, 51, 0.4)"
                            }
                        }
                    }],
                "axisPointer": [{
                    "$axisIndex": 0,
                    "shadow": {
                        "show": true,
                        "style": {
                            "fill": "rgba(5,83,161,0.1)"
                        }
                    },
                    "line": {
                        "show": true
                    },
                    "label": {
                        "show": true,
                        "style": {
                            "fill": "#2F97FF",
                            "textBackgroundColor": "rgba(255,255,255,1)",
                            "fontWeight": 460,
                            "fontSize": 12
                        }
                    }
                }],
                "legend": [{
                    "show": true,
                    "left": "77%",
                    "top": "10%",
                    "symbol": {
                        "type": "circle"
                    },
                    "textStyle": {
                        "color": "#485465",
                        "fontSize": 12
                    },
                    "data": ["涨停","跌停"]
                }],
                "textStyle": {
                    "fill": "#9B9B9B",
                    "fontFamily": "SFUIText-Regular",
                    "fontSize": 12,
                    "fontStyle": "normal",
                    "fontWeight": "normal"
                }
            };


            // 请求接口获取originData
            // option.data.originData = 
            option.data.originData = this.dapandata

            console.log(this.dapandata);
            this.charts.setOption(option);
            console.log("init end function....")
        },
        getdata() {

            console.log("getdata function....")
            var api='http://localhost:8080/GetDapanDayData';
            let response;
            Axios.get(api).then((response)=>{
                
                console.log("getdata responce...")
                // this.list=response.data;
                // console.log(response);
                // console.log(response.data);
                // console.log(response.data.data);
                let option = response.data.data
                // console.log(option)
                this.dapandata = option
                console.log(this.dapandata)
                this.init()
            }).catch((error)=>{
                console.log(error);
            })
            
            console.log("getdata end function....")

            // this.charts.setOption(option);
        },
    }
}
</script>

<style>

</style>