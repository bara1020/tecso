import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalConstants } from '../commons/global-constants';
import { Holder } from '../model/holder';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public httpOptions: any;
  constructor(
    public _http: HttpClient
  ) {

    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': GlobalConstants.apiKey,
      })
    };
  }

  /**
   * Se encarga de hacer el login
   */
  public login(user:User): Observable<any> {
    return this._http.post(GlobalConstants.apiURL + `authenticate`,user, this.httpOptions);
  } 
}
