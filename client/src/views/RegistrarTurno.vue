<template>
  <div class="registrar">
    <v-container>
      <Turno/>
    </v-container>
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
