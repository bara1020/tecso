import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalConstants } from '../commons/global-constants';
import { Holder } from '../model/holder';

@Injectable({
  providedIn: 'root'
})
export class HolderService {
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
   * Se encarga de obtener la información del titular
   */
  public findAllHolders(): Observable<any> {
    return this._http.get(GlobalConstants.apiURL + `holder`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  } 
  /**
   * Se encarga de obtener la información del titular
   */
  public getHolder(rut:number): Observable<any> {
    return this._http.get(GlobalConstants.apiURL + `holder/${rut}`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

  /**
   * Se encarga de obtener todos los movimiento de la cuenta
   */
  public getMovementsByAccount(id:number): Observable<any> {
    return this._http.get(GlobalConstants.apiURL + `account/movement/${id}`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

    /**
   * Se encarga de create un nuevo titular
   */
  public createHolder(holder:Holder): Observable<any> {
    return this._http.post(GlobalConstants.apiURL + `holder`,holder, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

    /**
   * Se encarga de create un nuevo titular
   */
  public updateHolder(holder:Holder): Observable<any> {
    return this._http.put(GlobalConstants.apiURL + `holder`,holder, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

    /**
   * Se encarga de eliminar el titular
   */
  public deleteHolder(id:number): Observable<any> {
    return this._http.delete(GlobalConstants.apiURL + `holder/${id}`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }
}
