<template>
  <div class="home">
    <v-container>
    <v-layout>
    <v-flex xs3>
        <v-card dark color="blue lighten-4" class="pa-3 ma-4">
          <v-card-text class="px-0"></v-card-text>
          <v-img
          :src = "`https://cdn2.iconfinder.com/data/icons/office-and-business-special-set-1/260/18-512.png`">
          </v-img>
          <v-btn block :small=true color="primary" to="registrar">Registrar Turno</v-btn>
        </v-card>
      </v-flex>
<!--<v-flex xs3>
        <v-card dark color="blue lighten-4" class="pa-3 ma-4">
          <v-card-text class="px-0"></v-card-text>
          <v-img
          :src = "`http://www.caslon.dudley.sch.uk/wp-content/uploads/65-658603_in-2016-wic-served-two-thirds-of-all.png`">
          </v-img>
          <v-btn block small="true" color="primary" to="paciente">Paciente -Turnos</v-btn>
        </v-card>
      </v-flex> -->
       <v-flex xs3 justify-center>
        <v-card dark color="blue lighten-4" class="pa-3 ma-4">
          <v-card-text class="px-0"></v-card-text>
          <v-img
          :src = "`https://cdn4.iconfinder.com/data/icons/people-of-medical-education-and-science/512/People_Medical_Education_Science_surgeon-05-512.png`">
          </v-img>
          <v-btn block :small=true color="primary" to="medicoTurnos">Medico -Turnos</v-btn>
        </v-card>
      </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Turno from '@/components/turnos/Turno.vue';

@Component({
  name: 'obraSocial',
  components: {
    Turno,
  },
})
export default class Home extends Vue {

}
</script>
