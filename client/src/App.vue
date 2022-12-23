<template>
  <v-app>
    <v-card flat>
      <v-toolbar color="primary" extended flat>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
      </v-toolbar>

      <v-card class="mx-auto" max-width="700" style="margin-top: -64px">
        <v-toolbar flat>
          <v-toolbar-title> {{ title }}</v-toolbar-title>
          <v-spacer></v-spacer>
        </v-toolbar>

        <v-divider></v-divider>

        <v-card-text>
          <StepperForm />
        </v-card-text>
      </v-card>
    </v-card>
  </v-app>
</template>

<script lang="ts">
  import Vue from 'vue';
  import StepperForm from './components/StepperForm.vue';

  export default Vue.extend({
    name: "App",

    components: {
      StepperForm,
    },

    data: () => ({
      title: "Knowledge based system - Laptop" as string,
    }),
  });

</script>