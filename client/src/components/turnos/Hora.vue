<template>
  <v-container>
  <v-layout wrap>
    <v-flex xs12 sm6 md6 xl6  >
       <h3> Seleccione hora de consulta </h3>
        <!--<v-time-picker
        v-model="hora"
        :allowed-minutes="allowedStep"
        max="14:00"
        min="08:00"
        class="mt-3"
        format="24hr"
        v-on:click="enviarHora(hora)"
      ></v-time-picker>-->
      <!--<v-menu
        ref="menu"
        v-model="menu2"
        :close-on-content-click="false"
        :nudge-right="40"
        :return-value.sync="time"
        lazy
        transition="scale-transition"
        offset-y
        full-width
        max-width="290px"
        min-width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="time"
            label="Hora"
            prepend-icon="access_time"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-time-picker
          v-if="menu2"
          v-model="time"
          full-width
          @click:minute="$refs.menu.save(time)"
          @input="enviarHora(time)"
        ></v-time-picker>
      </v-menu>-->
        <v-combobox
          v-model="hora"
          :items="horario"
          chips
          label="Hora"
          @input="enviarHora(hora)"
        ></v-combobox>
     
          <template v-slot:selection="data">
            <v-chip
              :key="JSON.stringify(data.item)"
              :selected="data.selected"
              :disabled="data.disabled"
              class="v-chip--select-multi"
              @click.stop="data.parent.selectedIndex = data.index"
              @input="data.parent.selectItem(data.item)"
            >
              <v-avatar class="accent white--text">
                {{ data.item.slice(0, 1).toUpperCase() }}
              </v-avatar>
              {{ data.item }}
            </v-chip>
          </template>
 </v-flex>
  </v-layout>
  
</v-container>
</template>

<script>
  export default {
    data () {
      return {
       //time: null,
       //minimo: new Date().toISOString().substr(0, 10),
       //menu2: false,
       //modal2: false,
       horario:["8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00"],
      }
      
    },

    methods:{
      enviarHora(hora) {
      console.log("estoy mandando una hora", hora);
       this.$emit('enviarHora', hora)
    },
    }
  }
</script>