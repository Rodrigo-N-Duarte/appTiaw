<template>
    <v-container v-if="pedido">
        <v-card-title>Pedido de número {{pedido.id}}</v-card-title>
        <v-row v-if="itens[0]">
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
                        <v-btn variant="outlined" @click="() => excluirItem(i.id)">
                            Excluir
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-col>
        </v-row>
      <v-row justify="center" v-else>
        <v-col cols="7" class="ma-16">
          <h2>Adicione itens ao seu pedido para continuar ☕️</h2>
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
        <v-btn @click="excluirPedido" color="red">Excluir pedido</v-btn>
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
  <v-container v-else>
    <v-row justify="center" style="margin-top: 15%">
      <v-col cols="7">
        <h1>Você não possui pedidos ativos 😢</h1>
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
      async excluirItem(id) {
          const idPedido = this.pedido.id
          await fetch(`http://localhost:8080/pedido/${idPedido}/deletar-item/${id}`, {
              method: "PUT",
              headers: {
                  "Content-Tpe": "application/json",
              },
          }).then(async ()=> {
              alert("Item excluido do pedido!")
              await this.buscarPedidoPorUsuario()
          })
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

            const data = this.dataDoPedido
          const hora = this.horaDoPedido

          fetch(`http://localhost:8080/pedido/finalizar/${idPedido}?data=${data}&hora=${hora}`, {
            method: "PUT",
            headers: {
              "Content-Tpe": "application/json",
            },
          }).then(()=> {
            alert("Seu pedido foi encaminhado ao restaurante!")
          })
      },
      async excluirPedido(){
        const idPedido = this.pedido.id
        await fetch(`http://localhost:8080/pedido/excluir/${idPedido}`, {
          method: "DELETE",
          headers: {
            "Content_Type": "application/json"
          }
        })
            .then(()=> {
              alert("Pedido excluido")
              location.reload()
            })
      }
    },
    async beforeMount() {
        await this.buscarPedidoPorUsuario()
    }
});
</script>
