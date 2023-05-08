<template>
   <v-container>
      <v-row>
          <v-row justify="center" style="margin-top: 20px">
              <v-col cols="8">
                  <v-text-field
                      v-model="search"
                      label="Pesquise um restaurante por nome"
                      single-line
                      hide-details
                  >
                  </v-text-field>
              </v-col>
              <v-col cols="1">
                  <div><v-btn icon="mdi-magnify"></v-btn></div>
              </v-col>
          </v-row>
          <v-row>
              <v-col lg="4" md="6" sm="12" v-for="(card, index) in 9" :key="index">
                  <LocalCard></LocalCard>
              </v-col>
          </v-row>
      </v-row>
   </v-container>
</template>

<script>
import { defineComponent } from "vue";
import LocalCard from "@/components/LocalCard.vue";

export default defineComponent({
  name: "HomeView",
  components: { LocalCard },
});
</script>
