<template>
  <div class="home">
    <v-container>
      <Turno/>
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
