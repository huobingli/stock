// import App from '../App'

import { createRouter, createWebHistory } from 'vue-router'

const routerHistory = createWebHistory()

const router = createRouter({
    history: routerHistory,
    routes: [
      {
        path: '/',
        component: helloworld
      },
    ]
  })

  export default router