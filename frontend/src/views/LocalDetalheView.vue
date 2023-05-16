<template>
  <v-container>

    <v-row>
      <v-col cols="12" lg="2">
        <v-sheet rounded="lg">
          <v-card
              class="mx-auto"
              max-width="400"
          >
            <v-img
                class="align-end text-white"
                height="200"
                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                cover
            >
            </v-img>
            <v-card-title>{{ empresa.nome }}</v-card-title>
            <v-card-subtitle class="pt-4">
              <v-chip
                  class="ma-2"
                  label
                  text-color="white"
              >
                <v-icon start icon="mdi-star" color="orange"></v-icon>
                Avaliação: {{ empresa.avaliacao }}/5
              </v-chip>
            </v-card-subtitle>

            <v-card-text>
              <div><b>Local:</b>{{ empresa.local }}</div>
              <div><b>Telefone:</b> {{ empresa.telefone }}</div>
            </v-card-text>
          </v-card>
        </v-sheet>
        <v-spacer></v-spacer>
      </v-col>

      <v-col cols="12" lg="10">
        <v-card style="padding: 30px">
          <v-row justify="start" v-if="!pedido">
            <v-col>
              <v-btn prepend-icon="mdi-plus" @click="criarPedido">Começar um novo pedido nessa empresa</v-btn>
            </v-col>
          </v-row>
          <v-row justify="start">
            <v-col>
              <v-card-title>Cardápio:</v-card-title>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" lg="4" v-for="item in itens" :key="item">
              <v-sheet
                  min-height="40vh"
                  rounded="lg"
              >
                <v-card
                    class="mx-auto"
                    max-width="344"
                >
                  <v-img
                      src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                      height="200px"
                      cover
                  ></v-img>

                  <v-card-title>
                    {{ item.nome }}
                  </v-card-title>

                  <v-card-subtitle>
                    R${{ item.preco }}
                  </v-card-subtitle>

                  <v-card-actions>
                    <v-btn
                        @click="adicionarAoPedido(item.id)"
                        color="orange-lighten-2"
                        variant="text"
                    >
                      Adicionar aos meus pedidos
                    </v-btn>
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-sheet>
            </v-col>
          </v-row>
        </v-card>
        <v-card style="padding: 30px" class="mt-10">
          <v-row justify="start" v-if="!pedido">
            <v-col>
              <v-btn prepend-icon="mdi-plus" @click="criarPedido">Começar um novo pedido nessa empresa</v-btn>
            </v-col>
          </v-row>
          <v-row justify="start">
            <v-col>
              <v-card-title>Mesas para reserva:</v-card-title>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="6" lg="2" v-for="mesa in mesas" :key="mesa">
              <v-card
                  :color="mesa.disponivel ? 'green' : 'red'"
                  theme="dark"
              >
                <v-card-title class="text-h5">
                  Mesa {{ mesa.numero }}
                </v-card-title>
                <v-card-actions>
                  <v-btn variant="text" :disabled="!mesa.disponivel" @click="mesaSelecionada.numero = mesa.numero;
                  mesaSelecionada.id = mesa.id
                  dialogReservarMesa = !dialogReservarMesa">
                    <span v-if="mesa.disponivel">Reservar</span>
                    <span v-else>Mesa ocupada</span>
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-col>

          </v-row>
        </v-card>
      </v-col>
    </v-row>

    <v-dialog
        v-model="dialogReservarMesa"
        width="500"
    >
      <template>
        <v-btn
            color="primary"
        >
          Reserva de mesa
        </v-btn>
      </template>

      <v-card>
        <v-card-title>
          Reservar mesa de número {{mesaSelecionada.numero}}
        </v-card-title>
        <v-card-text>
          <v-card-subtitle>Selecione uma data e hora para a reserva: </v-card-subtitle>
          <v-row>
            <v-col cols="12">
              <v-row
                  justify="center"
                  no-gutters
              >
                <v-col cols="5" style="margin: 5px">
                  <v-text-field
                      v-model="dataReserva"
                      label="Dia marcado"
                      type="date"
                  ></v-text-field>
                </v-col>
                <v-col cols="5" style="margin: 5px">
                  <v-text-field
                      v-model="horaReserva"
                      label="Hora marcada"
                      type="time"
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
              variant="text"
              @click="dialogReservarMesa = !dialogReservarMesa"
          >
            Fechar
          </v-btn>
          <v-btn
              color="green-darken-1"
              variant="text"
              @click="reservarMesa"
          >
            Efetuar reserva
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-row justify="center" style="position: fixed; bottom: 0; margin: 20px">
      <v-col cols="12">
        <v-btn append-icon="mdi-pencil" @click="this.dialog = !this.dialog">
          Avaliar local
        </v-btn>
      </v-col>
    </v-row>


    <v-row justify="center">
      <v-dialog
          v-model="dialog"
          persistent
          width="1024"
      >
        <v-card>
          <v-card-title>
            <span class="text-h5">Avaliar: {{ empresa.nome }}</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
                <v-col
                    cols="12"
                    sm="6"
                    md="4"
                >
                  <v-text-field
                      v-model="avaliar"
                      type="number"
                      min="0"
                      max="5"
                      label="Avaliação *"
                      required
                      style="display: inline"
                  ></v-text-field>
                </v-col>

              </v-row>
            </v-container>
            <small>Deixe uma avaliação de 1 a 5 estrelas.</small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                color="blue-darken-1"
                variant="text"
                @click="dialog = false"
            >
              Cancelar
            </v-btn>
            <v-btn
                color="blue-darken-1"
                variant="text"
                @click="avaliarEmpresa"
            >
              Salvar
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>

  </v-container>
