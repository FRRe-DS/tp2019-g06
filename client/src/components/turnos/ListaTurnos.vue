<template>
  <v-data-table
    :headers="headers"
    :items="this.turnos_medico"
    class="elevation-1"
  >
    <template v-slot:items="props">
      <td class="text-xs-right">{{ props.item.fecha }}</td>
      <td class="text-xs-right">{{ props.item.hora }}</td>
      <td class="text-xs-right">{{ props.item.paciente.apellido }}</td>
      <td class="text-xs-right">{{ props.item.paciente.nombre }}</td>
      <td>{{ props.item.paciente.dni  }}</td>
      <td class="text-xs-right">{{ props.item.motivoConsulta }}</td>
    </template>
  </v-data-table>
</template>

<script>
import Turnos, { Turno} from '../../rest/turno';

export default {
    props: ['turnos_medico'],
  data () {
    return {
      headers: [
        { 
          text: 'Fecha Turno', 
          align: 'center',
          sortable: false,
          value: 'fecha' 
        },
        { 
          text: 'Hora', 
          align: 'center',
          sortable: true,
          value: 'hora' 
        },
        { 
          text: 'Apellido', 
          align: 'right',
          sortable: false,
          value: 'apellido' },
        { 
          text: 'Nombre', 
          align: 'right',
          sortable: false,
          value: 'nombre' },
        {
          text: 'Dni',
          align: 'center',
          sortable: false,
          value: 'dni'
        },
        { 
          text: 'Motivo de Consulta', 
          align: 'center',
          sortable: false,
          value: 'motivoConsulta' 
        }
      ],
      turnos: [],
    }
  },

  created: function() {
   
  },

  methods: {
    getTurnos: async function() {
      try {
        const response = await Turnos.getRestApi().getAllTurnos();
        console.log("Response: ", response);
        this.$data.turnos = response.data.content;
        console.log("turnos: ", this.$data.turnos);
      } catch (error) {
        this.emitError(error);
      }
    },
    clearSelectedTurno: function() {
      this.$data.selected = null;
    },
    emitError: function(error) {
      this.$emit("showError", error);
    }
  }
}
</script>