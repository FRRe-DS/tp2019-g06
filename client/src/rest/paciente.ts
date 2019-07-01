import Axios from "./axiosInstance";
import { AxiosPromise } from "axios";
import ObraSocial from "./obraSocial";

/**
 * Paciente.
 */

export class Paciente {
  idPaciente: number = 0;
  apellido: string = "";
  nombre: string = "";
  dni: number = 0;
  fecha_nacimiento: Date = new Date();
  sexo: string = "";
  direccion: string = "";
  telefono: number = 0;
  constructor() { }
}

/**
 * REST interface provided for paciente.
 */
export interface PacienteRestApi {
  createPaciente(item: Paciente): AxiosPromise<Paciente>;
  updatePaciente(updated: Paciente): AxiosPromise<Paciente>;
  getPaciente(id: number): AxiosPromise<Paciente>;
  getAllPaciente(): AxiosPromise<Paciente[]>;
  getDniPaciente(id: number): AxiosPromise<Paciente>;
}

/**
 * REST implementation provided for paciente.
 */
class Implementation implements PacienteRestApi {
  getAllPaciente(): AxiosPromise<Paciente[]> {
    return Axios.axiosInstance().get<Paciente[]>("/paciente");
  }
  createPaciente(item: Paciente): AxiosPromise<Paciente> {
    return Axios.axiosInstance().post<Paciente>("/paciente", item);
  }
  updatePaciente(updated: Paciente): AxiosPromise<Paciente> {
    return Axios.axiosInstance().put<Paciente>(`/paciente`, updated);
  }
  getPaciente(id: number): AxiosPromise<Paciente> {
    return Axios.axiosInstance()
      .get<Paciente>(`/paciente/${id}`)
      .then(result => {
        return result;
      });
  }
  getDniPaciente(id: number): AxiosPromise<Paciente> {
    return Axios.axiosInstance()
      .get<Paciente>(`/paciente/dni/${id}`)
      .then(result => {
        return result;
      });
  }
}

const Pacientes = {
  getRestApi(): PacienteRestApi {
    const api = new Implementation();
    return api;
  }
};

export default Pacientes;