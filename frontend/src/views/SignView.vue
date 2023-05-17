<template>
    <div>
        <v-tabs
                v-model="tab"
                align-tabs="center"
                color="deep-purple-accent-4"
        >
            <v-tab :value="1">Fazer login</v-tab>
            <v-tab :value="2">Se cadastrar</v-tab>
        </v-tabs>
        <v-window v-model="tab">
            <v-window-item
                    :key="1"
                    :value="1"
            >
                <v-container fluid>
                    <v-row justify="center">
                        <v-col cols="12" lg="4">
                            <v-sheet class="mx-auto">
                                <v-card style="padding: 30px">
                                    <v-form ref="form">
                                        <v-text-field
                                                v-model="logIn.email"
                                                label="Email"
                                                required
                                        ></v-text-field>
                                        <v-text-field
                                                v-model="logIn.senha"
                                                label="Senha"
                                                required
                                        ></v-text-field>
                                        <div class="d-flex flex-column">
                                            <v-btn
                                                    block
                                                    class="mt-4"
                                                    color="success"
                                                    @click="fazerLogin"
                                            >
                                                Login
                                            </v-btn>
                                        </div>
                                    </v-form>
                                </v-card>
                            </v-sheet>
                        </v-col>
                        <v-col cols="12" lg="5">
                            <v-img src="https://picsum.photos/seed/picsum/300/300" width="300"></v-img>
                        </v-col>
                    </v-row>
                </v-container>
            </v-window-item>
            <v-window-item
                    :key="2"
                    :value="2"
            >
                <v-row justify="center">
                    <v-col cols="10">
                        <v-card class="mx-auto">
                            <v-toolbar class="px-0" color="transparent">
                                <v-toolbar-title>
                                    Escolha como deseja se cadastrar:
                                    <div>
                                        <span style="font-size: 12px; color: gray">
                                            Versão Beta: a segurança do site não está completa, recomendamos que coloque uma senha que não seja vinculada a outras plataformas.
                                        </span>
                                    </div>
                                </v-toolbar-title>
                                <template v-slot:extension>
                                    <v-tabs
                                            v-model="tabs"
                                            color="primary"
                                            grow
                                    >
                                        <v-tab
                                                :value="3"
                                        >
                                            Como usuario
                                        </v-tab>

                                        <v-tab
                                                :value="4"
                                        >
                                            Como empresa parceira
                                        </v-tab>
                                    </v-tabs>
                                </template>
                            </v-toolbar>

                            <v-window v-model="tabs">
                                <v-window-item
                                        :key="3"
                                        :value="3"
                                >
                                    <v-row>
                                        <v-col cols="12" lg="6">
                                            <v-sheet class="mx-auto">
                                                <v-form ref="form">
                                                    <v-text-field
                                                            v-model="cadastroUsuario.nome"
                                                            label="Name"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroUsuario.email"
                                                            label="Email"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroUsuario.senha"
                                                            label="Senha"
                                                            required
                                                    ></v-text-field>
                                                    <div class="d-flex flex-column">
                                                        <v-btn
                                                                block
                                                                class="mt-4"
                                                                color="success"
                                                                @click="cadastraUsuario"
                                                        >
                                                            Cadastrar
                                                        </v-btn>
                                                    </div>
                                                </v-form>
                                            </v-sheet>
                                        </v-col>

                                        <v-col cols="12" lg="6">
                                            <v-img src="https://picsum.photos/seed/picsum/300/300" width="300"></v-img>
                                        </v-col>
                                    </v-row>
                                </v-window-item>

                                <v-window-item
                                        :key="4"
                                        :value="4"
                                >
                                    <v-row>
                                        <v-col cols="12" lg="6">
                                            <v-sheet class="mx-auto">
                                                <v-form ref="form">
                                                    <v-text-field
                                                            v-model="cadastroEmpresa.nome"
                                                            label="Name"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroEmpresa.email"
                                                            label="Email"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroEmpresa.senha"
                                                            label="Senha"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroEmpresa.local"
                                                            label="Localização"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroEmpresa.telefone"
                                                            label="Telefone"
                                                            required
                                                    ></v-text-field>
                                                    <v-text-field
                                                            v-model="cadastroEmpresa.cnpj"
                                                            label="CNPJ"
                                                            required
                                                    ></v-text-field>

                                                    <div class="d-flex flex-column">
                                                        <v-btn
                                                                block
                                                                class="mt-4"
                                                                color="success"
                                                                @click="cadastraEmpresa"
                                                        >
                                                            Cadastrar
                                                        </v-btn>
                                                    </div>
                                                </v-form>
                                            </v-sheet>
                                        </v-col>

                                        <v-col cols="12" lg="6  ">
                                            <v-img src="https://picsum.photos/seed/picsum/300/300" width="300"></v-img>
                                        </v-col>

                                    </v-row>
                                </v-window-item>
                            </v-window>
                        </v-card>
                    </v-col>
                </v-row>
            </v-window-item>
        </v-window>
        <v-btn @click="mostra">mostrar</v-btn>
        <v-btn @click="authStore.user = null; authStore.tipoUsuario = null">null</v-btn>
    </div>
