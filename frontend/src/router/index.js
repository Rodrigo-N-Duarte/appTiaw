import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";
import SignView from "../views/SignView.vue";
import LocalsView from "../views/LocalsView.vue";
import SearchView from "../views/SearchView.vue";
import FavoritesView from "../views/FavoritesView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/buscar",
    name: "buscar",
    component: SearchView,
  },
  {
    path: "/favorites",
    name: "favorites",
    component: FavoritesView,
  },
  {
    path: "/pedidos",
    name: "pedidos",
    component: SignView,
  },
  {
    path: "/locals",
    name: "locals",
    component: LocalsView,
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
];

const router = createRouter({
  // eslint-disable-next-line no-undef
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
