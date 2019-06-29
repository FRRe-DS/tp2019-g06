<template>
  <div class="home">
   <RegistrarTurno/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import obraSocialList from '@/components/obrasSociales/obraSocialList.vue';
import medicosList from '@/components/medicos/medicosList.vue';
import especialidadesList from '@/components/especialidades/especialidadesList.vue';
import RegistrarTurno from '@/components/turnos/RegistrarTurno.vue';

@Component({
  name: 'obraSocial',
  components: {
    obraSocialList,
    medicosList,
    especialidadesList,
    RegistrarTurno,
  },
})
export default class Home extends Vue {

}
</script>
