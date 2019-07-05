<template>
  <div class="medicosTurnos">
    <v-container>
        <h3 class="blue--text">Para consultar los turnos registrados siga los siguientes pasos </h3>
                <br/>
        <h3 class="grey lighten-1">Ingrese su Nº de matricula y luego presione enter</h3>
        <vermedico v-on:mandarMedico="obtenerMedico($event)"></vermedico>
        <h3 class="grey lighten-1"> Seleccione Fecha de Turno </h3>
        <fechaTurno v-on:enviarFechaTurno="obtenerFechaTurno($event)" ></fechaTurno>
        <v-btn :small=true color="primary" @click="crearListaTurnos()">Listar</v-btn>
        <br/>
        <br/>
         <h3 class="grey lighten-1">Listado de Turnos</h3><br/>
         <lista-turnos :turnos_medico="turnos_medico"></lista-turnos>
    </v-container>
      </div>
      
</template>


<script lang="ts">
import validarMedico from '@/components/medicos/validarMedico.vue';
import medicosList from '@/components/medicos/medicosList.vue';
import obraSocialList from '@/components/obrasSociales/obraSocialList.vue';
import especialidadesList from '@/components/especialidades/especialidadesList.vue';
import verificarPaciente from '@/components/paciente/verificarPaciente.vue';
import FechaTurno from '@/components/turnos/FechaTurno.vue';
import Hora from '@/components/turnos/Hora.vue';
import Motivo from '@/components/turnos/Motivo.vue';
import ListaTurnos from '@/components/turnos/ListaTurnos.vue';
import { Medico }  from '../../rest/medico';
import Turnos, { Turno} from '../../rest/turno';
import { ObraSocial } from '../../rest/obraSocial';




export default {
   
  components: {
    obraSocialList,
    'vermedico':validarMedico,
    'medico' : medicosList,
    especialidadesList,
    'verpac' : verificarPaciente,
    'fechaTurno' : FechaTurno,
    'hora' : Hora,
    'motivo' : Motivo,
    validarMedico,
    'listaTurnos':ListaTurnos,
 
  },

  data () {
    return {
      medico:[],
      pacientes:[],
      turnos_medico:[],
      turnos:[],
      id:0,
      hor_dis:[],
      fechaTurno :'',
        
      }
  },

  created: function() {
 
    },

  methods:{
         obtenerMedico: function(medico) {
            this.$data.medico = medico
            console.log('!!!!!', this.$data.medico)
            console.log("agrego el medico: ", medico )
            console.log("este medico tengo: ", this.$data.medico)
   
          },  

      obtenerFechaTurno: function(fechaTurno) {
        this.$data.fechaTurno = fechaTurno
        console.log("esta fecha tengo111111: ", this.$data.fechaTurno )
      },
     crearListaTurnos: async function() {
      try {
        this.$data.turnos_medico=[];
        const response = await Turnos.getRestApi().getAllTurnos();
        console.log("response: ",response );
        this.$data.turnos = response.data ;
        for (var i = 0; i < this.$data.turnos.content.length; i++) {
              //filtro por id medico y fecha
              if((this.$data.fechaTurno==this.$data.turnos.content[i].fecha)&&
              (this.$data.medico.idMedico==this.$data.turnos.content[i].medico.idMedico)){
              this.$data.turnos_medico.push(this.$data.turnos.content[i]);
              }
          }
        console.log("los turnos del medico", this.$data.turnos_medico);


      } catch (error) {
        this.emitError(error);
      }
    },

     

  }
}
  

</script>