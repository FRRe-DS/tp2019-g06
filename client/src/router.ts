import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import RegistrarTurno from './views/RegistrarTurno.vue';
import VerPaciente from './views/VerPaciente.vue';
import Paciente from './views/Paciente.vue';
import Medico from './views/Medico.vue';
import CMedicoTurno from './views/CMedicoTurno.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/registrar',
      name: 'registrar',
      component: RegistrarTurno,
    },
    {
      path: '/paciente',
      name: 'paciente',
      component: Paciente,
    },
    {
      path: '/medicoTurnos',
      name: 'medicoTurnos',
      component: CMedicoTurno,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue'),
    },
  ],
});
