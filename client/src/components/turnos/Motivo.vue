
<template>
  <v-flex xs6 sm6 md6>
    <v-textarea
      v-model="motivo"
      name="input-7-1"
      box
      label="Ingrese el motivo de su consulta"
      auto-grow
      @input="enviarMotivo(motivo)"
      :rules="[rules.required, rules.reg]"
    ></v-textarea>
  </v-flex>
</template>
  

<script>
  export default {
    data () {
      return {
        motivo:'',
        rules: {reg : v => v.length >= 10 || 'Debe ingresar mas de 10 caracteres', 
             required: value => !!value || 'Campo Obligatorio.'},
      }
    },
    methods: {
      enviarMotivo(motivo){
      this.$data.motivo= motivo;
      this.$emit('enviarMotivo',  this.$data.motivo )
    },
    }
  }
</script>