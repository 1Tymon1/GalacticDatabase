import { Component, OnInit } from '@angular/core';
import { ColonyService } from "../../service/colony.service";
import { ActivatedRoute, Router } from "@angular/router";
import { ColonyDetails } from "../../model/colony-details";
import {NgIf} from '@angular/common';

/**
 * Preview of single colony.
 */
@Component({
  selector: 'app-colony-view',
  templateUrl: './colony-view.component.html',
  standalone: true,
  imports: [
    NgIf
  ],
  styleUrls: ['./colony-view.component.css']
})
export class ColonyViewComponent implements OnInit {

  colony: ColonyDetails | undefined;

  constructor(private service: ColonyService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getColony(params['uuid'])
        .subscribe(colony => this.colony = colony)
    });
  }

}


