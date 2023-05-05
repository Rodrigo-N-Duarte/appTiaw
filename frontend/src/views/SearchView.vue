<template>
<div>
  <v-row style="margin-top: 10px">
    <v-col cols="2"></v-col>
    <v-col cols="8">
      <v-row>
        <v-col cols="8">
          <v-text-field
              v-model="search"
              label="Search"
              single-line
              hide-details
          >
          </v-text-field>
        </v-col>
        <v-col cols="4">
          <div><v-btn icon="mdi-magnify"></v-btn></div>
        </v-col>
      </v-row>
      <v-col cols="2"></v-col>
    </v-col>
  </v-row>
  <v-row style="margin-top: 10px">
    <v-col lg="4" md="6" sm="12" v-for="(card, index) in 9" :key="index">
      <FoodCard></FoodCard>
    </v-col>
  </v-row>
</div>
</template>

<script>
import { defineComponent } from "vue";
import FoodCard from "@/components/FoodCard.vue";

export default defineComponent({
  name: "SearchView",
  components: { FoodCard },
});
</script>
