<template>
  <div class="home">
    <v-container>
      <v-btn color="primary" to="registrar">Registrar Turno</v-btn>
      <!--<v-btn color="primary" to="paciente">Paciente -Turnos</v-btn>-->
      <v-btn color="primary" to="verPaciente">Medico -Turnos</v-btn>
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
