import { createApp } from 'vue'
// add  vcharts
import VCharts from 'v-charts'
import App from './App.vue'
import VueRouter from 'vue-router'
import routers from './router/router'


App.use(VueRouter)
const router = new VueRouter({
	routers
})

createApp(App).use(router).mount('#app')
App.use(VCharts)

