import { defineStore } from 'pinia'

export const useAuthStore = defineStore('authStore', {
    state: () => {
        return {
            user: null,
            tipoUsuario: null
        }
    },
    persist: true,
    getters: {},
    actions: {},
})

