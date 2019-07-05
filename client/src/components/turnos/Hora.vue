<template>
    <v-flex xs2 sm2 md2>
        <v-combobox
          v-model="hora"
          :items="this.hor_dis"
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
</template>

<script>
  export default {
    props: ['hor_dis'],
    data () {
      return {
       //time: null,
       //minimo: new Date().toISOString().substr(0, 10),
       //menu2: false,
       //modal2: false,
       hora:'',
       horario:["8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00"],
      }
      
    },

    methods:{
      prueba(){
        console.log("prueba",this.hor_dis)
      },
      enviarHora(hora) {
      console.log("estoy mandando una hora", hora);
       this.$emit('enviarHora', hora)
    },
    }
  }
</script>