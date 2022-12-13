<template>
  <v-app>
    <v-card flat>
      <v-toolbar color="pink" extended flat>
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
          <v-stepper v-model="e1" elevation="0">
            <v-stepper-header>
              <v-stepper-step :complete="e1 > 1" step="1">
                Name of step 1
              </v-stepper-step>

              <v-divider></v-divider>

              <v-stepper-step :complete="e1 > 2" step="2">
                Name of step 2
              </v-stepper-step>

              <v-divider></v-divider>

              <v-stepper-step :complete="e1 > 3" step="3">
                Name of step 3
              </v-stepper-step>

              <v-divider></v-divider>

              <v-stepper-step step="4"> Name of step 4 </v-stepper-step>
            </v-stepper-header>

            <v-stepper-items>
              <v-stepper-content step="1">
                <v-card
                  class="mb-12"
                  color="grey lighten-1"
                  height="200px"
                ></v-card>

                <v-btn color="primary" @click="e1 = 2"> Continue </v-btn>

                <v-btn text> Cancel </v-btn>
              </v-stepper-content>

              <v-stepper-content step="2">
                <v-card
                  class="mb-12"
                  color="grey lighten-1"
                  height="200px"
                ></v-card>

                <v-btn color="primary" @click="e1 = 3"> Continue </v-btn>

                <v-btn text> Cancel </v-btn>
              </v-stepper-content>

              <v-stepper-content step="3">
                <v-card
                  class="mb-12"
                  color="grey lighten-1"
                  height="200px"
                ></v-card>

                <v-btn color="primary" @click="e1 = 4"> Continue </v-btn>

                <v-btn text> Cancel </v-btn>
              </v-stepper-content>

              <v-stepper-content step="4">
                <v-card
                  class="mb-12"
                  color="grey lighten-1"
                  height="200px"
                ></v-card>

                <v-btn color="primary" @click="e1 = 1"> Continue </v-btn>

                <v-btn text> Cancel </v-btn>
              </v-stepper-content>
            </v-stepper-items>
          </v-stepper>
        </v-card-text>
      </v-card>
    </v-card>
  </v-app>
</template>

<script>
export default {
  name: "App",

  components: {},

  data: () => ({
    e1: 1,
  }),
};
</script>
