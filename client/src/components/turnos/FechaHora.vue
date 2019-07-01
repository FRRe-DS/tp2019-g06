<template>
  <div class="fechahora">
  <v-container>
  <v-layout wrap>
    <!--<v-flex xs12 sm6 md6 xl6 >
      <v-date-picker v-model="fecha" 
      :show-current="false"
       locale="es-ar"
       :min="minimo"
       ></v-date-picker>
    </v-flex>-->
    <v-flex xs12 sm6 md4>
      <v-menu
        ref="menu"
        v-model="menu"
        :close-on-content-click="false"
        :nudge-right="40"
        :return-value.sync="date"
        lazy
        transition="scale-transition"
        offset-y
        full-width
        min-width="290px"
      >
        <template v-slot:activator="{ on }">
          <v-text-field
            v-model="date"
            label="Picker in menu"
            prepend-icon="event"
            readonly
            v-on="on"
          ></v-text-field>
        </template>
        <v-date-picker v-model="date" no-title scrollable>
          <v-spacer></v-spacer>
          <v-btn flat color="primary" @click="menu = false">Cancel</v-btn>
          <v-btn flat color="primary" @click="$refs.menu.save(date)">OK</v-btn>
        </v-date-picker>
      </v-menu>
    </v-flex>
    <v-spacer></v-spacer>
    <v-flex xs11 sm5>
      <v-menu
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
            label="Picker in menu"
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
        ></v-time-picker>
      </v-menu>
    </v-flex>
    <v-spacer></v-spacer>
    <!--<v-flex xs12 sm6 md6 xl6  >
        <v-time-picker
        v-model="hora"
        :allowed-minutes="allowedStep"
        max="14:00"
        min="08:00"
        class="mt-3"
        format="24hr"
      ></v-time-picker>
      {{hora}}
    </v-flex>-->
  </v-layout>
  </v-container>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        fecha:'',
        hora:'',
       minimo: new Date().toISOString().substr(0, 10),
      }
    }
  }
</script>