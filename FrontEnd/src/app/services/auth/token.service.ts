import { Injectable } from '@angular/core';
import { tokenName } from '@angular/compiler';
import { GlobalConstants } from 'src/app/commons/global-constants';
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private iss={
    login: GlobalConstants.apiURL + "authenticate",
  };

  constructor() { }

  handle(token:string){
    this.set(token);
  }

  set(token){
    localStorage.setItem('token', token);
  }

  get(){
    return localStorage.getItem('token');
  }

  remove(){
    localStorage.removeItem('token');
  }

  isValid(){
    const token = this.get();

    if(token == null)
    return false;
    
    const decode = jwt_decode(token);
    if(decode.exp === undefined)
     return false;

     const date = new Date(0);
     let tokenExpDate = date.setUTCSeconds(decode.exp);

     if(tokenExpDate.valueOf() > new Date().valueOf()){}
        return true;

    return false;
  }

  payload(token:string){
    const payload = token.split('.')[1];
    return this.decode(payload);
  }

  decode(payload){
    return JSON.parse(atob(payload));
  }

  loggedIn(){
    return this.isValid();
  }

}
