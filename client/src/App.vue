<template>
  <v-app>
    <v-card flat>
      <v-toolbar color="primary" extended flat>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
      </v-toolbar>

      <v-card class="mx-auto" max-width="700" style="margin-top: -64px">
        <v-toolbar flat>
          <v-toolbar-title> Knowledge based system - Laptop</v-toolbar-title>

          <v-spacer></v-spacer>

          <v-btn icon>
            <v-icon>mdi-dots-vertical</v-icon>
          </v-btn>
        </v-toolbar>

        <v-divider></v-divider>

        <v-card-text>
          <StepperForm/>
        </v-card-text>
      </v-card>
    </v-card>
  </v-app>
</template>

<script>

import StepperForm from './components/StepperForm.vue';

export default {
  name: "App",

  components: {
    StepperForm,
  },

  data: () => ({
    
  }),
};
</script>