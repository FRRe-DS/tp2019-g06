import Axios from "./axiosInstance";
import { AxiosPromise } from "axios";

/**
 * Medico.
 */
export class Medico {
  idMedico: number = 0;
  apellido: string = "";
  nombre: string = "";
  dni: number = 0;
  sexo: string = "";
  estadoCivil: string = "";
  direccion: string = "";
  matricula: number = 0;
  especialidad: string = "";
  constructor() { }
  public getEspecialidad(){
      return this.especialidad;
  }
}

/**
 * REST interface provided for medico.
 */
export interface MedicosRestApi {
  createMedico(item: Medico): AxiosPromise<Medico>;
  updateMedico(updated: Medico): AxiosPromise<Medico>;
  getMedico(id: number): AxiosPromise<Medico>;
  getAllMedicos(): AxiosPromise<Medico[]>;
}

/**
 * REST implementation provided for medico.
 */
class Implementation implements MedicosRestApi {
  getAllMedicos(): AxiosPromise<Medico[]> {
    return Axios.axiosInstance().get<Medico[]>("/medico");
  }
  createMedico(item: Medico): AxiosPromise<Medico> {
    return Axios.axiosInstance().post<Medico>("/medico", item);
  }
  updateMedico(updated: Medico): AxiosPromise<Medico> {
    return Axios.axiosInstance().put<Medico>(`/medico`, updated);
  }
  getMedico(id: number): AxiosPromise<Medico> {
    return Axios.axiosInstance()
      .get<Medico>(`/medico/${id}`)
      .then(result => {
        return result;
      });
  }
  getMedicoEspecialidad(especialidad: string): AxiosPromise<Medico[]> {
    return Axios.axiosInstance()
      .get<Medico[]>(`/medico/especialidad/${especialidad}`)
      .then(result => {
        return result;
      });
  }
}

const Medicos = {
  getRestApi(): MedicosRestApi {
    const api = new Implementation();
    return api;
  }
};

export default Medicos;