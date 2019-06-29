<template>
  <div class="medicosList">
    <espe-list v-on:mandar="getMedicos($event)"></espe-list>
  <v-data-table
    :headers="headers"
    :items="medicos"
    class="elevation-1"
  >
    <template v-slot:items="props">
      <td>{{ props.item.id }}</td>
      <td class="text-xs-right">{{ props.item.nombre }}</td>
      <td class="text-xs-right">{{ props.item.apellido }}</td>
      <td class="text-xs-right">{{ props.item.dni }}</td>
      <td class="text-xs-right">{{ props.item.matricula }}</td>

    </template>
    
  </v-data-table>

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
      medicos:[],
     
    }
  },

  created: function() {
    this.getMedicos(buscarMedico);
  },

  methods: {
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