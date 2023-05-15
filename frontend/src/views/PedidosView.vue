<template>
    <v-container>
        <v-card-title>Pedidos</v-card-title>
        <v-row>
            <v-col v-for="i in itens" :key="i" cols="12" lg="3">
                <v-card
                        class="mx-auto"
                        max-width="344"
                        variant="outlined"
                >
                    <v-card-item>
                        <div>
                            <div class="text-overline mb-1">
                                Item de id: {{ i.id }}
                            </div>
                            <div class="text-h6 mb-1">
                                {{ i.nome }}
                            </div>
                            <div class="text-caption">R$ {{ i.preco }}</div>
                        </div>
                    </v-card-item>

                    <v-card-actions>
                        <v-btn variant="outlined">
                            Excluir
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-col>
        </v-row>


      <v-container>
            <v-row>
              <v-col cols="12" lg="4">
                <v-row
                    justify="center"
                    no-gutters
                >
                  <v-col cols="5" style="margin: 5px">
                    <v-text-field
                        v-model="dataDoPedido"
                        label="Dia marcado"
                        type="date"
                    ></v-text-field>
                  </v-col>
                  <v-col cols="5" style="margin: 5px">
                    <v-text-field
                        v-model="horaDoPedido"
                        label="Hora marcada"
                        type="time"
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-col>
            </v-row>
        <v-btn @click="mostra">mostrar data e hora no console</v-btn>
      </v-container>

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
                        >Finalizar pedidos
                        </v-btn>
                    </template>

                    <template v-slot:default="{ isActive }">
                        <v-card min-width="300px">
                            <v-toolbar
                                    color="primary"
                                    title="Pedidos"
                            ></v-toolbar>
                            <v-card-text>
                                <v-list lines="one">
                                    <v-list-item
                                            v-for="item in itens"
                                            :key="item"
                                    >
                                        <v-card variant="outlined" style="padding: 20px">
                                            <p>
                                                <v-icon>mdi-circle-small</v-icon>
                                                {{ item.nome }}
                                            </p>
                                            <p>R${{ item.preco }}</p>
                                        </v-card>
                                    </v-list-item>
                                </v-list>
                            </v-card-text>
                            <v-card-actions class="justify-end">
                                <v-btn
                                        color="red"
                                        variant="text"
                                        @click="isActive.value = false"
                                >Fechar
                                </v-btn>
                                <v-btn
                                        color="green"
                                        variant="text"
                                        @click="() => {
                                          isActive.value = false
                                          finalizarPedido()
                                        }"
                                >Pagar
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </template>
                </v-dialog>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
import {defineComponent} from "vue";
import {useAuthStore} from "@/store/AuthStore";

export default defineComponent({
    name: "PedidosView",
    data() {
        return {
            dialogFinalizarPedido: false,
          pedido: null,
            itens: null,
          dataDoPedido: null,
          horaDoPedido: null
        }
    },
    methods: {
        async buscarPedidoPorUsuario() {
            const authStore = useAuthStore();
            const idUsuario = authStore.user.id
            await fetch(`http://localhost:8080/pedido/buscar-por-usuario/${idUsuario}`)
                .then(async (res) => {
                    const data = await res.json()
                  this.pedido = data[0]
                    this.itens = data[0].id_itens
                  console.log(this.pedido)
                })
        },
      mostra(){
          console.log(this.dataDoPedido)
          console.log(this.horaDoPedido)
      },
      finalizarPedido(){
          if (!this.dataDoPedido || !this.horaDoPedido){
            alert("Preencha a data e a hora desejada")
            return
          }
          if (!this.itens){
            return;
          }
          const idPedido = this.pedido.id
        const pedido = {
            data: this.dataDoPedido,
          hora: this.horaDoPedido
        }
          fetch(`http://localhost:8080/pedido/finalizar/${idPedido}`, {
            method: "PUT",
            headers: {
              "Content-Tpe": "application/json",
              body: JSON.stringify(pedido)
            }
          }).then(()=> {
            alert("Seu pedido foi encaminhado ao restaurante!")
          })
      }
    },
    async beforeMount() {
        await this.buscarPedidoPorUsuario()
    }
});
</script>
