import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipment } from '../models/equipment';


import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { EquipmentsDto } from '../models/equipments-dto';
import { SocketClientService } from './websocket/websocket.service';


const url='http://localhost:8080/home/'

@Injectable({
  providedIn: 'root'
})
export class EquipmentService {
 

  constructor( private http:HttpClient,
    private socketClient: SocketClientService) {
      
  }
//ktu
getEquipmentss():Observable<Equipment[]>{
  return this.socketClient
      .onMessage('/topic/posts/all')
}

changeStatusSocket(id:string){
  return this.socketClient._send(`/topic/changeStatus/${id}/on`)
}
 

  increaseV(id:string){
    return this.socketClient._send(`/topic/increase/${id}/Attr/`);
  }

  decreaseV(id:string){
    return this.socketClient._send("/topic/decreaseAttr/"+`${id}`);
  }

  addEquipment(equipment:EquipmentsDto){
     this.socketClient.send('/topic/add/appliaces/', equipment)
    }

 

}

