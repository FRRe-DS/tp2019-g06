<template>
  <v-app>
    <v-toolbar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>Hospital -</span>
        <span class="font-weight-light"> Sistema de Turnos</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        flat
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
      >
        <span class="mr-2">Latest Release</span>
      </v-btn>
    </v-toolbar>

    <v-content>
      <Home/>
    </v-content>
  </v-app>
</template>

<script>

import Home from '@/views/Home';

export default {
  name: 'App',
  components: {
    Home,
  },
  data () {
    return {
      //
    }
  }
}
</script>
