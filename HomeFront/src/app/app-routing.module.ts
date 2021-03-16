import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipmentHomeComponent } from './equipment-home/equipment-home.component';
import { EquipmentStateComponent } from './equipment-state/equipment-state.component';
import { EquipmentComponent } from './equipment/equipment.component';

const routes: Routes = [
  {path: '', component: EquipmentHomeComponent},
  {path: 'equipment', component: EquipmentComponent},
  {path: 'equipmentstate', component:EquipmentStateComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
