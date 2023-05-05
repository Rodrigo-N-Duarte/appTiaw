<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer">
      <NavBar></NavBar>
    </v-navigation-drawer>

    <v-app-bar elevation="0">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
    </v-app-bar>

    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
import NavBar from "./components/NavBar.vue";
export default {
  name: "App",
  components: { NavBar },
  data: () => ({
    drawer: null,
  }),
};
</script>
