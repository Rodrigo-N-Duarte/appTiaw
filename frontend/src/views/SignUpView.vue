<template>
  <v-card class="mx-auto" style="max-width: 500px">
    <v-form ref="form" v-model="form" class="pa-4 pt-6">
      <v-text-field
        v-model="password"
        :rules="[rules.password, rules.length(6)]"
        variant="filled"
        color="deep-purple"
        counter="6"
        label="Password"
        style="min-height: 96px"
        type="password"
      ></v-text-field>
      <v-text-field
        v-model="phone"
        variant="filled"
        color="deep-purple"
        label="Phone number"
      ></v-text-field>
      <v-text-field
        v-model="email"
        :rules="[rules.email]"
        variant="filled"
        color="deep-purple"
        label="Email address"
        type="email"
      ></v-text-field>
    </v-form>
    <v-divider></v-divider>
    <v-card-actions>
      <v-btn variant="text" @click="$refs.form.reset()"> Clear </v-btn>
      <v-spacer></v-spacer>
      <v-btn
        :disabled="!form"
        :loading="isLoading"
        color="deep-purple-accent-4"
      >
        Submit
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "SignUpView",
  data: () => ({
    agreement: false,
    dialog: false,
    email: undefined,
    form: false,
    isLoading: false,
    password: undefined,
    phone: undefined,
    rules: {
      email: (v) => !!(v || "").match(/@/) || "Please enter a valid email",
      length: (len) => (v) =>
        (v || "").length >= len || `Invalid character length, required ${len}`,
      password: (v) =>
        !!(v || "").match(
          /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*(_|[^\w])).+$/
        ) ||
        "Password must contain an upper case letter, a numeric character, and a special character",
      required: (v) => !!v || "This field is required",
    },
  }),
};
</script>
