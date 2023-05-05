<template>
  <v-container>
    <v-container>
      <v-row>
        <v-col>
          <v-img src="" width="100">logo</v-img>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <v-card class="card-profile">
            <v-row>
              <v-col cols="4">
                <v-menu>
                  <template v-slot:activator="{ props }">
                    <v-btn icon v-bind="props">
                      <v-avatar size="large">
                        <span class="text-h5">{{ user.initials }}</span>
                      </v-avatar>
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-text>
                      <div class="mx-auto text-center">
                        <h3>{{ user.fullName }}</h3>
                        <p class="text-caption mt-1">
                          {{ user.email }}
                        </p>
                        <v-divider class="my-3"></v-divider>
                        <v-btn rounded variant="text"> Edit Account </v-btn>
                        <v-divider class="my-3"></v-divider>
                        <v-btn rounded variant="text"> Disconnect </v-btn>
                      </div>
                    </v-card-text>
                  </v-card>
                </v-menu>
              </v-col>
              <v-col cols="8">
                <span>{{ user.fullName }}</span>
                <p style="font-size: 10px">
                  Clique no ícone para mais informações
                </p>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>

      <v-divider></v-divider>

      <v-row style="margin-top: 20px; margin-bottom: 20px">
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
      </v-row>

      <v-divider></v-divider>

      <v-container>
        <v-row justify="start">
          <v-btn
            :icon="theme"
            @click="this.changeTheme"
            variant="default"
          ></v-btn>
        </v-row>
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
      user: {
        initials: "JD",
        fullName: "John Doe",
        email: "john.doe@doe.com",
      },
      icons: [
        {
          type: "mdi-view-dashboard",
          name: "Home",
          value: "home",
          href: "/",
        },
        {
          type: "mdi-magnify",
          name: "Buscar",
          value: "buscar",
          href: "/buscar",
        },
        {
          type: "mdi-star",
          name: "Favoritos",
          value: "favoritos",
          href: "/favorites",
        },
        {
          type: "mdi-order-bool-descending",
          name: "Pedidos",
          value: "pedidos",
          href: "/pedidos",
        },
        {
          type: "mdi-domain",
          name: "Restaurantes",
          value: "restaurantes",
          href: "/locals",
        },
        {
          type: "mdi-message-bulleted",
          name: "Sobre",
          value: "sobre",
          href: "/about",
        },
      ],
    };
  },
  methods: {
    changeTheme() {
      if (this.theme == "mdi-weather-sunny") this.theme = "mdi-weather-night";
      else this.theme = "mdi-weather-sunny";
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
