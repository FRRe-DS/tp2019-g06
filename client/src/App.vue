<template>
  <v-app>
    <v-toolbar dark color="primary">
      <v-toolbar-title class="headline text-uppercase">
        <span>Hospital -</span>
        <span class="font-weight-light"> Sistema de Turnos</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
     
    </v-toolbar>

    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

import Home from '@/views/Home';
import RegistrarTurno from '@/views/RegistrarTurno';

export default {
  name: 'App',
  components: {
    'app-home': Home,
    RegistrarTurno,
  },
  data () {
    return {
      //
    }
  }
}
</script>
