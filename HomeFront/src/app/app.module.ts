import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EquipmentComponent } from './equipment/equipment.component';
import { EquipmentHomeComponent } from './equipment-home/equipment-home.component';
import { EquipmentStateComponent } from './equipment-state/equipment-state.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [
    AppComponent,
    EquipmentComponent,
    EquipmentHomeComponent,
    EquipmentStateComponent
  ],
  imports: [
    BrowserAnimationsModule,
    ToastrModule.forRoot( {
      timeOut: 2000,
      positionClass: 'toast-top-right',
      preventDuplicates: false,
      progressBar: true,
      maxOpened: 10,
      tapToDismiss: true,
      newestOnTop: true
  }),
    
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
   
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
