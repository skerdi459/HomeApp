import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Equipment } from '../models/equipment';
import { EquipmentService } from '../equipments/equipment.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-equipment-home',
  templateUrl: './equipment-home.component.html',
  styleUrls: ['./equipment-home.component.css']
})
export class EquipmentHomeComponent implements OnInit {



  constructor(   public dialog: MatDialog,
    private service:EquipmentService,
    private toast:ToastrService) { }
  dialogR:any
  appliance:Equipment[]
  appliances:Equipment[];
  problems:any[];
  tobeEdit:any;
  ngOnInit(): void {
    this.getAllApp();
    
  }

  getAllApp(){
    return this.service.getEquipmentss().subscribe(
     
      appliance=>{
        console.log("ja, keut")
        console.log("kjo eshte"+appliance)
        this.appliances=appliance;
        console.log(this.appliances[0].attributes);
       
        
      }
    )
  }

  findproblems(current:number,min:number,max:number):boolean{
   if(current<=min||current>=max){
     return true;
   }
   return false
  }

 
  increaseTemp(oneattr, templateRef){
    console.log(oneattr)
    this.tobeEdit=oneattr
    this.dialogR = this.dialog.open(templateRef)

  } 

  increase(id){
    console.log("iune jamee"+id)
     this.service.increaseV(id)
    this.toast.success("Editet")
    

  }

  decreaseTemp(oneattr, templateRef){
    console.log(oneattr)
    this.tobeEdit=oneattr
    this.dialogR = this.dialog.open(templateRef)

  } 

  decrease(id){
    console.log(id)
     this.service.decreaseV(id)
     this.toast.success("Editet")

  }

}
