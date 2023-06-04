<template>
  <v-container>
    <v-container>
      <v-row class="mb-5">
        <v-col cols="12" lg="4">
          <v-card
              class="mx-auto"
              max-width="344"
              variant="elevated"
          >
            <v-img
                cover
                :src="empresa.imagem"
            ></v-img>

            <v-card-title>
              {{ empresa.nome }}
            </v-card-title>

            <v-row class="pb-10">
              <v-col>
                <v-card-subtitle>
                  <v-icon>mdi-email</v-icon>
                  {{ empresa.email }}
                </v-card-subtitle>
                <v-card-subtitle>
                  <v-icon color="orange">mdi-star</v-icon>
                  Avaliação dos clientes:
                  {{ empresa.avaliacao }}/5
                </v-card-subtitle>
                <v-card-subtitle>
                  <v-icon color="red">mdi-map-marker</v-icon>
                  Localização:
                  {{ empresa.local }}
                </v-card-subtitle>
                <v-card-subtitle>
                  <v-icon>mdi-phone</v-icon>
                  Telefone:
                  {{ empresa.telefone }}
                </v-card-subtitle>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
        <v-col cols="12" lg="8">
          <h2 class="mb-5" style="font-weight: 400">Itens do cardápio: </h2>
          <v-btn @click="dialogAdicionarNovoItem = !dialogAdicionarNovoItem" class="mb-5">Adicionar novo item</v-btn>
          <v-row>
            <v-card
                class="overflow-y-auto pa-10"
                max-height="400"
                variant="elevated"
                width="1000"
            >
              <v-row>
                <v-col v-for="item in itens" :key="item"
                       cols="6">
                  <v-card

                      class="mx-auto"
                      prepend-icon="mdi-circle-medium"
                  >
                    <v-img :src="item.imagem" width="200"></v-img>
                    <template v-slot:title>
                      {{ item.nome }}
                    </template>

                    <v-card-text>
                      R${{ item.preco }}
                    </v-card-text>
                    <v-card-text>
                      Número: {{ item.id }}
                    </v-card-text>
                      <v-card-actions>
                          <v-btn @click="() => excluirItem(item.id)" variant="outlined">Excluir item</v-btn>
                      </v-card-actions>
                  </v-card>
                </v-col>
              </v-row>
            </v-card>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
    <v-container>
      <v-row>
        <v-col cols="12" lg="4">
          <v-row>
            <v-col cols="12">
              <h2 class="mb-5" style="font-weight: 400">Pedidos em andamento: </h2>
              <v-card
                  class="overflow-y-auto"
                  max-height="400"
              >
                <v-card-text>
                  <v-card
                      v-for="pedido in pedidos"
                      :key="pedido"
                      class="mx-auto my-5"
                      prepend-icon="mdi-circle-medium"
                  >
                    <template v-slot:title>
                      Pedido: {{ pedido.id }}
                    </template>

                    <div v-if="pedido.id_itens[0]" class="ml-10">
                      <h4>Itens:</h4>
                      <div v-for="item in pedido.id_itens" :key="item"
                           class="pa-5" style="border: 1px solid lightgrey; border-radius: 5px; width: 200px">
                        <p>ID: {{ item.id }}</p>
                        <p>Item: {{ item.nome }}</p>
                        <p>Preço: R${{ item.preco }}</p>
                      </div>
                    </div>

                    <v-card-text v-if="pedido.data">
                      Data: {{ pedido.data }}
                    </v-card-text>
                    <v-card-text v-if="pedido.hora">
                      Hora: {{ pedido.hora }}
                    </v-card-text>
                    <v-card-text v-else>
                      Data e hora não foram escolhidos pelo usuário até o momento.
                    </v-card-text>
                    <v-card-text v-if="pedido.id_usuario">
                      Usuario: {{ pedido.id_usuario }}
                    </v-card-text>
                    <v-card-text v-else>
                      Pedido ainda está em execução pelo usuário.
                    </v-card-text>
                  </v-card>
                </v-card-text>
              </v-card>
            </v-col>
          </v-row>
        </v-col>
        <v-col cols="12" lg="8">
          <v-card class="pa-10" variant="elevated">
            <v-row>
              <v-col v-for="mesa in mesas" :key="mesa" cols="12" lg="4">
                <v-card
                    :color="mesa.disponivel ? 'green' : 'red'"
                    :prepend-icon="mesa.disponivel ? 'mdi-shape-square-rounded-plus' : 'mdi-square-rounded'"
                    class="mx-auto"
                >
                  <template v-slot:title>
                    Número: {{ mesa.numero }}
                  </template>

                  <v-card-text>
                    <span v-if="mesa.disponivel">Disponível</span>
                    <div v-else>
                      <span>Ocupada <span v-if="mesa.id_reserva">- Número da reserva: {{
                          mesa.id_reserva
                        }}</span></span>
                    </div>
                  </v-card-text>
                </v-card>
                <v-btn @click="() => alterarDisponibilidade(mesa.id)">Alterar disponibilidade</v-btn>
              </v-col>
            </v-row>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
    <v-dialog
        v-model="dialogAdicionarNovoItem"
        width="500"
    >
      <template>
        <v-btn
            color="primary"
        >
          Adicionar item ao cardápio
        </v-btn>
      </template>

      <v-card>
        <v-card-text>
          <v-card-subtitle>Informe os dados a seguir: </v-card-subtitle>
          <v-row>
            <v-col cols="12">
              <v-row    justify="center"
                        no-gutters>
                  <v-text-field
                          v-model="imagemNovoItem"
                          label="Imagem de capa do item"
                          type="text"
                  ></v-text-field>
              </v-row>
              <v-row
                  justify="center"
                  no-gutters
              >
                <v-col cols="5" style="margin: 5px">
                  <v-text-field
                      v-model="nomeNovoItem"
                      label="Nome"
                      type="text"
                  ></v-text-field>
                </v-col>
                <v-col cols="5" style="margin: 5px">
                  <v-text-field
                      v-model="precoNovoItem"
                      label="Preço"
                      type="number"
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
              @click="dialogAdicionarNovoItem = !dialogAdicionarNovoItem"
          >
            Fechar
          </v-btn>
          <v-btn
              color="green-darken-1"
              variant="text"
              @click="adicionarItemAoCardapio"
          >
            Adicionar
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import {useAuthStore} from "@/store/AuthStore";