</template>

<script>
import {useAuthStore} from "@/store/AuthStore";

export default {
    name: "SignView",
    data: () => ({
        authStore: useAuthStore(),
        tab: null,
        tabs: null,
        logIn: {
            email: null,
            senha: null
        },
        cadastroUsuario: {
            nome: null,
            email: null,
            senha: null
        },
        cadastroEmpresa: {
            nome: null,
            email: null,
            senha: null,
            local: null,
            telefone: null,
            cnpj: null,
            avaliacao: 0,
        },
    }),
    methods: {
        async cadastraUsuario() {
            if (!this.cadastroUsuario) {
                alert("Preencha todos os campos para continuar!")
                return
            }
            if (!this.cadastroUsuario.nome || !this.cadastroUsuario.email || !this.cadastroUsuario.senha) {
                alert("Preencha todos os campos para continuar!")
                return
            }
            fetch('http://localhost:8080/usuario/cadastrar', {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(this.cadastroUsuario)
            }).then(() => {
                alert("Usuario cadastrado com sucesso! Faça o login para continuar")
                this.cadastroUsuario.nome = null
                this.cadastroUsuario.email = null
                this.cadastroUsuario.senha = null
            })
                .catch((error) => {
                    console.log("erro: " + error)
                })
        },
        async cadastraEmpresa() {
            if (!this.logIn) {
                alert("Preencha todos os campos para continuar!")
                return
            }
            if (!this.cadastroEmpresa.email || !this.cadastroEmpresa.senha) {
                alert("Preencha todos os campos para continuar!")
                return
            }
            fetch('http://localhost:8080/empresa/cadastrar', {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(this.cadastroEmpresa)
            }).then(() => {
                alert("Empresa cadastrada com sucesso! Faça o login para continuar")
                this.cadastroEmpresa.nome = null
                this.cadastroEmpresa.email = null
                this.cadastroEmpresa.senha = null
                this.cadastroEmpresa.telefone = null
                this.cadastroEmpresa.local = null
                this.cadastroEmpresa.cnpj = null
            })
                .catch((error) => {
                    console.log("erro: " + error)
                })
        },
        mostra() {
            console.log(this.authStore.user)
            console.log(this.authStore)
        },
        async fazerLogin() {
            if (!this.logIn) {
                alert("Preencha todos os campos para continuar!")
                return
            }
            if (!this.logIn.email || !this.logIn.senha) {
                alert("Preencha todos os campos para continuar!")
                return
            }
            fetch('http://localhost:8080/auth/login', {
                method: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.logIn)
            })
                .then(async (res) => {
                    const usuario = await res.json()
                    this.authStore.user = usuario
                  this.authStore.tipoUsuario = usuario.tipo
                    console.log(this.authStore.user)
                  if (this.authStore.tipoUsuario == "usuario")
                    this.$router.push("/home")
                  else this.$router.push("/dashboard")

                    //   const ls = {
                    //       id: usuario.id,
                    //       tipo: usuario.tipo
                    //   }
                    // localStorage.setItem('usuario', JSON.stringify(ls))
                })
                .catch(() => {
                    alert("O usuario cadastrado não existe na base de dados!")
                })
        }

    }
}
</script>

<style scoped>
.v-sheet {
    margin-top: 20px;
}
</style>
