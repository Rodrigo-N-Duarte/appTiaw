<template>
<v-container>
  <v-row justify="center">
    <v-col cols="12" lg="7">
      <v-text-field
          v-model="pesquisa"
          label="Pesquisar por nome"
          single-line
          hide-details
      >
      </v-text-field>
    </v-col>
    <v-col cols="12" lg="3">
      <v-btn icon="mdi-magnify" @click="buscarEmpresasPorNome"></v-btn>
      <v-btn prepend-icon="mdi-format-list-bulleted" @click="buscarEmpresas">
        Listar todos
      </v-btn>
    </v-col>
  </v-row>
  <v-row>
    <v-col lg="4" md="6" sm="12" v-for="(empresa, index) in empresas" :key="index">
      <LocalCard :empresa="empresa"></LocalCard>
    </v-col>
  </v-row>
  <v-row v-if="!empresas || !empresas[0]" justify="center" style="margin-top: 15%">
    <v-col cols="7">
      <h1>Parece que não existem estabelecimentos parceiros 😢</h1>
    </v-col>
  </v-row>
  <v-btn @click="mostrar">
    mostrar
  </v-btn>
</v-container>
</template>

<script>
import { defineComponent } from "vue";
import LocalCard from "@/components/LocalCard.vue";
import {useAuthStore} from "@/store/AuthStore";
import {mapState} from "pinia";

export default defineComponent({
  name: "HomeView",
  components: { LocalCard },
  data(){
    return {
      empresas: null,
      pesquisa: null
    }
  },
  methods:{
    async buscarEmpresas(){
      let response = await fetch("http://localhost:8080/empresa/buscar")
      let data = await response.json();
      this.empresas = data
    },
    async buscarEmpresasPorNome(){
        if (!this.pesquisa){
            return
        }
      let url = `http://localhost:8080/empresa/buscar-por-nome/${this.pesquisa}`
      let response = await fetch(url)
      let data = await response.json();
      this.empresas = data
    },
    mostrar(){
      const authStore = useAuthStore()
      console.log(authStore.user)
    }
  },
  computed: {
    ...mapState(useAuthStore, ['user'])
  },
  async beforeMount(){
    console.log(this.user)
    this.buscarEmpresas()
  }
});
</script>
