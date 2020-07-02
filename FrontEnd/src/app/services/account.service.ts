import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GlobalConstants } from '../commons/global-constants';
import { Observable } from 'rxjs';
import { Account } from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

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
   * Se encarga de obtener todos las cuentas registras en el sistema
   */
  public getAccount(numberAccount:number): Observable<any> {
    return this._http.get(GlobalConstants.apiURL + `account/${numberAccount}`, this.httpOptions).pipe(
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
   * Se encarga de create una nueva cuenta
   */
  public createAccount(account:Account): Observable<any> {
    return this._http.post(GlobalConstants.apiURL + `account`,account, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }

    /**
   * Se encarga de eliminar una cuenta
   */
  public deleteAccount(id:number): Observable<any> {
    return this._http.delete(GlobalConstants.apiURL + `account/${id}`, this.httpOptions).pipe(
      data => data,
      error => error
    );
  }
}
