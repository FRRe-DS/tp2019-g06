<template>
  <div class="home">
    <obraSocialList/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import obraSocialList from '@/components/obrasSociales/obraSocialList.vue';

@Component({
  name: 'obraSocial',
  components: {
    obraSocialList
  },
})
export default class Home extends Vue {}
</script>