export default {
  name: 'DashboardView',
  data() {
    return {
      show: false,
      empresa: {
        id: null,
        nome: null,
        avaliacao: null,
        email: null,
        telefone: null,
        local: null,
      },
      cardapio: null,
      itens: null,
      pedidos: null,
      mesas: null,
      dialogAdicionarNovoItem: false,
      nomeNovoItem: null,
      precoNovoItem: null,
      imagemNovoItem: null
    }
  },
  methods: {
    async buscarEmpresa() {
      const authStore = useAuthStore();
      const empresaId = authStore.user.id;
      const url = `http://localhost:8080/empresa/buscar/${empresaId}`;
      await fetch(url)
          .then(async (response) => {
            let data = await response.json();
            this.empresa = data;
          })

    },
    async buscarMesasPorEmpresa() {
      const idEmpresa = this.empresa.id
      await fetch(`http://localhost:8080/mesa/buscar-mesa-por-empresa/${idEmpresa}`)
          .then(async (res) => {
            const data = await res.json()
            this.mesas = data
            console.log(this.mesas)
          })
    },
    async buscarItens() {
      const authStore = useAuthStore();
      const empresaId = authStore.user.id;
      const url = `http://localhost:8080/item/buscar-empresa/${empresaId}`
      let response = await fetch(url)
      let data = await response.json()
      this.itens = data
    },
    async buscarPedidosPorEmpresa() {
      const authStore = useAuthStore();
      const idEmpresa = authStore.user.id
      await fetch(`http://localhost:8080/pedido/buscar-por-empresa/${idEmpresa}`)
          .then(async (res) => {
            const data = await res.json()
            this.pedidos = data
          })
    },
    async alterarDisponibilidade(id) {
      await fetch(`http://localhost:8080/mesa/alterar-disponibilidade/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        }
      })
          .then(async () => {
            await this.buscarMesasPorEmpresa()
          })
    },
    async buscarCardapio(){
      const authStore = useAuthStore();
      const idEmpresa = authStore.user.id
          fetch(`http://localhost:8080/cardapio/listar-por-empresa/${idEmpresa}`)
              .then(async (res) => {
                const data = await res.json()
                this.cardapio = data[0]
              })
    },

    async adicionarItemAoCardapio(){
      if (!this.nomeNovoItem || !this.precoNovoItem){
        alert("Preencha os dados corretamente!")
        return
      }
      const item = {
        nome: this.nomeNovoItem,
        preco: this.precoNovoItem,
        imagem: this.imagemNovoItem,
        cardapio: {
          id: this.cardapio.id
        }
      }
      await fetch(`http://localhost:8080/item/adicionar`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(item)
      })
          .then(()=> {
            alert("Item adicionado com sucesso!")
            this.dialogAdicionarNovoItem = !this.dialogAdicionarNovoItem
            this.buscarItens()
          })
    },
      async excluirItem(id) {
          console.log(id)
          await fetch(`http://localhost:8080/item/deletar/${id}`, {
              method: 'DELETE',
              headers: {
                  "Content-Type": "application/json"
              },
          })
              .then(()=> {
                  alert("Item deletado com sucesso!")
                  this.buscarItens()
              })
      }
  },
  async beforeMount() {
    await this.buscarEmpresa()
    await this.buscarMesasPorEmpresa()
    await this.buscarItens()
    await this.buscarPedidosPorEmpresa()
    await this.buscarCardapio()
  }
}
</script>
