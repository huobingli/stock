<template>
  <!-- 所有的内容要被根节点包含起来 -->
    <div id="home">
        <button @click="getData()">请求数据</button>       
        <ul>
            <li v-for="item in list">
                {{item.title}}
            </li>
        </ul>
    </div>
</template>

<script>
import Axios from 'axios';

    export default{
        data(){
            return {               
                list:[]
            }
        },
        methods:{

            getData(){

                // to do 跨域请求
                var api='localhost:8080/select/300750';
                // Axios.head('Access-Control-Allow-Headers', 'Content-Type, Content-Length, Authorization, Accept, X-Requested-With');
                Axios.get(api).then((response)=>{
                    this.list=response.data.result;
                }).catch((error)=>{
                    console.log(error);

                })

            }
        },
        mounted(){  /*生命周期函数*/

            this.getData();

        }
       

    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
