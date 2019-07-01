<template>
  <div class="turnos">
      <template>
  <v-layout align-center>
     <v-flex xs12 sm4 text-xs-center>
      <div>
        <v-btn large>Registrar Turno</v-btn>
      </div>
      
    </v-flex>
  </v-layout>
</template>


  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import medicosList from '@/components/medicos/medicosList.vue';


export default {
  components: {
    
  },
  data () {
    
    return {
      turno:{idTurno:"",fecha:"",hora:"",motivoConsulta:"",
      paciente:{idPaciente:"",apellido:"",nombre:"",
      dni:"",fechaNacimiento:"",sexo:"",direccion:"",telefono:"",obraSocial:null},
      medico:{idMedico:"",apellido:"",nombre:"",dni:"",sexo:"",estadoCivil:"",direccion:"",matricula:"",especialidad:""},
      obraSocial:{idObraSocial:"",nombre:" ",direccion:""}}
    }
  },
  
}
  

</script>