import Axios from './axiosInstance';
import { AxiosPromise } from 'axios';

/**
 * ObraSocial.
 */
export class ObraSocial{
  id_obra_social: number = 0;
  direccion: string = "";
  nombre: string = "";

  constructor() { }
}

/**
 * REST interface provided for obraSocial.
 */
export interface ObraSocialRestApi {
  createObraSocial(item: ObraSocial): AxiosPromise<ObraSocial>;
  updateObraSocial(updated: ObraSocial): AxiosPromise<ObraSocial>;
  getObraSocial(id: number): AxiosPromise<ObraSocial>;
  getAllObrasSociales(): AxiosPromise<ObraSocial[]>;
}

/**
 * REST implementation provided for obraSocial.
 */
class Implementation implements ObraSocialRestApi {
  getAllObrasSociales(): AxiosPromise<ObraSocial[]> {
    return Axios.axiosInstance().get<ObraSocial[]>("/obraSocial");
  }
  createObraSocial(item: ObraSocial): AxiosPromise<ObraSocial> {
    return Axios.axiosInstance().post<ObraSocial>("/obraSocial", item);
  }
  updateObraSocial(updated: ObraSocial): AxiosPromise<ObraSocial> {
    return Axios.axiosInstance().put<ObraSocial>("/obraSocial", updated);
  }
  getObraSocial(id: number): AxiosPromise<ObraSocial> {
    return Axios.axiosInstance()
      .get<ObraSocial>(`/medico/${id}`)
      .then(result => {
        return result;
      });
  }
}

const ObrasSociales = {
  getRestApi(): ObraSocialRestApi {
    const api = new Implementation();
    return api;
  }
};

export default ObrasSociales;