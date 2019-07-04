<template>
    <div class="verificarPaciente">
    <template>
  <v-container >
   <v-layout>
     <v-flex xs4 xl4 md4>
   <v-text-field 
      v-model="value"
      type="number"
      color="cyan darken"
      label="validacion de usuario registrado en Hospital"
      placeholder="Ingrese su DNI"
      loading
      v-on:keyup="getPaciente(value)"
      :rules="[rules.required, rules.reg]"
      counter="8"
    >
    
      <template v-slot:progress>
        <v-progress-linear
          v-if="true"
          :value="progress"
          :color="color"
          height="9"
          
        ></v-progress-linear>
       
      </template>
     
    </v-text-field>
    <h3>Paciente: {{paciente.apellido}} {{paciente.nombre}} </h3>
     </v-flex>
   </v-layout>
  </v-container>
</template>
 
    </div>
</template>

<script>
import Pacientes from "@/rest/paciente";

export default {
  components: {
    
  },
  data () {
    return {
      value: '',
      select: { nombre: '', apellido: '' },
      paciente: [],
      rules: {reg : v => v.length <= 8 || 'Solo se puede ingresar hasta 8 digitos numericos para el DNI', 
             required: value => !!value || 'Campo Obligatorio.'},
    }
  },

  created: function() {

  },
   computed: {
      progress () {
        return Math.min(100, this.value.length * 13)
      },
      color () {
        return ['error', 'warning', 'success'][Math.floor(this.progress / 40)]
      }
    },

  methods: {
       keymonitor: function(value) {
        console.log(event.key);
       if(event.key == "Enter")
       {
         console.log("enter key was pressed!",value);
       }
       },
      
    prueba(){
      alert("selecciono un medico");
    },
    
    clearSelectedPaciente: function() {
      this.$data.selected = null;
    },
    emitError: function(error) {
      this.$emit("showError", error);
    },
     mandarObraSocial() {
      console.log("estoy mandando un ide de obra social", this.$data.paciente.obraSocial);
       this.$emit('mandarIdObraSocial',  this.$data.paciente.obraSocial )
    },
     mandarPaciente() {
      console.log("estoy mandando un paciente", this.$data.paciente );
       this.$emit('mandarPaciente',  this.$data.paciente )
    },
  getPaciente: async function(dni) {
       
     if(event.key == "Enter")
       {
     try {
        this.$data.paciente = [];
        const response = await Pacientes.getRestApi().getDniPaciente(dni);
        console.log("aca no panza nada");
        console.log("Response: ", response);
        this.$data.paciente = response.data;
        console.log("Paciente: ",this.$data.paciente );
        this.mandarPaciente();
       
        this.mandarObraSocial();
       
      } catch (error) {
        this.emitError(error);
        alert("el paciente no esta registrado") ;
      }
       }
    },
  } ,   
}
</script>
