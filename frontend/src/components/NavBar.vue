<template>
  <v-container>
    <v-container>
      <v-row style="margin-bottom: 20px">
        <v-col>
          <v-img src="" width="100">logo</v-img>
        </v-col>
      </v-row>
      <v-row v-if="user">
        <v-col>
          <v-card class="card-profile">
            <v-row>
              <v-col cols="5">
                <v-menu>
                  <template v-slot:activator="{ props }">
                    <v-btn icon v-bind="props">
                      <v-avatar size="large">
                        <span class="text-h5">{{ user.nome[0] }}</span>
                      </v-avatar>
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-text>
                      <div class="mx-auto text-center">
                        <h3>{{ user.nome }}</h3>
                        <v-divider class="my-3"></v-divider>
                        <v-btn rounded variant="text"> Disconnect</v-btn>
                      </div>
                    </v-card-text>
                  </v-card>
                </v-menu>
              </v-col>
              <v-col cols="7">
                <span>{{ user.nome }}</span>
                <p style="font-size: 10px">
                  Perfil
                </p>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>

      <v-divider></v-divider>

        <v-list density="compact" nav>
          <v-list-item
              v-for="(icon, index) in icons"
              :prepend-icon="icon.type"
              :title="icon.name"
              :value="icon.value"
              :class="icon.value"
              :href="icon.href"
              :key="index"
          ></v-list-item>
        </v-list>

      <v-divider></v-divider>

      <v-container style="position: absolute; bottom: 0; left: 0">
          <v-btn
              :icon="theme"
              @click="this.changeTheme"
              variant="default"
          ></v-btn>
      </v-container>
    </v-container>
  </v-container>
</template>

<script>
export default {
  name: "NavBar",
  data() {
    return {
      theme: "mdi-weather-sunny",
      user: null,
      icons: [
        {
          type: "mdi-view-dashboard",
          name: "Home",
          value: "home",
          href: "/",
        },
        {
          type: "mdi-order-bool-descending",
          name: "Pedidos",
          value: "pedidos",
          href: "/pedidos",
        },
        {
          type: "mdi-message-bulleted",
          name: "Sobre",
          value: "sobre",
          href: "/about",
        },
        {
          type: "mdi-lock",
          name: "Login",
          value: "login",
          href: "/sign",
        },
      ],
    };
  },
  methods: {
    async changeTheme() {
      if (this.theme == "mdi-weather-sunny") this.theme = "mdi-weather-night";
      else this.theme = "mdi-weather-sunny";

      let res = await fetch("http://localhost:8080/usuario/buscar/1");
      let data = await res.json();
      this.user = data
        console.log(this.user);
    },
  },
};
</script>
<style scoped>
.card-profile {
  background-color: rgb(248, 248, 248);
  padding: 10px;
  margin-bottom: 20px;
}
</style>
