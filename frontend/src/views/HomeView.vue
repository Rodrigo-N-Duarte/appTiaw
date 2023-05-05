<template>
  <v-row>
    <v-col lg="4" md="6" sm="12" v-for="(card, index) in 9" :key="index">
      <LocalCard></LocalCard>
    </v-col>
  </v-row>
</template>

<script>
import { defineComponent } from "vue";
import LocalCard from "@/components/LocalCard.vue";

export default defineComponent({
  name: "HomeView",
  components: { LocalCard },
});
</script>
