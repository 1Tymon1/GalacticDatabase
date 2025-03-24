import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Colonies } from "../model/colonies";
import { ColonyDetails } from "../model/colony-details";
import { ColonyForm } from "../model/colony-form";
import { ColonyPatchForm } from "../model/colony-patch-form";


@Injectable({providedIn: 'root'})
export class ColonyService {

  constructor(private http: HttpClient) {

  }

  getColonies(): Observable<Colonies> {
    return this.http.get<Colonies>('/api/colonies');
  }

  getColoniesByEmpire(id: string): Observable<Colonies>{
    return this.http.get<Colonies>('/api/empires/' + id + '/colonies');
  }

  getColony(uuid: string): Observable<ColonyDetails> {
    return this.http.get<ColonyDetails>('/api/colonies/' + uuid);
  }

  deleteColony(uuid: string): Observable<any> {
    return this.http.delete('/api/colonies/' + uuid);
  }

  putColony(uuid: string, request: ColonyForm): Observable<any> {
    return this.http.put('/api/colonies/' + uuid, request);
  }

  patchColony(uuid: string, request: ColonyPatchForm): Observable<any> {
    return this.http.patch('/api/colonies/' + uuid, request);
  }

}
