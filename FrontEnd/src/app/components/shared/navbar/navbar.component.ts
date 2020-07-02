import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { Account } from 'src/app/model/account';
import { TokenService } from 'src/app/services/auth/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  public loggedIn:boolean;
  constructor(private _tokenService:TokenService,
              private route:Router) { 
    this.loggedIn = _tokenService.loggedIn();
  }

  ngOnInit(): void {
  }
  

  logout(){
    this._tokenService.remove();
    this.route.navigate(['/']);
    this.loggedIn = false;
  }
  
}
