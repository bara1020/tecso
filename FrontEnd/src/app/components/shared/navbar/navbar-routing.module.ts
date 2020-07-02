import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HoldersComponent } from '../../admin/holders/holders.component';
import { AccountsComponent } from '../../admin/accounts/accounts.component';
import { NavbarComponent } from './navbar.component';
import { AuthGuard } from 'src/app/services/auth/guard/auth.guard';


const routes: Routes = [{  path: 'admin', component: NavbarComponent, canActivate: [AuthGuard] ,
children: [
    { path: 'holders', component: HoldersComponent },
    { path: 'accounts', component: AccountsComponent },
    { path: '', redirectTo: '/admin', pathMatch: 'full' }
    ]
},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
  
})
export class NavbarRoutingModule { }
