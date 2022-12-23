<template>
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
        <p class="ml-3">{{ laptop.name || "no notebook found with the following specifications" }}</p>
      </v-card-title>
    </v-img>

    <v-card-text>
      <v-timeline align-top dense>
        <v-timeline-item v-for="(value, key) in Object(laptop)" :key="value" small>
          <div>
            <div class="font-weight-normal">
              <strong class="text-capitalize">{{ key }}</strong> @{{ value }}
            </div>
          </div>
        </v-timeline-item>
      </v-timeline>
    </v-card-text>
  </v-card>
</template>

<script lang="ts">
  export default {
      props: ['laptop']
  };
</script>
