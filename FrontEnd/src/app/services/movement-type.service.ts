import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalConstants } from '../commons/global-constants';

@Injectable({
  providedIn: 'root'
})
export class MovementTypeService {
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
   * Se encarga de obtener los tipos de movimientos
   */
  public getMovementType(): Observable<any> {
    return this._http.get(GlobalConstants.apiURL + `movementType`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }
}
