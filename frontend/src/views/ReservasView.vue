<template>
<div>
  <v-container v-if="reservas && reservas[0]">
    <v-row>
      <h1 class="ml-10" style="font-weight: 400">Reservas em andamento:</h1>
    </v-row>
    <v-row>
      <v-col cols="12" md="6" lg="4" v-for="reserva in reservas" :key="reserva">
        <v-card
            class="mx-auto"
            max-width="400"
            height="auto"
        >
          <v-card-item title="Reserva">
          </v-card-item>

          <h7 class="ml-2 mb-10">
            <v-icon
                icon="mdi-dialpad"
                size="18"
                color="error"
                class="me-1"
            ></v-icon>
            Número: {{reserva.id}}
          </h7>


          <v-card-title class="mt-3" style="font-size: 50px; font-weight: 350">
            Mesa: {{reserva.numero_mesa}}
          </v-card-title>
          <v-card-subtitle style="font-size: 20px">
            Empresa: {{reserva.nome_empresa}}
          </v-card-subtitle>

          <div class="d-flex py-10" >
            <v-row justify="space-around">
              <v-list-item-subtitle><v-icon>mdi-calendar-clock</v-icon> {{reserva.data}}</v-list-item-subtitle>
              <v-list-item-subtitle><v-icon>mdi-clock</v-icon> {{ reserva.hora }}</v-list-item-subtitle>
            </v-row>
          </div>
          <v-row class="ma-5">
            <v-btn variant="elevated" @click="() => cancelarReserva(reserva.id)">Cancelar reserva</v-btn>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>


  <v-container v-else>
    <v-row justify="center" style="margin-top: 15%">
      <v-col cols="7">
        <h1>Você não possui reservas ativas 😢</h1>
      </v-col>
    </v-row>
  </v-container>
</div>
</template>

<script>
import {defineComponent} from "vue";
import {useAuthStore} from "@/store/AuthStore";

export default defineComponent({
  name: "ReservasView",
  data() {
    return {
      reservas: null
  }
  },
  methods: {
    async getReservas(){
      const authStore = useAuthStore()
      const idUsuario = authStore.user.id
      await fetch(`http://localhost:8080/reserva/buscar-por-usuario/${idUsuario}`)
          .then(async (res) => {
            const data  = await res.json()
            this.reservas = data
          })
    },
    async cancelarReserva(id){
      await fetch(`http://localhost:8080/reserva/excluir/${id}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json"
        }
      })
          .then(()=> {
            alert("Reserva excluida com sucesso!")
            this.getReservas()
          })
    },
    mostra(){
      console.log(this.reservas)
    }
  },
  beforeMount() {
    this.getReservas()
  }
})
</script>
