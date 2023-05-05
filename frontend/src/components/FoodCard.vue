<template>
  <v-card class="mx-auto" max-width="344">
    <v-card-item>
      <div>
        <v-img
          height="200"
          src="https://cdn.pixabay.com/photo/2019/01/29/18/05/burger-3962996_960_720.jpg"
          cover
          class="text-white"
        ></v-img>
        <div class="text-h6 mb-1">Tipo da comida</div>
        <div class="text-caption">Descrição</div>
      </div>
    </v-card-item>

    <v-card-actions>
      <v-btn variant="outlined"> Ver restaurantes </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "FoodCard",
};
</script>

<style scoped>
.v-card {
  text-align: center;
}
.v-btn {
  margin-left: 80px;
}
</style>
