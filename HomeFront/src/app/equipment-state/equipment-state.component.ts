import { Component, OnInit } from '@angular/core';
import { Equipment } from '../models/equipment';
import { Observable } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { ThisReceiver } from '@angular/compiler';
import { EquipmentService } from '../equipments/equipment.service';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-equipment-state',
  templateUrl: './equipment-state.component.html',
  styleUrls: ['./equipment-state.component.css']
})



export class EquipmentStateComponent implements OnInit {

  Appliance:Equipment[]
apliancess:Equipment[]
  displayedColumns: string[] = [ 'id','name','type','location','Nr Attributes','status'];
  dataSource :Equipment[];
  constructor( private service:EquipmentService,
    private dialog:MatDialog,
    private toast:ToastrService) { }
    private dialogRef: any;
    tobeEdit:any;
    one:boolean;

  ngOnInit(): void {
    this.getAllAppliances()
  }

  getAllAppliances(){
  return this.service.getEquipmentss().subscribe(
    apliancess=>{
      this.Appliance=apliancess;
      console.log(this.Appliance)
      this.dataSource=this.Appliance
     
      console.log("sad"+this.dataSource)  
    
    }
  )
    
  }

  edit(element, templateRef){
    console.log(element)
    this.tobeEdit=element
    this.dialogRef = this.dialog.open(templateRef)

  } 

  editTm(id){
    console.log(id)
    // return this.service.changeStatus(id).subscribe(
    //   data=>{
    //     this.dataSource=data;
    //     console.log(data[0].state);
     
    //   }
   
    
    // )
     this.service.changeStatusSocket(id);
    this.toast.success("u ndryshua")
  }

  
  
  

  

  

}
