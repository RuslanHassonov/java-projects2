import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {LoginService} from "./login.service";
import {Router} from "@angular/router";

@Component({
  template: `
    <div class="container">
      <div class="title">
        Welcome
      </div>
      <div class="panel-body">

          <button (click)="login($event)">Login</button>

      </div>
    </div>`,
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(private loginService: LoginService, private router: Router) {
  }

  login(event) {
    //TODO Login using the login service and navigate to 'ui/authenticated/searchOrders' after obtaining the logg
    console.log("logging in");

    this.loginService.authenticate({
      username: "john",
      password: "doe"
    }).subscribe( e =>{

    })
  }

  ngOnInit(): void {
  }
}
