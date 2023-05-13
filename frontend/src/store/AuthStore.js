import { defineStore } from 'pinia'

export const useAuthStore = defineStore('authStore', {
    state: () => {
        return {
            user: null,
        }
    },
    persist: true,
    getters: {},
    actions: {},
})

