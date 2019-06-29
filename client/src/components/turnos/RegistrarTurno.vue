<template>
  <div class="turno">
    <medico-list></medico-list>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import medicosList from '@/components/medicos/medicosList.vue';


export default {
  components: {
    'medicoList': medicosList,
  },
}
  

</script>
