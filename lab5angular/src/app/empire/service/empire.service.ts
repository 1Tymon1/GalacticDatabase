import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Empires } from "../model/empires";
import {EmpireForm} from '../model/empire-form';
import {EmpirePatchForm} from '../model/empire-patch-form';
import {EmpireDetails} from '../model/empire-details';


@Injectable({providedIn: 'root'})
export class EmpireService {

  constructor(private http: HttpClient) {

  }

  getEmpires(): Observable<Empires> {
    return this.http.get<Empires>('/api/empires');
  }

  getEmpire(uuid: string): Observable<EmpireDetails> {
    return this.http.get<EmpireDetails>('/api/empires/' + uuid);
  }

  deleteEmpire(uuid: string): Observable<any> {
    return this.http.delete('/api/empires/' + uuid);
  }

  putEmpire(uuid: string, request: EmpireForm): Observable<any> {
    return this.http.put('/api/empires/' + uuid, request);
  }

  patchEmpire(uuid: string, request: EmpirePatchForm): Observable<any> {
    return this.http.patch('/api/empires/' + uuid, request);
  }
}
