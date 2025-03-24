import { Component, OnInit } from '@angular/core';
import { EmpireService } from "../../service/empire.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import { EmpireDetails } from "../../model/empire-details";
import {NgForOf, NgIf} from '@angular/common';
import {Colonies} from '../../../colony/model/colonies';
import {ColonyService} from '../../../colony/service/colony.service';
import {Colony} from '../../../colony/model/colony';

/**
 * Preview of single empire.
 */
@Component({
  selector: 'app-empire-view',
  templateUrl: './empire-view.component.html',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./empire-view.component.css']
})
export class EmpireViewComponent implements OnInit {

  empire: EmpireDetails | undefined;
  colonies: Colonies | undefined;

  constructor(private service: EmpireService, private route: ActivatedRoute, private router: Router, private colonyService: ColonyService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getEmpire(params['uuid'])
        .subscribe(empire => this.empire = empire)
    });
    this.route.params.subscribe(params => {
      this.colonyService.getColoniesByEmpire(params['uuid'])
        .subscribe(colonies => this.colonies = colonies)
    });
  }

  onDelete(colony: Colony): void {
    this.colonyService.deleteColony(colony.id).subscribe(() => this.ngOnInit());
  }

}