</template>

<script>
import {useAuthStore} from "@/store/AuthStore";

export default {
  name: "LocalDetalheView",
  data() {
    return {
      dialog: false,
      dialogReservarMesa: false,
      mesaSelecionada: {
        id: null,
        numero: null
      },
      dataReserva: null,
      horaReserva: null,
      avaliar: null,
      empresa: {
        id: null,
        nome: null,
        avaliacao: null,
        email: null,
        telefone: null,
        local: null,
      },
      itens: null,
      pedido: null,
      mesas: null
    }
  },
  methods: {
    async avaliarEmpresa() {
      if (!this.avaliar || this.avaliar < 0 || this.avaliar > 5) {
        alert("Ocorreu um erro, confira o valor inserido")
        return
      }

      const id = this.empresa.id
      const avaliacao = this.avaliar
      fetch(`http://localhost:8080/empresa/avaliacao/${id}/alterar/${avaliacao}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
      }).then(() => {
        alert("Avaliação feita com sucesso")
        this.dialog = !this.dialog
      })
    },
    async getEmpresa() {
      const empresaId = this.$route.params.id
      const url = `http://localhost:8080/empresa/buscar/${empresaId}`
      let response = await fetch(url)
      let data = await response.json()
      this.empresa = data
    },
    async getItens() {
      const empresaId = this.$route.params.id
      const url = `http://localhost:8080/item/buscar-empresa/${empresaId}`
      let response = await fetch(url)
      let data = await response.json()
      this.itens = data
    },
    async adicionarAoPedido(idItem) {
      const authStore = useAuthStore()
      const idUsuario = authStore.user.id

      await fetch(`http://localhost:8080/pedido/buscar-por-usuario/${idUsuario}`)
          .then(async (res) => {
            const pedido = await res.json()
            if (!pedido || !pedido[0]) {
              alert("Antes de continuar, primeiro faça a requisição de um novo pedido")
              return;
            }
            const idPedido = pedido[0].id

            fetch(`http://localhost:8080/pedido/${idPedido}/adicionar-item/${idItem}`, {
              method: "PUT",
              headers: {
                "Content-Type": "application/json",
              },
            }).then(() => {
              alert("item adicionado ao pedido")
            })
          })
    },
    async criarPedido() {
      await this.buscarPedidoPorUsuario()
      if (this.pedido){
        alert("Encerre o pedido atual antes de começar um novo!")
        return
      }
      const authStore = useAuthStore()
      const pedido = {
        pago: false,
        usuario: {
          id: authStore.user.id
        },
        empresa: {
          id: this.empresa.id
        }
      }
      fetch(`http://localhost:8080/pedido/cadastrar`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(pedido)
      })
          .then(() => {
            alert("Pedido criado com sucesso, a função 'carrinho' está disponível agora")
          })
          .catch((err) => {
            alert("Ocorreu um erro " + err)
          })
    },
    async buscarPedidoPorUsuario() {
      const authStore = useAuthStore();
      const idUsuario = authStore.user.id
      await fetch(`http://localhost:8080/pedido/buscar-por-usuario/${idUsuario}`)
          .then(async (res) => {
            const data = await res.json()
            this.pedido = data[0]
          })
    },
    async buscarMesasPorEmpresa(){
      const idEmpresa = this.empresa.id
      await fetch(`http://localhost:8080/mesa/buscar-mesa-por-empresa/${idEmpresa}`)
          .then(async (res) => {
            const data = await res.json()
            this.mesas = data
          })
    },
    async reservarMesa(){
      if (!this.dataReserva || !this.horaReserva){
        alert("Selecione primeiro uma data e uma hora")
        return
      }
      if (!this.mesaSelecionada || !this.mesaSelecionada.id || !this.mesaSelecionada.numero){
        return
      }
      // TODO RESERVAR MESA
      this.dialogReservarMesa = !this.dialogReservarMesa
    }
  },
  async beforeMount() {
    await this.getEmpresa()
    await this.getItens()
    await this.buscarPedidoPorUsuario()
    await this.buscarMesasPorEmpresa()
  }
}
</script>

<style lang="scss" scoped>

</style>