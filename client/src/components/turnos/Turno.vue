<template>
  <div class="turnos">
      <template>
        <h2>Para registrar su turno correctamente por favor siga los siguientes pasos: </h2>
        <br/>
        <h3>1. Ingrese su Dni y luego presione enter</h3>
        <verpac v-on:mandarPaciente="obtenerPaciente($event)"></verpac>
        <medico :obraSocial="obraSocial" v-on:enviarMedico="obtenerMedico($event)"></medico>
        <!--  v-on:enviarMedico="obtenerMedico($event)"-->
        <h3>4. Seleccione Fecha y Hora</h3><br/>
        <fecha :idm="idm" v-on:enviarFecha="obtenerFecha($event)"></fecha>
        <hora :hor_dis="hor_dis" v-on:enviarHora="obtenerHora($event)"></hora>
        <h3>5. Agregue el motivo de su consulta</h3><br/>
        <motivo v-on:enviarMotivo="obtenerMotivo($event)"></motivo>
        <h3>6. Presione Registrar Turno</h3><br/>
      <v-layout align-center>
     <v-flex xs12 sm4 text-xs-center>
        <v-btn color="primary" large @click="addToAPI()">Registrar Turno</v-btn>
      
      
    </v-flex>
  </v-layout>
</template>


  </div>
</template>

<script lang="ts">
import medicosList from '@/components/medicos/medicosList.vue';
import obraSocialList from '@/components/obrasSociales/obraSocialList.vue';
import especialidadesList from '@/components/especialidades/especialidadesList.vue';
import verificarPaciente from '@/components/paciente/verificarPaciente.vue';
import Fecha from '@/components/turnos/Fecha.vue';
import Hora from '@/components/turnos/Hora.vue';
import Motivo from '@/components/turnos/Motivo.vue';
import { Medico }  from '../../rest/medico';
import Turnos, { Turno} from '../../rest/turno';
import { ObraSocial } from '../../rest/obraSocial';




export default {
  components: {
    obraSocialList,
    'medico' : medicosList,
    especialidadesList,
    'verpac' : verificarPaciente,
    'fecha' : Fecha,
    'hora' : Hora,
    'motivo' : Motivo,
    
  },

  data () {
    return {
      turno:{idTurno:0,fecha:'' ,hora:'',motivoConsulta:'',
      paciente:{idPaciente:0,apellido:'',nombre:'',dni:0,fechaNacimiento:'',sexo:'', direccion:'',telefono:0, obraSocial:this.obraSocial},
      medico:{idMedico:0, apellido :'', nombre:'',dni:0, sexo:'', estadoCivil:'',direccion:'',matricula:0,especialidad:''},
      obraSocial:this.obraSocial},
      obraSocial:{idObraSocial:0, nombre:'',direccion:''},
      turnos:[],
      idm:0,
      hor_dis:[],
        
      }
  },

  created: function() {
    //this.obtenerPacientes();
    //this.obtenerFecha();
    //this.obtenerHora();
  
    
    },

  
  methods:{
    prueba: function(){
      var dat: Turno = new Turno();
        console.log(dat);
    },
    obtenerIdTurno: async function(variable){
      this.$data.turnos = [];
      try {
        var mayor=0;
        var arreglo=[];
        const response = await Turnos.getRestApi().getAllTurnos();
        console.log("response: ",response );
        this.$data.turnos = response.data ;
        for (var i = 0; i < this.$data.turnos.content.length; i++) {
              arreglo.push(this.$data.turnos.content[i].idTurno);
              }
         for(var i=0,len=arreglo.length;i<len;i++){
            if(mayor < arreglo[i]){
                        mayor = arreglo[i];
             }
               }
       variable= mayor;
      } catch (error) {
        this.emitError(error);
        
      }
    },
    addToAPI: async function() {
        try {
        var dat: Turno = new Turno();
        dat.idTurno=0;
        this.$data.turnos = [];
                try {
                  var mayor=0;
                  var arreglo=[];
                  const response = await Turnos.getRestApi().getAllTurnos();
                  console.log("response: ",response );
                  this.$data.turnos = response.data ;
                  for (var i = 0; i < this.$data.turnos.content.length; i++) {
                        arreglo.push(this.$data.turnos.content[i].idTurno);
                        }
                  for(var i=0,len=arreglo.length;i<len;i++){
                      if(mayor < arreglo[i]){
                                  mayor = arreglo[i];
                      }
                        }
                dat.idTurno= mayor+1;
                } catch (error) {
                  this.emitError(error);
                  
                }
      
       //  var obra: ObraSocial=new ObraSocial();
        dat.paciente= this.$data.turno.paciente;
        dat.medico= this.$data.turno.medico;
        dat.fecha= this.$data.turno.fecha;
        console.log("formato fecha", this.$data.turno.fecha )
        dat.hora= this.$data.turno.hora;
        dat.obraSocial=this.$data.turno.obraSocial;
      
        dat.motivoConsulta=this.$data.turno.motivoConsulta.toString();
        console.log(dat);
        if((typeof dat.paciente=="undefined")||(dat.hora=="")||(typeof dat.medico=="undefined")||(typeof dat.fecha=="undefined")||(dat.motivoConsulta=="")){
            alert("FALTAN COMPLETAR CAMPOS!!");
        }else{
          const response = Turnos.getRestApi().createTurno(dat);
        console.log("Registro turno: ", response);
        alert("Registro de turno Exitoso ");
        location.href="http://localhost:8081/";
        }
         
         } catch (error) {
           alert("no se pudo registar el turno");
         this.emitError(error.message);
           
         }
         },
  /*  crearTurno: async function() {
        
        http
        .post("/Turno", data)
        .then(response => {
          this.turno.idTurno = response.data.idTurno;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
 
    },*/
      obtenerPaciente: function(paciente) {
        
        this.$data.turno.paciente = paciente
        console.log('!!!!!', this.$data.turno.paciente.obraSocial)
        console.log("agrego el paciente: ", paciente )
        this.$data.obraSocial = this.$data.turno.paciente.obraSocial
       this.$data.turno.obraSocial=this.$data.obraSocial;
        console.log("obra social en turno ",this.$data.obraSocial)
        console.log("este paciente tengo: ", this.$data.turno.paciente )
        console.log("Ref: ", this.$children[0])
      },
      obtenerFecha: function(fh) {
        this.$data.turno.fecha = fh.fecha
        this.$data.hor_dis = fh.hor_dis
        console.log("agrego la fecha111111: ", fh.fecha)
        console.log("esta fecha tengo111111: ", this.$data.turno.fecha )
      },
      obtenerHora: function(hora) {
        this.$data.turno.hora = hora
        console.log("agrego la hora: ", hora )
        console.log("esta hora tengo: ", this.$data.turno.hora )
      },
      obtenerMedico: function(medico) {
        this.$data.turno.medico = medico
        this.$data.idm = this.$data.turno.medico.idMedico
        console.log("agrego el medico: ", medico )
        console.log("este medico tengo: ", this.$data.turno.medico )
      },
      obtenerMotivo: function(motivo) {
      
        console.log("agrego el motivo: ", motivo )
          this.$data.turno.motivoConsulta = motivo
        console.log("este motivo tengo: ", this.$data.turno.motivoConsulta )
      },
    
    
  }
}
  

</script>