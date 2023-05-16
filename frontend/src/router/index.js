import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";
import SignView from "../views/SignView.vue";
import LocalDetalheView from "@/views/LocalDetalheView.vue";
import PedidosView from "@/views/PedidosView.vue";
import ReservasView from "@/views/ReservasView.vue";

const routes = [
  {
    path: "/",
    name: "App",
    component: SignView,
  },
  {
    path: "/home",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/pedidos/:id",
    name: "pedidos",
    component: PedidosView,
  },
  {
    path: "/reservas",
    name: "reservas",
    component: ReservasView,
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
