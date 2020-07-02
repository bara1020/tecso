import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalConstants } from '../commons/global-constants';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

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
   * Se encarga de obtener todas las monedas disponibles
   */
  public getCurrency(): Observable<any> {
    return this._http.get(GlobalConstants.apiURL + `currency`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

}