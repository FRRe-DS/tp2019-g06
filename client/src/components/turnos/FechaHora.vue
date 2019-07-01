<template>
  <v-container>
  <v-layout wrap>
    <v-flex xs12 sm6 md6 xl6 >
         
         <h3>.  </h3>
         <h3>.  </h3>
        
      <v-date-picker v-model="fecha" 
      :show-current="false"
       locale="es-ar"
       :min="minimo"
       ></v-date-picker>
    </v-flex>
    <v-flex xs12 sm6 md6 xl6  >
       <h3> Seleccione hora de consulta </h3>
        <v-time-picker
        v-model="hora"
        :allowed-minutes="allowedStep"
        max="14:00"
        min="08:00"
        class="mt-3"
        format="24hr"
      ></v-time-picker>
      {{hora}}
    </v-flex>
  </v-layout>
  </v-container>
</template>

<script>
  export default {
    data () {
      return {
        fecha:'',
        hora:'',
       minimo: new Date().toISOString().substr(0, 10),
      }
    }
  }
</script>