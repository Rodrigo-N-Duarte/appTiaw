<template>
<v-container>
  <v-row justify="center">
    <v-col cols="12" lg="7">
      <v-text-field
          v-model="search"
          label="Search"
          single-line
          hide-details
      >
      </v-text-field>
    </v-col>
    <v-col cols="12" lg="3">
      <v-btn icon="mdi-magnify"></v-btn>
      <v-btn prepend-icon="mdi-format-list-bulleted">
        Listar todos
      </v-btn>
    </v-col>
  </v-row>
  <v-row>
    <v-col lg="4" md="6" sm="12" v-for="(empresa, index) in empresas" :key="index">
      <LocalCard :empresa="empresa"></LocalCard>
    </v-col>
  </v-row>
</v-container>
</template>

<script>
import { defineComponent } from "vue";
import LocalCard from "@/components/LocalCard.vue";

export default defineComponent({
  name: "HomeView",
  components: { LocalCard },
  data(){
    return {
      empresas: null
    }
  },
  methods:{
    async buscarEmpresas(){
      let response = await fetch("http://localhost:8080/empresa/buscar")
      let data = await response.json();
      this.empresas = data
    }
  },
  async beforeMount(){
    this.buscarEmpresas()
  }
});
</script>
