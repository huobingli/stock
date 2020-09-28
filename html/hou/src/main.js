import { createApp } from 'vue'
// add  vcharts
// import VCharts from 'v-charts'
import App from './App.vue'
// import VueRouter from 'vue-router'
import router from './router/router'


// App.use(VueRouter)
// const router = new VueRouter({
// 	routers
// })

const app = createApp(App)
app.use(router)
app.mount('#app')
// App.use(VCharts)

