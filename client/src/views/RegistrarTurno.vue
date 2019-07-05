<template>
  <div class="registrar">
    <h2 class="grey darken-3 white--text">Seccion Paciente - Registrar Turno</h2>
      <Turno/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Turno from '@/components/turnos/Turno.vue';

@Component({
  components: {
    Turno,
  },
})
export default class RegistrarTurno extends Vue {

}
</script>
