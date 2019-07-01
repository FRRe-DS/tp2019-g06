<template>
  <v-data-table
    :headers="headers"
    :items="obrasSociales"
    class="elevation-1"
  >
    <template v-slot:items="props">
   
      <td class="text-xs-right">{{ props.item.id_obra_social }}</td>
      <td class="text-xs-right">{{ props.item.nombre }}</td>
      <td class="text-xs-right">{{ props.item.direccion }}</td>
    </template>
  </v-data-table>
</template>

<script>
import ObrasSociales from '@/rest/obraSocial';

export default {
  data() {
    return {
      headers: [
        {
          text: 'Id',
          align: 'left',
          sortable: true,
          value: 'id',
        },
        {
          text: 'Nombre',
          align: 'right',
          sortable: true,
          value: 'nombre' },
        {
          text: 'Direccion',
          align: 'right',
          sortable: true,
          value: 'apellido' },
      ],
      obrasSociales: [],
    };
  },

  created: function() {
    this.getObrasSociales();
  },

  methods: {
    getObrasSociales: async function() {
      try {
        const response = await ObrasSociales.getRestApi().getAllObrasSociales();
        console.log('Response: ', response);
        this.$data.obrasSociales = response.data.content;
        console.log('ObrasSociales: ', this.$data.obrasSociales);
      } catch (error) {
        this.emitError(error);
      }
    },
    clearSelectedObraSocial: function() {
      this.$data.selected = null;
    },
    emitError: function(error) {
      this.$emit('showError', error);
    },
  },
}
</script>
