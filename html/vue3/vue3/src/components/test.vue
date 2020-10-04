<template>
  <div>
    <div id='mainpie' style='width: 600px;height:400px;'></div>
  </div>
</template>

<script>
export default {
  name: 'index',
  data() {
    return {};
  },
  methods: {
    drawpie() {
      var myChart = this.$echarts.init(document.getElementById('mainpie'));
      myChart.setOption({
        title: {
          text: '异步数据加载示例'
        },
        tooltip: {},
        legend: {
          data: ['销量']
        },
        xAxis: {
          data: []
        },
        yAxis: {},
        series: [
          {
            name: '销量',
            type: 'bar',
            data: []
          }
        ]
      });

      $.ajax({
        type: 'GET',
        url: '/api/data',
        dataType: 'json',
        success: function(data) {
          debugger;
          myChart.setOption({
            xAxis: {
              data: data.data.categories
            },
            series: [
              {
                name: '销量',
                data: data.data.data
              }
            ]
          });
        }
      });
    }
  },

  mounted() {
    this.drawpie();
  }

};

</script>