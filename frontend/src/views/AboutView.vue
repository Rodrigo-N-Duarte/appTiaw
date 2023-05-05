<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="2">
        <v-sheet
          rounded="lg"
          min-height="268"
          style="background-color: lightgray"
        >
          <!--  -->
        </v-sheet>
      </v-col>

      <v-col cols="12" sm="8">
        <v-sheet
          min-height="70vh"
          rounded="lg"
          style="background-color: lightgray"
        >
          <!--  -->
        </v-sheet>
      </v-col>

      <v-col cols="12" sm="2">
        <v-sheet
          rounded="lg"
          min-height="268"
          style="background-color: lightgray"
        >
          <!--  -->
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "AboutView",
  data() {
    return {
      drawer: null,
    };
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
</style>
