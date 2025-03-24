import {EmpireId} from './EmpireId';

export interface ColonyForm {
  name: string;

  population: number;

  environment: string;

  mainExport: string;

  empire: EmpireId;

}
