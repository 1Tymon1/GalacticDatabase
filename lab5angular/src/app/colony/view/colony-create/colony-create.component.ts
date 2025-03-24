import { Component, OnInit } from '@angular/core';
import { ColonyService } from '../../service/colony.service';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import { ColonyForm } from '../../model/colony-form';
import {ColonyPatchForm} from '../../model/colony-patch-form';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-colony-create',
  templateUrl: './colony-create.component.html',
  standalone: true,
  imports: [
    FormsModule,
    RouterLink,
    NgIf,
    ReactiveFormsModule
  ],
  styleUrls: ['./colony-create.component.css']
})
export class ColonyCreateComponent implements OnInit {

  uuid: string | undefined;

  colony: ColonyForm | undefined;
  colonyForm1: FormGroup | undefined;

  constructor(
    private colonyService: ColonyService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.colonyForm1 = new FormGroup({
        name: new FormControl(),
        population: new FormControl(),
        mainExport: new FormControl(),
        environment: new FormControl(),
        empire: new FormControl(params['uuid'])
      });
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
    console.log(this.colonyForm1!.value)
    this.colony = {
      name: this.colonyForm1!.controls['name'].value,
      population: this.colonyForm1!.controls['population'].value,
      environment: this.colonyForm1!.controls['environment'].value,
      mainExport: this.colonyForm1!.controls['mainExport'].value,
      empire: this.colonyForm1!.controls['empire'].value
    }
    this.colonyService.putColony(this.uuid!, this.colony!)
      .subscribe(() => this.router.navigate(['/colonies']));
  }

}



