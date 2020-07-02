import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalConstants } from '../commons/global-constants';
import { Movement } from '../model/movement';

@Injectable({
  providedIn: 'root'
})
export class MovementService {

 
  public httpOptions: any;
  private authorization: string;
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
   * Se encarga de create una nueva cuenta
   */
  public createMovement(movement:Movement): Observable<any> {
    return this._http.post(GlobalConstants.apiURL + `account/movement`,movement, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

}
