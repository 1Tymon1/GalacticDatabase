import { Component, OnInit } from '@angular/core';
import { Empires } from "../../model/empires";
import { Empire } from "../../model/empire";
import { EmpireService } from "../../service/empire.service";
import {NgForOf, NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';


@Component({
  selector: 'app-empire-list',
  templateUrl: './empire-list.component.html',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterLink
  ],
  styleUrls: ['./empire-list.component.css']
})
export class EmpireListComponent implements OnInit {

  constructor(private service: EmpireService) {
  }

  empires: Empires | undefined;

  ngOnInit(): void {
    this.service.getEmpires().subscribe(empires => this.empires = empires);
  }

  onDelete(empire: Empire): void {
    this.service.deleteEmpire(empire.id).subscribe(() => this.ngOnInit());
  }

}


