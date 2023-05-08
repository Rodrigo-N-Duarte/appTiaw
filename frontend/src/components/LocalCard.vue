<template>
  <v-card :loading="loading" class="mx-auto my-12" max-width="374">
    <template v-slot:loader="{ isActive }">
      <v-progress-linear
        :active="isActive"
        color="deep-purple"
        height="4"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      cover
      height="250"
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
    ></v-img>

    <v-card-item>
      <v-card-title>{{empresa.nome}}</v-card-title>

      <v-card-subtitle>
        <span class="me-1">Telefone: {{empresa.telefone}}</span>

        <v-icon color="error" icon="mdi-fire-circle" size="small"></v-icon>
      </v-card-subtitle>
    </v-card-item>

    <v-card-text>
      <v-row align="center" class="mx-0">
        <v-rating
          :model-value="empresa.avaliacao"
          color="amber"
          density="compact"
          half-increments
          readonly
          size="small"
        ></v-rating>
      </v-row>
    </v-card-text>

    <v-divider class="mx-4 mb-1"></v-divider>

    <v-card-subtitle>Localização: {{empresa.local}}</v-card-subtitle>

    <v-card-actions>
      <v-btn color="deep-purple-lighten-2" variant="text" @click="verPaginaEmpresa">
        Ver mais
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "LocalCard",
  props: {
    empresa: Object,
  },
  data: () => ({
    loading: false,
    selection: 1,
  }),

  methods: {
    verPaginaEmpresa() {
      this.loading = true;

      setTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>
