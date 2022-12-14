<template>
  <v-container>
    <CardLaptop :laptop="laptop" v-if="!loading && laptop.name" />

    <v-layout align-center justify-center column fill-height v-if="loading">
      <v-flex row align-center>
        <v-progress-circular
          :size="50"
          color="primary"
          indeterminate
          class="d-flex justify-center"
        ></v-progress-circular>
      </v-flex>
    </v-layout>

    <v-stepper v-model="e1" elevation="0" v-else-if="!laptop.name">
      <v-stepper-header>
        <v-stepper-step :complete="e1 > 1" step="1"> Utility </v-stepper-step>

        <v-divider></v-divider>

        <v-stepper-step :complete="e1 > 2" step="2"> Size </v-stepper-step>

        <v-divider></v-divider>

        <v-stepper-step :complete="e1 > 3" step="3"> Cost </v-stepper-step>

        <v-divider></v-divider>

        <v-stepper-step step="4"> Battery </v-stepper-step>
      </v-stepper-header>

      <v-stepper-items>
        <v-stepper-content step="1">
          <v-card class="mb-12" elevation="0">
            <v-btn
              v-for="(item, index) in utilityOptions"
              :key="index"
              block
              color="primary"
              elevation="2"
              large
              outlined
              raised
              rounded
              class="mb-4"
              @click="handleUtilityOption(item)"
              >{{ item }}</v-btn
            >
          </v-card>

        </v-stepper-content>

        <v-stepper-content step="2">
          <v-card class="mb-12" elevation="0">
            <v-btn
              v-for="(item, index) in sizeOptions"
              :key="index"
              block
              color="primary"
              elevation="2"
              large
              outlined
              raised
              rounded
              class="mb-4"
              @click="handleSizeOption(item)"
              >{{ item }}</v-btn
            >
          </v-card>

          <v-btn text> Cancel </v-btn>
        </v-stepper-content>

        <v-stepper-content step="3">
          <v-card class="mb-12" elevation="0">
            <v-btn
              v-for="(item, index) in costOptions"
              :key="index"
              block
              color="primary"
              elevation="2"
              large
              outlined
              raised
              rounded
              class="mb-4"
              @click="handleCostOptions(item)"
              >{{ item }}</v-btn
            >
          </v-card>

          <v-btn text> Cancel </v-btn>
        </v-stepper-content>

        <v-stepper-content step="4">
          <v-card class="mb-12" elevation="0">
            <v-btn
              v-for="(item, index) in batteryOptions"
              :key="index"
              block
              color="primary"
              elevation="2"
              large
              outlined
              raised
              rounded
              class="mb-4"
              @click="handleBatteryOptions(item)"
              >{{ item }}</v-btn
            >
          </v-card>

          <v-btn text> Cancel </v-btn>
        </v-stepper-content>
      </v-stepper-items>
    </v-stepper>
  </v-container>
</template>

<script>
import axios from "axios";
import CardLaptop from "./CardLaptop.vue";

export default {
  name: "StepperForm",
  components: {
    CardLaptop,
  },
  data: () => ({
    e1: 1,
    loading: false,

    utilityOptions: ["Basico", "Juegos", "Crear/Diseniar", "Trabajo/Escuela"],
    sizeOptions: ["Pequenio", "Mediano", "Grande"],
    costOptions: ["$300.000 o menos", "Más de $300.000"],
    batteryOptions: ["10hs o menos", "Más de 10hs"],

    laptop: {},
  }),
  methods: {
    handleSubmit() {
      this.loading = true;

      axios
        .post("http://localhost:8080/laptops", this.laptop)
        .then((response) => {
          console.log(response.data);
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

    handleUtilityOption(utility) {
      this.laptop.utility = utility;
      this.e1 = 2;
    },
    handleSizeOption(size) {
      this.laptop.size = size;
      this.e1 = 3;
    },
    handleCostOptions(cost) {
      this.laptop.cost = cost;
      this.e1 = 4;
    },
    handleBatteryOptions(battery) {
      this.laptop.battery = battery;
      this.handleSubmit();
    },
  },
};
</script>
