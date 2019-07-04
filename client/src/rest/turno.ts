import Axios from "./axiosInstance";
import { AxiosPromise } from "axios";
import Pacientes, { Paciente } from "@/rest/paciente";
import Medicos, { Medico } from "@/rest/medico";
import ObrasSociales, { ObraSocial } from "@/rest/obraSocial";

/**
 * Turno.
 */
export class Turno {
  idTurno: number = 0;
  fecha: string = "";
  hora: string = "";
  motivoConsulta: string = "";
  paciente: Paciente = new Paciente() ;
  medico:  Medico = new Medico() ;
  obraSocial:  ObraSocial = new ObraSocial() ;
  constructor() { };
  public setidTurno(idTurno:number){
    this.idTurno = idTurno;
  }

}

/**
 * REST interface provided for Turno.
 */
export interface TurnosRestApi {
  createTurno(item: Turno): AxiosPromise<Turno>;
  updateTurno(updated: Turno): AxiosPromise<Turno>;
  getTurno(id: number): AxiosPromise<Turno>;
  getAllTurnos(): AxiosPromise<Turno[]>;
}

/**
 * REST implementation provided for medico.
 */
class Implementation implements TurnosRestApi {
    getAllTurnos(): AxiosPromise<Turno[]> {
        throw new Error("Method not implemented.");
   }
  createTurno(item: Turno): AxiosPromise<Turno> {
    return Axios.axiosInstance().post<Turno>("/turno", item);
  }
  updateTurno(updated: Turno): AxiosPromise<Turno> {
    return Axios.axiosInstance().put<Turno>(`/Turno`, updated);
  }
  getTurno(id: number): AxiosPromise<Turno> {
    return Axios.axiosInstance()
      .get<Turno>(`/Turno/${id}`)
      .then(result => {
        return result;
      });
  }
  getTurnoEspecialidad(especialidad: string): AxiosPromise<Turno[]> {
    return Axios.axiosInstance()
      .get<Turno[]>(`/Turno/especialidad/${especialidad}`)
      .then(result => {
        return result;
      });
  }
}

const Turnos = {
  getRestApi(): TurnosRestApi {
    const api = new Implementation();
    return api;
  }
};

export default Turnos;