<template>
  <div id="chart" style="width:1400px;height:400px"></div>
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
            let option = {
                "data": {
                    "originData": []
                },
                "grid": [
                    {
                        "top": "15%",
                        "left": "15%",
                        "right": "10%",
                        "bottom": "15%"
                    }
                ],
                "series": [
                    {
                        "type": "line",
                        "$dataIndex": 0,
                        "dataKey": "limitupcount",
                        "name": "涨停",
                        "symbol": {
                            // "normal": {
                            //     "show": "all",
                            //     "size": 6,
                            //     "style": {
                            //         "fill": "white",
                            //         "stroke": "#2DCDCD",
                            //         "lineWidth": 2
                            //     }
                            // },
                            "emphasis": {
                                "show": true,
                                "style": {
                                    "fill": "#2DCDCD",
                                    "stroke": "#2DCDCD"
                                }
                            }
                        },
                        "line": {
                            "show": true,
                            "style": {
                                "normal": {
                                    "stroke": "#DC143C",
                                    "lineWidth": 2
                                }
                            }
                        }
                    },
                    {
                        "type": "line",
                        "$dataIndex": 0,
                        "dataKey": "limitdowncount",
                        "name": "跌停",
                        "symbol": {
                            // "normal": {
                            //     "show": "all",
                            //     "size": 6,
                            //     "style": {
                            //         "fill": "white",
                            //         "stroke": "#2e96ff",
                            //         "lineWidth": 2
                            //     }
                            // },
                            "emphasis": {
                                "show": true,
                                "style": {
                                    "fill": "#2e96ff",
                                    "stroke": "#2e96ff"
                                }
                            }
                        },
                        "line": {
                            "show": true,
                            "style": {
                                "normal": {
                                    "stroke": "#006400",
                                    "lineWidth": 2
                                }
                            }
                        }
                    }
                ],
                "dataZoom": [
                    {}
                ],
                "axis": [
                    {
                        "position": "bottom",
                        "type": "point",
                        "$dataIndex": 0,
                        "$dataZoomIndex": 0,
                        "dataKey": "time",
                        "barGap": "20%",
                        "paddingInner": "60%",
                        "paddingOuter": "40%",
                        "intervalLength": 69,
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
                            "padding": 20,
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
                                "color": [
                                    "rgba(51, 51, 51, 0.05)",
                                    "rgba(0, 0, 0, 0)"
                                ]
                            }
                        },
                        "name": {
                            "show": false,
                            "text": "",
                            "offset": [
                                0,
                                0
                            ],
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
                        "max": 3100,
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
                            "padding": 25,
                            "style": {
                                "fill": "rgba(0, 0, 0, 0.3)",
                                "fontSize": 12
                            }
                        },
                        "splitLine": {
                            "show": false,
                            "style": {
                                "color": "#D1D1D1",
                                "lineWidth": 1
                            }
                        },
                        "splitArea": {
                            "show": true,
                            "style": {
                                "color": [
                                    "rgba(0, 0, 0, 0.03)",
                                    "rgba(0, 0, 0, 0)"
                                ]
                            }
                        },
                        "name": {
                            "show": false,
                            "text": "",
                            "offset": [
                                0,
                                0
                            ],
                            "location": "end",
                            "gap": 10,
                            "style": {
                                "fontSize": 12,
                                "fill": "rgba(51, 51, 51, 0.4)"
                            }
                        }
                    }
                ],
                "tooltip": [
                    {
                        "trigger": "axis",
                        "$axisIndex": 0,
                        "style": {
                            "backgroundColor": "rgba(57,93,129,0.6)"
                        }
                    }
                ],
                "axisPointer": [
                    {
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
                        gap: 15,
                            "style": {
                                "fill": "#2F97FF",
                                "textBackgroundColor": "rgba(255,255,255,1)",
                                "fontWeight": 460,
                                "fontSize": 12
                            }
                        }
                    }
                ],
                "legend": [
                    {
                        "show": true,
                        "data": [
                            "涨停",
                            "跌停"
                        ],
                        "left": "70%",
                        "top": "5%",
                        "symbol": {
                            "type": "circle",
                            "size": [
                                16,
                                8
                            ]
                        },
                        "textStyle": {
                            "color": "#485465",
                            "fontSize": 12
                        }
                    }
                ],
                "textStyle": {
                    "fill": "#9B9B9B",
                    "fontFamily": "SFUIText-Regular"
                }
            }    


            // 请求接口获取originData
            option.data.originData = this.dapandata
            console.log(this.dapandata);
            // console.log(option);
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