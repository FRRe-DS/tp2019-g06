<template>
  <div class="col-md-4">
    <v-container fluid>
      <v-layout wrap>
        <v-flex xs12 md4>
          <h2 @click="prueba()">probar aqui</h2>
          <v-combobox
            v-model="select"
            return-object
            :items="especialidad"
            chips
            label="Especialidad"
            @input="mandar(select)"
  
            @click="getMedicosEspecialidad()"
          >
            <template v-slot:selection="data">
              <v-chip
                :key="JSON.stringify(data.item)"
                :selected="data.selected"
                :disabled="data.disabled"
                class="v-chip--select-multi"
                @click.stop="data.parent.selectedIndex = data.index"
                @input="data.parent.selectItem(data.item)"
              >
                <v-avatar class="accent white--text">{{ data.item.slice(0, 1).toUpperCase() }}</v-avatar>
                {{ data.item }}
              </v-chip>
            </template>
          </v-combobox>
        </v-flex>
      </v-layout>
    </v-container>
  </div>
</template>
  

<script>
import Medicos from "@/rest/medico";
import MedicoObraSocial from "@/rest/medicoobrasocial";

export default {
  props: ["obraSocial"],
   data() {
    return {
      select: "Buscar",
      medicos: [],
      especialidad: [],
      esp: "",
      obraSocial: { idObraSocial: 0, nombre: "", direccion: "" },
      medicosobrasociales: [],

      filtro: []
    };
  },

  created: function() {
    this.getMeObSoc();
    this.getMedicosEspecialidad();
  },

  methods: {
    prueba() {
      this.getMeObSoc();
      console.log("medico obrasocial", this.$data.medicosobrasociales);

      console.log("recibi la obra en espe ", this.obraSocial);
    },

    getMeObSoc: async function() {
      try {
        this.medicosobrasociales = [];
        const response = await MedicoObraSocial.getRestApi().getAllMedicoObraSocial();
        console.log("Response medobrsoc: ", response);
        this.$data.filtro = response.data.content;
        console.log("Response medobrsoc: ", this.$data.filtro);
        if (this.obraSocial == null) {
           for (var i = 0; i < this.$data.filtro.length; i++) {
             if (this.$data.medicosobrasociales.includes( this.$data.filtro[i].idMedico) == 0 ) {
                this.$data.medicosobrasociales.push(this.$data.filtro[i].idMedico);
              }
          
            console.log( "Medicos Obras SOciales: ", this.$data.medicosobrasociales);
          
          }
        }else {
         for (var i = 0; i < this.$data.filtro.length; i++) {
          if ( this.$data.filtro[i].idObraSocial == this.obraSocial.idObraSocial) {
            this.$data.medicosobrasociales.push(this.$data.filtro[i].idMedico);
            console.log("Medicos Obras SOciales: ",this.$data.medicosobrasociales);
          }
        }
      }
      
      } catch (error) {
        this.emitError(error);
      }
    },

    getMedicosEspecialidad: async function() {
      try {
        this.getMeObSoc();
        this.especialidad = [];
        const response = await Medicos.getRestApi().getAllMedicos();
        console.log("Response: ", response);
        this.$data.medicos = response.data.content;
        if (this.obraSocial == null) {
          for (var i = 0; i < this.$data.medicos.length; i++) {
            if (this.$data.especialidad.includes( this.$data.medicos[i].especialidad) == 0 ) {
              this.$data.especialidad.push(this.$data.medicos[i].especialidad);
            }
          }
        } else {
          this.especialidad = [];
          console.log("id medico de medico ", this.$data);
          console.log("id medico medicoobrasociales",this.$data.medicosobrasociales);
          for (var i = 0; i < this.$data.medicos.length; i++) {
            if ((this.$data.especialidad.includes(this.$data.medicos[i].especialidad) == 0 ) &&
              (this.$data.medicosobrasociales.includes(this.$data.medicos[i].idMedico) == 1 )) {
              console.log("funcionaobra");
              this.$data.especialidad.push(this.$data.medicos[i].especialidad);
            }
          }
        }
        console.log("Especialidad: ", this.$data.especialidad);
      } catch (error) {
        this.emitError(error);
      }
    },
    clearSelectedMedico: function() {
      this.$data.selected = null;
    },
    mandar(item) {
      console.log(item);
      this.$emit("mandar", item);
    },

    emitError: function(error) {
      this.$emit("showError", error);
    }
  }
};
</script>