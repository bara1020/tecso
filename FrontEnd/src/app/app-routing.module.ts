import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountsComponent } from './components/admin/accounts/accounts.component';
import { HoldersComponent } from './components/admin/holders/holders.component';
import { LoginComponent } from './components/auth/login/login.component';
import { AuthGuard } from './services/auth/guard/auth.guard';
import { PagenofoundComponent } from './components/shared/pagenofound/pagenofound.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';


const routes: Routes = [
  /* { path: "", component: LoginComponent },
   { path: "admin/accounts", component: AccountsComponent, canActivate: [AuthGuard] },
   { path: "admin/holders", component: HoldersComponent, canActivate: [AuthGuard] },
   { path: '**', component: PagenofoundComponent }*/
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {  path: 'admin', component: NavbarComponent,  canActivate: [AuthGuard],
      children: [
          { path: 'holders', component: HoldersComponent },
          { path: 'accounts', component: AccountsComponent },
          { path: '', redirectTo: '/admin', pathMatch: 'full' }
          ]
  },
  { path: '**', component: PagenofoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
