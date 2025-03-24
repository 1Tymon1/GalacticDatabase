import { Component, OnInit } from '@angular/core';
import { ColonyService } from "../../service/colony.service";
import { Colonies } from "../../model/colonies";
import { Colony } from "../../model/colony";
import {RouterLink} from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-colony-list',
  templateUrl: './colony-list.component.html',
  standalone: true,
  imports: [
    RouterLink,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./colony-list.component.css']
})
export class ColonyListComponent implements OnInit{

  constructor(private service: ColonyService) {
  }

  colonies: Colonies | undefined;

  ngOnInit(): void {
    this.service.getColonies().subscribe(colonies => this.colonies = colonies);
  }

  onDelete(colony: Colony): void {
    this.service.deleteColony(colony.id).subscribe(() => this.ngOnInit());
  }

}
