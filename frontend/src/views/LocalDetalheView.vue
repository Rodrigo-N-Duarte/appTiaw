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
            <v-card-title>{{empresa.nome}}</v-card-title>
            <v-card-subtitle class="pt-4">
              <v-chip
                  class="ma-2"
                  label
                  text-color="white"
              >
                <v-icon start icon="mdi-star" color="orange"></v-icon>
                Avaliação: {{empresa.avaliacao}}/5
              </v-chip>
            </v-card-subtitle>

            <v-card-text>
              <div><b>Local:</b>{{empresa.local}}</div>
              <div><b>Telefone:</b> {{empresa.telefone}}</div>
            </v-card-text>
          </v-card>
        </v-sheet>
        <v-spacer></v-spacer>
      </v-col>

      <v-col cols="12" lg="10">
        <v-sheet
            style="background-color: blue"
            min-height="70vh"
            rounded="lg"
        >
          <!--  -->
        </v-sheet>
      </v-col>
      <v-row justify="center" style="position: fixed; bottom: 0; margin: 20px">
        <v-col cols="12">
          <v-btn append-icon="mdi-pencil" @click="this.dialog = !this.dialog">
            Avaliar local
          </v-btn>
        </v-col>
      </v-row>
    </v-row>

    <v-row justify="center">
      <v-dialog
          v-model="dialog"
          persistent
          width="1024"
      >
        <v-card>
          <v-card-title>
            <span class="text-h5">Avaliar: {{empresa.nome}}</span>
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
export default {
  name: "LocalDetalheView",
  data(){
    return{
      dialog: false,
      avaliar: null,
      empresa: {
        id: null,
        nome: null,
        avaliacao: null,
        email: null,
        telefone: null,
        local: null,
      }
    }
  },
  methods: {
    async avaliarEmpresa(){
      if (!this.avaliar || this.avaliar < 0 || this.avaliar > 5){
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
      }).then((res) => {
        console.log(res)
      })
    }
  },
  async beforeMount() {
    const empresaId = this.$route.params.id
    const url = `http://localhost:8080/empresa/buscar/${empresaId}`
    let response = await fetch(url)
    let data = await response.json()
    this.empresa = data
  }
}
</script>

<style lang="scss" scoped>

</style>