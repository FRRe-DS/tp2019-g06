import Axios from "./axiosInstance";
import { AxiosPromise } from "axios";



/**
 * Turno.
 */
export class MedicoObraSocial {
    idMedicoObraSocial: number = 0;
  idMedico: number = 0;
  idObraSocial: number = 0;
  constructor() { }
}

/**
 * REST interface provided for MedicoObraSocial.
 */
export interface MedicoObraSocialRestApi {
  createMedicoObraSocial(item: MedicoObraSocial): AxiosPromise<MedicoObraSocial>;
  updateMedicoObraSocial(updated: MedicoObraSocial): AxiosPromise<MedicoObraSocial>;
  getMedicoObraSocial(id: number): AxiosPromise<MedicoObraSocial>;
  getAllMedicoObraSocial(): AxiosPromise<MedicoObraSocial[]>;
}

/**
 * REST implementation provided for MedicoObraSocial
 */
class Implementation implements MedicoObraSocialRestApi {
    getAllMedicoObraSocial(): AxiosPromise<MedicoObraSocial[]> {
        return Axios.axiosInstance().get<MedicoObraSocial[]>("/medicoObraSocial");
      }
  createMedicoObraSocial(item: MedicoObraSocial): AxiosPromise<MedicoObraSocial> {
    return Axios.axiosInstance().post<MedicoObraSocial>("/medicoObraSocial", item);
  }
  updateMedicoObraSocial(updated: MedicoObraSocial): AxiosPromise<MedicoObraSocial> {
    return Axios.axiosInstance().put<MedicoObraSocial>(`/medicoObraSocial`, updated);
  }
  getMedicoObraSocial(id: number): AxiosPromise<MedicoObraSocial> {
    return Axios.axiosInstance()
      .get<MedicoObraSocial>(`/medicoObraSocial/${id}`)
      .then(result => {
        return result;
      });
  }
 
  }


const MedicoObraSociales = {
  getRestApi(): MedicoObraSocialRestApi {
    const api = new Implementation();
    return api;
  }
};

export default MedicoObraSociales;