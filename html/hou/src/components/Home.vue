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
                var api='http://localhost:8080/stocks/300750';
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

<style lang="scss" scoped>
    
</style>