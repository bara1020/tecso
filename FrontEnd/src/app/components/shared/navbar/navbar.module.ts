import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar.component';
import { HoldersComponent } from '../../admin/holders/holders.component';
import { AccountsComponent } from '../../admin/accounts/accounts.component';
import { NavbarRoutingModule } from './navbar-routing.module';



@NgModule({
  declarations: [
    NavbarComponent,
    HoldersComponent,
    AccountsComponent,
  ],
  exports:[
    
  ],
  imports: [
    CommonModule,
    NavbarRoutingModule
  ],
  providers: [],
})
export class NavbarModule { }
