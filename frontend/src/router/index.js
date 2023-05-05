import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";
import SignUpView from "../views/SignUpView.vue";
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
    path: "/search",
    name: "search",
    component: SignUpView,
  },
  {
    path: "/favorites",
    name: "favorites",
    component: FavoritesView,
  },
  {
    path: "/orders",
    name: "orders",
    component: SignUpView,
  },
  {
    path: "/about",
    name: "about",
    component: AboutView,
  },
  {
    path: "/locals",
    name: "locals",
    component: LocalsView,
  },
  {
    path: "/signin",
    name: "signup",
    component: SignUpView,
  },
  {
    path: "/signup",
    name: "signup",
    component: SignUpView,
  },
  {
    path: "/perfil",
    name: "perfil",
    component: SignUpView,
  },
];

const router = createRouter({
  // eslint-disable-next-line no-undef
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
