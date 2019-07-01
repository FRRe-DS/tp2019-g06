<template>
  <div class="medicosList">
    <v-container>
    <h3>2. Seleccione la especialidad</h3><br/>
    <espe-list v-on:mandar="getMedicos($event)"></espe-list>
    <h3>3. Seleccione el Médico</h3><br/>
    <v-layout row :wrap="true" align-center>
     
      <v-flex xs2 sm2 md2 lg2 xl2>
        <v-subheader>Medicos</v-subheader>
      </v-flex>
      <v-flex xs4 sm4 md4 lg4 xl4 >
        <v-select
          v-model="select"
          :hint="`${select.especialidad}`"
          :items="medicos"
          item-text="nombre"
          item-value="apellido"
          label="Select"
          persistent-hint
          return-object
          single-line
        >
        
          <template slot="selection" slot-scope="data">
        
           {{ data.item.apellido }}   {{ data.item.nombre }}
          </template>
          <template slot="item" slot-scope="data">
         
             {{ data.item.apellido }}   {{ data.item.nombre }}
          </template>
        
        </v-select>
        
      </v-flex>
    </v-layout>

    </v-container>

  </div>
  
</template>

<script>
import Medicos from "@/rest/medico";
import especialidadesList from '@/components/especialidades/especialidadesList.vue';

export default {
  components: {
    'espeList': especialidadesList,
  },
  data () {
    return {
      headers: [
        {
          text: 'Id',
          align: 'left',
          sortable: true,
          value: 'id'
        },
        { 
          text: 'Nombre', 
          align: 'right',
          sortable: true,
          value: 'nombre' },
        { 
          text: 'Apellido', 
          align: 'right',
          sortable: true,
          value: 'apellido' },
        { 
          text: 'Fecha Nacimiento', 
          align: 'center',
          sortable: true,
          value: 'fechaNacimiento' 
        },
        { 
          text: 'Nro Matricula', 
          align: 'right',
          sortable: true,
          value: 'numeroMatricula' 
        }
      ],
       select: { nombre: '', apellido: '' },
      medicos:[],
     
    }
  },

  created: function() {
    this.getMedicos(buscarMedico);
  },

  methods: {
    prueba(){
      alert("selecciono un medico");
    },
    getMedicos: async function(buscarMedico) {
      try {
        const response = await Medicos.getRestApi().getMedicoEspecialidad(buscarMedico);
        console.log("aca no panza nada");
        console.log("Response: ", response);
        this.$data.medicos = response.data;
        console.log("Medicos: ",this.$data.medicos );
      } catch (error) {
        this.emitError(error);
      }
    },
    clearSelectedMedico: function() {
      this.$data.selected = null;
    },
    emitError: function(error) {
      this.$emit("showError", error);
    },
    buscarMedico: function(buscarMedico) {
      this.$data.espeSelecionada = buscarMedico;
       console.log('buscar por: ', this.$data.espeSelecionada);
      console.log('buscar por: ', buscarMedico)
    }
  }
}
</script>