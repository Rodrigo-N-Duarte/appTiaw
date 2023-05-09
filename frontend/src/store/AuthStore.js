import { defineStore } from 'pinia'

export const useAuthStore = defineStore('authStore', {
    state: () => {
        return {
            user: null,
            estaLogado: false,
        }
    },
    getters: {},
    actions: {
        setEstaLogado(){
            this.estaLogado = !this.estaLogado
        }
    },
})

