import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import { loadFonts } from "./plugins/webfontloader";
import { createPinia } from 'pinia'

const pinia = createPinia()
import piniaPluginPersistedState from "pinia-plugin-persistedstate"
pinia.use(piniaPluginPersistedState)
loadFonts();

const app = createApp(App)

app.use(pinia).use(router).use(store).use(vuetify).mount("#app");
