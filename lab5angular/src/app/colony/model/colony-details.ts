import {EmpireId} from './EmpireId';

export interface ColonyDetails {
  id: string;

  name: string;

  population: number;

  environment: string;

  mainExport: string;

  empire: EmpireId;

}
