import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpireListComponent } from "./empire/view/empire list/empire-list.component";
import { ColonyListComponent } from "./colony/view/colony-list/colony-list.component";
import { ColonyViewComponent } from "./colony/view/colony-view/colony-view.component";
import { ColonyEditComponent } from "./colony/view/colony-edit/colony-edit.component";
import {EmpireEditComponent} from './empire/view/empire edit/empire-edit.component';
import {EmpireViewComponent} from './empire/view/empire-view/empire-view.component';
import {ColonyCreateComponent} from './colony/view/colony-create/colony-create.component';
import {EmpireCreateComponent} from './empire/view/empire-create/empire-create.component';


export const routes: Routes = [
  {
    component: EmpireListComponent,
    path: "empires"
  },
  {
    component: EmpireCreateComponent,
    path: "empires/create"
  },
  {
    component: EmpireEditComponent,
    path: "empires/:uuid/edit"
  },
  {
    component: EmpireViewComponent,
    path: "empires/:uuid"
  },
  {
    component: ColonyListComponent,
    path: "colonies"
  },
  {
    component: ColonyViewComponent,
    path: "colonies/:uuid"
  },
  {
    component: ColonyEditComponent,
    path: "colonies/:uuid/edit"
  },
  {
    component: ColonyCreateComponent,
    path: "colonies/:uuid/create"
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
