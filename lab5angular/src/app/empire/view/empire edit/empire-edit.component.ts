import { Component, OnInit } from '@angular/core';
import { EmpireService } from '../../service/empire.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { EmpireForm } from '../../model/empire-form';
import {EmpirePatchForm} from '../../model/empire-patch-form';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-empire-edit',
  templateUrl: './empire-edit.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf
  ],
  styleUrls: ['./empire-edit.component.css']
})
export class EmpireEditComponent implements OnInit {

  uuid: string | undefined;

  empire: EmpirePatchForm | undefined;

  original: EmpirePatchForm | undefined;

  constructor(
    private empireService: EmpireService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.empireService.getEmpire(params['uuid'])
        .subscribe(empire => {
          this.uuid = empire.id;
          this.empire = {
            population: empire.population,
            starSystems: empire.starSystems,
          };
          this.original = {...this.empire};
        });
    });
  }

  onSubmit(): void {
    this.empireService.patchEmpire(this.uuid!, this.empire!)
      .subscribe(() => this.router.navigate(['/empires']));
  }

}



