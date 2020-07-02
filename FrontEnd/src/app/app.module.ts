import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InputNumberModule } from 'primeng/inputnumber';


import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { AccountsComponent } from './components/admin/accounts/accounts.component';
import { HoldersComponent } from './components/admin/holders/holders.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TwoDigitDecimaNumberDirective } from './TwoDigitDecimaNumberDirective';
import { CalendarModule } from 'primeng/calendar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/auth/login/login.component';
import { PagenofoundComponent } from './components/shared/pagenofound/pagenofound.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AccountsComponent,
    HoldersComponent,
    TwoDigitDecimaNumberDirective,
    LoginComponent,
    PagenofoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    InputNumberModule,
    CalendarModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
