import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";
import SignView from "../views/SignView.vue";
import LocalDetalheView from "@/views/LocalDetalheView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/pedidos",
    name: "pedidos",
    component: SignView,
  },
  {
    path: "/about",
    name: "about",
    component: AboutView,
  },
  {
    path: "/sign",
    name: "sign",
    component: SignView,
  },
  {
    path: "/local/:id",
    name: "localDetalhe",
    component: LocalDetalheView,
  },
];

const router = createRouter({
  // eslint-disable-next-line no-undef
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
