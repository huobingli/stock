// import App from '../App'

import { createRouter, createWebHistory } from 'vue-router'
// import helloworld from '../page/helloworld.vue'
// import dapandata from '../page/dapandata.vue'

const routerHistory = createWebHistory()

const router = createRouter({
    history: routerHistory,
    routes: [
    //   {
    //     path: '/',
    //     component: helloworld
    //   },
    //   {
    //     path: '/dapandata',
    //     component: dapandata
    //   }
    ]
  })

  export default router

// export default [{
//     path: '/',
//     component: App,
//     children: [{
//         path: '',
//         component: r => require.ensure([], () => r(require('../page/helloworld')), 'helloworld')
//     }, {
//         path: '/dapanenv',
//         component: r => require.ensure([], () => r(require('../page/dapanenv')), 'dapanenv')
//     }, {
//         path: '/dapandata',
//         component: r => require.ensure([], () => r(require('../page/dapandata')), 'dapandata')
//     }]
// }]