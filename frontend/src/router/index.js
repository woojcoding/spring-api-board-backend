import { createRouter, createWebHistory } from 'vue-router'


const routes = [
  {
    path: '/home',
    name: 'HomeView',
    component: () => import(/* webpackChunkName: "boards" */ '../views/HomeView.vue')
  },
  {
    path: '/boards/free/list',
    name: 'ListView',
    component: () => import(/* webpackChunkName: "boards" */ '../views/ListView.vue')
  },
  {
    path: '/boards/free/view',
    name: 'InfoView',
    component: () => import(/* webpackChunkName: "boards" */ '../views/InfoView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
