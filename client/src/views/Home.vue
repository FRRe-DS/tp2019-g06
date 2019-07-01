<template>
  <div class="home">
    <v-container>
    <h2>Para registrar su turno correctamente por favor siga los siguientes pasos: </h2>
    <br/>
    <h3>1. Ingrese su Dni y luego presione enter</h3>
    <verificarPaciente/>
    <medicosList/>
    <h3>4. Seleccione Fecha y Hora</h3><br/>
    <FechaHora/>
    <h3>5. Presione Registrar Turno</h3><br/>
    <Turno/>
    </v-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import obraSocialList from '@/components/obrasSociales/obraSocialList.vue';
import medicosList from '@/components/medicos/medicosList.vue';
import especialidadesList from '@/components/especialidades/especialidadesList.vue';
import RegistrarTurno from '@/components/turnos/RegistrarTurno.vue';
import verificarPaciente from '@/components/paciente/verificarPaciente.vue';
import Turno from '@/components/turnos/Turno.vue';
import FechaHora from '@/components/turnos/FechaHora.vue';
@Component({
  name: 'obraSocial',
  components: {
    obraSocialList,
    medicosList,
    especialidadesList,
    RegistrarTurno,
    verificarPaciente,
    Turno,
    FechaHora,
  },
})
export default class Home extends Vue {

}
</script>
