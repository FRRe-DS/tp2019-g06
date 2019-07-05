<template>
    <div class="validarMedico">
    <template>
  <v-container >
   <v-layout>
     <v-flex xs4 xl4 md4>
   <v-text-field 
      v-model="value"
      type="number"
      color="cyan darken"
      label="validacion de Medico registrado en Hospital"
      placeholder="Ingrese su Nº de matricula"
      loading
      v-on:keyup="getMedico(value)"
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
      <div class="blue lighten-3">
   <h3> <div class="black--text " > Medico: {{medic.apellido}} {{medic.nombre}} </div></h3>
          </div>
    
     </v-flex>
   </v-layout>
  </v-container>
</template>
 
    </div>
</template>

<script>
import Medicos from "@/rest/medico";

export default {
  components: {
    
  },
  data () {
    return {
      value: '',
      select: { nombre: '', apellido: '' },
      medico: [],
      rules: {reg : v => v.length <= 8 || 'Solo se puede ingresar hasta 8 digitos numericos para el DNI', 
             required: value => !!value || 'Campo Obligatorio.'},
        medic: [],     
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
    
    clearSelectedMedico: function() {
      this.$data.selected = null;
    },
    emitError: function(error) {
      this.$emit("showError", error);
    },

     mandarMedico() {
      console.log("estoy mandando un paciente", this.$data.medic );
       this.$emit('mandarMedico',  this.$data.medic )
    },
  getMedico: async function(matricula) {
       
     if(event.key == "Enter")
       {
     try {
        this.$data.medico = [];
        this.$data.medic = [];
        var arreglo = [];
        const response = await Medicos.getRestApi().getAllMedicos();
        console.log("aca no panza nada");
        console.log("Response: ", response);
          console.log("Response: ", arreglo);
        this.$data.medico = response.data.content;
         console.log("Response: ", this.$data.medico);
        for (var i = 0; i < this.$data.medico.length; i++) {
                  if(this.$data.medico[i].matricula==matricula){
                    arreglo.push(this.$data.medico[i]);
                    console.log("medico: ", arreglo);
                    this.$data.medic = arreglo[0];
                    console.log("medico: ", this.$data.medic);
                    this.mandarMedico();
                  }      
             }
        if (this.$data.medic.length==0){
            alert("no se encontro ningun medico con esa matricula") ;
        }
      } catch (error) {
        this.emitError(error);
        alert("ocurrio un error") ;
      }
       }
    },
  } ,   
}
</script>
