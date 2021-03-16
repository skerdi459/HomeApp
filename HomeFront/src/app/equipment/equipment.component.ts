import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EquipmentService } from '../equipments/equipment.service';
import { Equipment } from '../models/equipment';
import { EquipmentsDto } from '../models/equipments-dto';
import { Attribute } from '../models/attribute';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-equipment',
  templateUrl: './equipment.component.html',
  styleUrls: ['./equipment.component.css']
})
export class EquipmentComponent implements OnInit {
 equipmentDto: EquipmentsDto;
 ID:string;
 equipment:Equipment;
  nestedForm: FormGroup;
  atributesList:Attribute[]
  errorMsg:boolean;
  errorS:string;
  constructor(private _fb: FormBuilder,
    private equipmentService:EquipmentService, 
    private toast:ToastrService,
    private router:Router,) { 
    
  }

  ngOnInit() {
    this.nestedForm = this._fb.group({
      id: [null, Validators.required],
      name: ['', [Validators.required, Validators.minLength(2)]],
      state: ['', Validators.required],
      type: ['', Validators.required],
      location: ['', Validators.required],

      attributes: this._fb.array([this.addAttributeGroup()])
    });
  }

  

  addAttributeGroup() {
    return this._fb.group({

      attributeId: [null, Validators.required],
      name: ['', Validators.required],
      min: ['', Validators.required],
      max: ['', Validators.required],
      current: ['', Validators.required],
      equipmentId: [null, Validators.required],

    });
  }



  
  addAttribute() {
    this.attributeArray.push(this.addAttributeGroup());
  }
  removeAttribute(index) {
    this.attributeArray.removeAt(index);
  }
  get attributeArray() {
    return <FormArray>this.nestedForm.get('attributes');
  }

  get id() {
    return this.nestedForm.get('id');
  }
 
  get name() {
    return this.nestedForm.get('name');
  }
  get state() {
    return this.nestedForm.get('state');
  }
  get type() {
    return this.nestedForm.get('type');
  }
  get location() {
    return this.nestedForm.get('location');
  }
  nrGenerator(){
    return '_' + Math.random().toString(36).substr(2, 9);
    }
 
 



  submitHandler() {
    
    this.ID=this.nrGenerator()
this.equipmentDto=this.nestedForm.value;
this.equipmentDto.id=this.ID;

this.atributesList=this.equipmentDto.attributes
    console.log(this.equipmentDto.attributes)
  
    this.atributesList.forEach(x=>{
      this.cmpMinMaxCurrent(x.min,x.max,x.current)
    })

console.log(this.equipmentDto)
if(this.errorMsg==true){
  this.toast.error(this.errorS)
  console.log(this.errorMsg)
  this.errorMsg=false;
  console.log(this.errorMsg)
}
else{
  this.equipmentService.addEquipment(this.equipmentDto);      
  console.log(this.equipmentDto);
   this.nestedForm.reset();
   this.toast.success("U shtua me sukses")
   this.router.navigateByUrl("")
   
}

  

  }


cmpMinMaxCurrent(min:number,max:number,current:number){
  if(min>max||min===max||current<min||max<min||current>max){
      this.errorMsg=true;
      this.errorS="gabim ne vendosjen e vlerave"
      return
       }
      this.errorMsg=false;
 
}
  
  }




 
 

 
 


 













  

