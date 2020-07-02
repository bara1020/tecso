import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { TokenService } from 'src/app/services/auth/token.service';
import { AuthService } from 'src/app/services/auth/auth.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public messageError:string;
  public loginForm: FormGroup;
  public submitted:boolean = false;
  get loginFormControls() { return this.loginForm.controls; }

  constructor(private _userService:UserService,
              private _tokenService:TokenService,
              private _authService:AuthService,
              private route: Router,
              private loginFormBuilder: FormBuilder,) { }

  ngOnInit(): void {
    this.loginForm = this.loginFormBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  /**
   * Ejecuta la consulta para validar si es valido el usuario
   */
  login(){
    this.submitted = true;
    if(!this.loginForm.valid)
      return false;

    this._userService.login(this.loginForm.value).subscribe(
      data =>  this.handleLogin(data),
      error => this.messageError = "El usuario y/o contraseña no son correctos"
    );
  }

  handleLogin(data){
    this._tokenService.handle(data.token);
    this._authService.changeAuthStatus(true);
    this.route.navigate(['admin/holders']);
  }

  logout(){
    this._tokenService.remove();
  }

}
