<template>
  <div class="cmedicoturno">
      <h2 class="grey darken-3 white--text"> Seccion Paciente - Registrar Turno</h2>
      <medicoTurnos/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import medicoTurnos from '@/components/medicos/medicoTurnos.vue';

@Component({
  components: {
    medicoTurnos,
  },
})

export default class CMedicoTurno extends Vue {

}
</script>
