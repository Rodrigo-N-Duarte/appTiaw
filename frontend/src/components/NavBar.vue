<template>
  <v-container>
    <v-container>
      <v-row style="margin-bottom: 20px">
        <v-col>
          <v-img :src="imagemLogo" width="100"></v-img>
        </v-col>
      </v-row>
      <v-row v-if="authStore.user">
        <v-col>
          <v-card class="card-profile">
            <v-row>
              <v-col cols="5">
                <v-menu>
                  <template v-slot:activator="{ props }">
                    <v-btn icon v-bind="props">
                      <v-avatar size="large">
                        <span class="text-h5">{{ authStore.user.nome[0] }}</span>
                      </v-avatar>
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-text>
                      <div class="mx-auto text-center">
                        <h3>{{ authStore.user.nome }}</h3>
                        <v-divider class="my-3"></v-divider>
                        <v-btn rounded variant="text" @click="sair"> Sair</v-btn>
                      </div>
                    </v-card-text>
                  </v-card>
                </v-menu>
              </v-col>
              <v-col cols="7">
                <span>{{ authStore.user.nome }}</span>
                <p style="font-size: 10px">
                  Perfil
                </p>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>

      <v-divider></v-divider>


      <v-list v-if="authStore.tipoUsuario == 'usuario'" density="compact" nav>
        <v-list-item
            v-for="(icon, index) in iconsUser"
            :key="index"
            :class="icon.value"
            :disabled="!authStore.user && icon.value != 'login'"
            :href="icon.href"
            :prepend-icon="icon.type"
            :title="icon.name"
            :value="icon.value"
        ></v-list-item>
      </v-list>


      <v-list v-else density="compact" nav>
        <v-list-item
            v-for="(icon, index) in iconsEmpresa"
            :key="index"
            :class="icon.value"
            :disabled="!authStore.user && icon.value != 'login'"
            :href="icon.href"
            :prepend-icon="icon.type"
            :title="icon.name"
            :value="icon.value"
        ></v-list-item>
      </v-list>


      <v-divider></v-divider>

<!--      <v-container style="position: absolute; bottom: 0; left: 0">
        <v-btn
            :icon="theme"
            variant="default"
            @click="this.changeTheme"
        ></v-btn>
      </v-container>-->
    </v-container>
  </v-container>
</template>

<script>
import {useAuthStore} from "@/store/AuthStore";

export default {
  name: "NavBar",
  data() {
    return {
      authStore: useAuthStore(),
      theme: "mdi-weather-sunny",
      iconsUser: [
        {
          type: "mdi-home",
          name: "Home",
          value: "home",
          href: "/home",
        },
        {
          type: "mdi-cart",
          name: "Meus pedidos",
          value: "pedidos",
          href: "/pedidos/:id",
        },
        {
          type: "mdi-clock-outline",
          name: "Reservas",
          value: "reservas",
          href: "/reservas",
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
      iconsEmpresa: [
        {
          type: "mdi-view-dashboard",
          name: "Dashboard",
          value: "dashboard",
          href: "/dashboard",
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
        // eslint-disable-next-line no-undef
        imagemLogo: require('@/assets/logo.png')
    };
  },
  methods: {
    async changeTheme() {
      if (this.theme == "mdi-weather-sunny") this.theme = "mdi-weather-night";
      else this.theme = "mdi-weather-sunny";
    },
    sair() {
      const authStore = useAuthStore()

      authStore.user = null
      authStore.tipoUsuario = null
      console.log(authStore.user)
      this.$router.push("/sign")
    },
    mostra() {
      const authStore = useAuthStore()
      console.log(authStore.user)
    }
  },
  beforeMount() {
    const authStore = useAuthStore()
    this.user = authStore.user
  }
}
</script>
<style scoped>
.card-profile {
  background-color: rgb(248, 248, 248);
  padding: 10px;
  margin-bottom: 20px;
}
</style>
