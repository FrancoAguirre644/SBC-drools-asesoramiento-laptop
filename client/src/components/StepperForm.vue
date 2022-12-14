<template>

  <!--
  <v-card elevation="0">
    <v-img
      height="200px"
      src="https://cdn.pixabay.com/photo/2020/07/12/07/47/bee-5396362_1280.jpg"
    >
      <v-app-bar flat color="rgba(0, 0, 0, 0)">

        <v-spacer></v-spacer>

        <v-btn color="white" icon>
          <v-icon>mdi-dots-vertical</v-icon>
        </v-btn>
      </v-app-bar>

      <v-card-title class="white--text mt-8">
        <v-avatar size="56">
          <img
            alt="user"
            src="https://cdn.pixabay.com/photo/2020/06/24/19/12/cabbage-5337431_1280.jpg"
          />
        </v-avatar>
        <p class="ml-3">{{ laptop.name }}</p>
      </v-card-title>
    </v-img>

    <v-card-text>
      <v-timeline align-top dense>
        <v-timeline-item
          v-for="l in Object(laptop)"
          :key="l"
          small
        >
          <div>
            <div class="font-weight-normal">
              <strong>{{ l }}</strong> @{{ l }}
            </div>
          </div>
        </v-timeline-item>
      </v-timeline>
    </v-card-text>
  </v-card>
 -->

  <v-progress-circular
    :size="50"
    color="primary"
    indeterminate
    v-if="loading"
    class="d-flex justify-center"
  ></v-progress-circular>

  <v-stepper v-model="e1" elevation="0" v-else>
    <v-stepper-header>
      <v-stepper-step :complete="e1 > 1" step="1">
        Utility
      </v-stepper-step>

      <v-divider></v-divider>

      <v-stepper-step :complete="e1 > 2" step="2">
        Size
      </v-stepper-step>

      <v-divider></v-divider>

      <v-stepper-step :complete="e1 > 3" step="3">
        Cost
      </v-stepper-step>

      <v-divider></v-divider>

      <v-stepper-step step="4"> Battery </v-stepper-step>
    </v-stepper-header>

    <v-stepper-items>
      <v-stepper-content step="1">
        <v-card class="mb-12" elevation="0">

          <v-btn
            v-for="(item, index) in utilityOptions" :key="index"
            block
            color="primary"
            elevation="2"
            large
            outlined
            raised
            rounded
            class="mb-4"
          >{{ item }}</v-btn>

        </v-card>

        <v-btn color="primary" @click="e1 = 2"> Continue </v-btn>
        <v-btn text> Cancel </v-btn>

      </v-stepper-content>

      <v-stepper-content step="2">
        <v-card class="mb-12" elevation="0">

          <v-btn
            v-for="(item, index) in sizeOptions" :key="index"
            block
            color="primary"
            elevation="2"
            large
            outlined
            raised
            rounded
            class="mb-4"
          >{{ item }}</v-btn>

        </v-card>

        <v-btn color="primary" @click="e1 = 3"> Continue </v-btn>

        <v-btn text> Cancel </v-btn>
      </v-stepper-content>

      <v-stepper-content step="3">
        <v-card class="mb-12" elevation="0">

          <v-btn
            v-for="(item, index) in costOptions" :key="index"
            block
            color="primary"
            elevation="2"
            large
            outlined
            raised
            rounded
            class="mb-4"
          >{{ item }}</v-btn>

        </v-card>

        <v-btn color="primary" @click="e1 = 4"> Continue </v-btn>

        <v-btn text> Cancel </v-btn>
      </v-stepper-content>

      <v-stepper-content step="4">
        <v-card class="mb-12" elevation="0">

          <v-btn
            v-for="(item, index) in batteryOptions" :key="index"
            block
            color="primary"
            elevation="2"
            large
            outlined
            raised
            rounded
            class="mb-4"
          >{{ item }}</v-btn>            

        </v-card>

        <v-btn color="primary" @click="handleSubmit"> Continue </v-btn>

        <v-btn text> Cancel </v-btn>
      </v-stepper-content>
    </v-stepper-items>
  </v-stepper>

</template>

<script>
import axios from "axios";

export default {
  name: "StepperForm",

  data: () => ({
    e1: 1,
    loading: false,

    utilityOptions: ["Basico", "Juegos", "Crear/Diseniar", "Trabajo/Escuela"],
    sizeOptions: ["Pequenio", "Mediano", "Grande"],
    costOptions: ["$300.000 o menos", "Mas de $300.000"],
    batteryOptions: ["10hs o menos", "Mas de 10hs"],

    laptop: {
      name: "ASUS ROG Flow Z13",
      utility: "Juegos",
      size: "Mediano",
      cost: "Más de $300.000",
      battery: "10hs o menos",
    },
    
  }),
  methods: {
    handleSubmit() {
      this.loading = true;

      axios
        .post("http://localhost:8080/laptops", { 
          utility: "Juegos", 
          size: "Mediano", 
          cost: "Más de $300.000", 
          battery: "10hs o menos",
      })
        .then((response) => {
          console.log(response);
          this.laptop = response.data;
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          setTimeout(() => {
            this.loading = false;
          }, 1500);
        });
    },
  },
};
</script>
