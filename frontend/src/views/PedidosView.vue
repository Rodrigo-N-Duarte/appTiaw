<template>
    <v-container>
      <v-card-title>Pedidos</v-card-title>
        <v-row>
          <v-col cols="12" lg="3" v-for="i in 10" :key="i">
            <v-card
                class="mx-auto"
                max-width="344"
                variant="outlined"
            >
              <v-card-item>
                <div>
                  <div class="text-overline mb-1">
                    OVERLINE
                  </div>
                  <div class="text-h6 mb-1">
                    Headline
                  </div>
                  <div class="text-caption">Greyhound divisely hello coldly fonwderfully</div>
                </div>
              </v-card-item>

              <v-card-actions>
                <v-btn variant="outlined">
                  Button
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>

        <v-row justify="start">
          <v-col cols="auto">
            <v-dialog
                transition="dialog-top-transition"
                width="auto"
            >
              <template v-slot:activator="{ props }">
                <v-btn
                    prepend-icon="mdi-cart"
                    v-bind="props"
                >Finalizar pedidos</v-btn>
              </template>
              <template v-slot:default="{ isActive }">
                <v-card>
                  <v-toolbar
                      color="primary"
                      title="Pedidos"
                  ></v-toolbar>
                  <v-card-text>
                    <div class="text-h2 pa-12">Hello world!</div>
                  </v-card-text>
                  <v-card-actions class="justify-end">
                    <v-btn
                        color="red"
                        variant="text"
                        @click="isActive.value = false"
                    >Close</v-btn>
                    <v-btn
                        color="green"
                        variant="text"
                        @click="isActive.value = false"
                    >Pagar</v-btn>
                  </v-card-actions>
                </v-card>
              </template>
            </v-dialog>
          </v-col>
        </v-row>
    </v-container>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
    name: "PedidosView",
  data(){
      return{
        dialogFinalizarPedido: false,
      }
  }
});
</script>
