import { Component, OnInit } from '@angular/core';
import { ColonyService } from '../../service/colony.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { ColonyForm } from '../../model/colony-form';
import {ColonyPatchForm} from '../../model/colony-patch-form';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-colony-edit',
  templateUrl: './colony-edit.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf
  ],
  styleUrls: ['./colony-edit.component.css']
})
export class ColonyEditComponent implements OnInit {

  uuid: string | undefined;

  colony: ColonyPatchForm | undefined;

  original: ColonyPatchForm | undefined;

  constructor(
    private colonyService: ColonyService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.colonyService.getColony(params['uuid'])
        .subscribe(colony => {
          this.uuid = colony.id;
          this.colony = {
            name: colony.name,
            population: colony.population,
            mainExport: colony.mainExport,
          };
          this.original = {...this.colony};
        });
    });
  }

  onSubmit(): void {
    this.colonyService.patchColony(this.uuid!, this.colony!)
      .subscribe(() => this.router.navigate(['/colonies']));
  }

}



