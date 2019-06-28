<template>
  <v-container fluid>
    <v-layout wrap>
      
      <v-flex xs12>
        <v-combobox
          v-model="select"
          :items="especialidad"
          chips
          label="Especialidad"
        >
          <template v-slot:selection="data">
            <v-chip
              :key="JSON.stringify(data.item)"
              :selected="data.selected"
              :disabled="data.disabled"
              class="v-chip--select-multi"
              @click.stop="data.parent.selectedIndex = data.index"
              @input="data.parent.selectItem(data.item)"
            >
              <v-avatar class="accent white--text">
                {{ data.item.slice(0, 1).toUpperCase() }}
              </v-avatar>
              {{ data.item }}
            </v-chip>
          </template>
        </v-combobox>
      </v-flex>
      
    </v-layout>
  </v-container>

</template>
  

<script>
import Medicos from "@/rest/medico";

export default {
  data () {
    return {
      select: 'Buscar',
      medicos: [],
      especialidad:[],
    }
  },

  created: function() {
    this.getMedicosEspecialidad();
  },

  methods: {
    getMedicosEspecialidad: async function() {
      try {
      
        const response = await Medicos.getRestApi().getAllMedicos();
        console.log("Response: ", response);
        this.$data.medicos = response.data.content;
       
                for(var i = 0; i < this.$data.medicos.length; i++) {
                     if  ((this.$data.especialidad.includes((this.$data.medicos[i]).especialidad))==0) {
                       this.$data.especialidad.push((this.$data.medicos[i]).especialidad);
                   }
                 }
        
        console.log("Especialidad: ", this.$data.especialidad);
      } catch (error) {
        this.emitError(error);
      }
    },
    clearSelectedMedico: function() {
      this.$data.selected = null;
    },
    emitError: function(error) {
      this.$emit("showError", error);
    }
  }
}
</script>