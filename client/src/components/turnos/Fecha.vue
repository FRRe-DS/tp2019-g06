<template>
  <v-container>
  <v-layout wrap>
    <v-flex xs12 sm6 md6 xl6 >
         
      <h3> Seleccione Fecha de consulta </h3>
      <br/>
      <!--<v-date-picker v-model="fecha" 
      :show-current="false"
       locale="es-ar"
       :min="minimo"
       @select="enviarFecha">
       </v-date-picker>-->
       <v-menu>
         <v-text-field :value="fecha" slot="activator" label="Fecha" prepend-icon="date_range"></v-text-field>
         <v-date-picker v-model="fecha" @input="enviarFecha(fecha)"></v-date-picker>
       </v-menu>
    </v-flex>
    {{fecha}}
  </v-layout>
  
</v-container>
</template>

<script>
  export default {
    data () {
      return {
       fecha:null,
       minimo: new Date().toISOString().substr(0, 10),
      }
    },

    methods:{
      enviarFecha(fecha){
      this.$data.fecha = fecha;
      console.log("estoy mandando una fecha", fecha);
       this.$emit('enviarFecha',  this.$data.fecha )
    },

    }
  }
</script>