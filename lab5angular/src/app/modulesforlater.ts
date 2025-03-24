import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { EmpireListComponent } from './empire/view/empire list/empire-list.component';
import { HttpClientModule } from "@angular/common/http";
import { EmpireService } from "./empire/service/empire.service";
import { ColonyListComponent } from './colony/view/colony-list/colony-list.component';
import { ColonyService } from './colony/service/colony.service';
import { ColonyViewComponent } from './colony/view/colony-view/colony-view.component';
import { ColonyEditComponent } from './colony/view/colony-edit/colony-edit.component';
import { FormsModule } from "@angular/forms";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    EmpireListComponent,
    ColonyListComponent,
    ColonyViewComponent,
    ColonyEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ColonyService,
    EmpireService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class Modulesforlater {

}

