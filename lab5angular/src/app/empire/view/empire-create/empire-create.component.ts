import { Component, OnInit } from '@angular/core';

import {ActivatedRoute, Router, RouterLink} from '@angular/router';

import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {EmpireForm} from '../../model/empire-form';
import {EmpireService} from '../../service/empire.service';

@Component({
  selector: 'app-colony-create',
  templateUrl: './empire-create.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf,
    ReactiveFormsModule
  ],
  styleUrls: ['./empire-create.component.css']
})
export class EmpireCreateComponent implements OnInit {

  uuid: string | undefined;

  colony: EmpireForm | undefined;
  empireForm: FormGroup | undefined;

  constructor(
    private empireService: EmpireService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
      this.empireForm = new FormGroup({
        name: new FormControl(),
        population: new FormControl(),
        starSystems: new FormControl(),
      });

    this.uuid = this.generateJavaUUID();
  }

    generateJavaUUID(): string {
    const getRandomHex = (length: number): string => {
      let hex = '';
      for (let i = 0; i < length; i++) {
        hex += Math.floor(Math.random() * 16).toString(16);
      }
      return hex;
    };

    // UUID format: 8-4-4-4-12
    const part1 = getRandomHex(8);
    const part2 = getRandomHex(4);
    const part3 = getRandomHex(4);
    const part4 = getRandomHex(4);
    const part5 = getRandomHex(12);

    // Assemble the UUID string
    return `${part1}-${part2}-${part3}-${part4}-${part5}`;
  }

  onSubmit(): void {
    console.log(this.empireForm!.value)
    this.colony = {
      name: this.empireForm!.controls['name'].value,
      population: this.empireForm!.controls['population'].value,
      starSystems: this.empireForm!.controls['starSystems'].value,
    }
    this.empireService.putEmpire(this.uuid!, this.colony!)
      .subscribe(() => this.router.navigate(['/colonies']));
  }

}



