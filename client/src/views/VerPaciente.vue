<template>
  <div class="verPaciente">
    <v-container>
      <Ver/>
    </v-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Ver from '@/components/paciente/ver.vue';

@Component({
  components: {
    Ver,
  },
})

export default class VerPaciente extends Vue {

}
</script>
