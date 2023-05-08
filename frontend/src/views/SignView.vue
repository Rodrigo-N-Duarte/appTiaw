<template>
    <div>
        <v-tabs
                v-model="tab"
                color="deep-purple-accent-4"
                align-tabs="center"
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
                                                    color="success"
                                                    class="mt-4"
                                                    block
                                            >
                                                Login
                                            </v-btn>
                                        </div>
                                    </v-form>
                                </v-card>
                            </v-sheet>
                        </v-col>
                        <v-col cols="12" lg="5">
                            <v-img width="300" src="https://picsum.photos/seed/picsum/300/300"></v-img>
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
                            <v-toolbar color="transparent" class="px-0">
                                <v-toolbar-title>Escolha como deseja se cadastrar:</v-toolbar-title>
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
                                                                color="success"
                                                                class="mt-4"
                                                                block
                                                        >
                                                            Cadastrar
                                                        </v-btn>
                                                    </div>
                                                </v-form>
                                            </v-sheet>
                                        </v-col>

                                        <v-col cols="12" lg="6">
                                            <v-img width="300" src="https://picsum.photos/seed/picsum/300/300"></v-img>
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
                                                                color="success"
                                                                class="mt-4"
                                                                block
                                                        >
                                                            Cadastrar
                                                        </v-btn>
                                                    </div>
                                                </v-form>
                                            </v-sheet>
                                        </v-col>

                                        <v-col cols="12" lg="6  ">
                                            <v-img width="300" src="https://picsum.photos/seed/picsum/300/300"></v-img>
                                        </v-col>

                                    </v-row>
                                </v-window-item>
                            </v-window>
                        </v-card>
                    </v-col>
                </v-row>
            </v-window-item>
        </v-window>
    </div>
</template>

<script>
export default {
    name: "SignView",
    data: () => ({
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
            cnpj: null
        }
    }),
};
</script>

<style scoped>
.v-sheet {
    margin-top: 20px;
}
</style>
