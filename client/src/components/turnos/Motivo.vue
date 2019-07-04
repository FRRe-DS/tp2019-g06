
<template>
  <v-container fluid grid-list-md>
    <v-textarea
      v-model="motivo"
      name="input-7-1"
      box
      label="Ingrese el motivo de su consulta"
      auto-grow
      @input="enviarMotivo(motivo)"
    ></v-textarea>
  </v-container>
</template>
  

<script>
  export default {
    data () {
      return {
        motivo:'',
      }
    },
    methods: {
      enviarMotivo(motivo){
      this.$data.motivo= motivo;
      console.log("el motivo es ", motivo);
       this.$emit('enviarMotivo',  this.$data.motivo )
    },
    }
  }
</script>