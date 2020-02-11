import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {LoginService} from "./login.service";
import {Router} from "@angular/router";

@Component({
  template: `
    <div class="container">
      <div class="title">
        Welcome
      </div>
      <div class="panel-body">
        <form [formGroup]="form" (ngSubmit)="login($event)">
          <div class="row">
            <div class="input-field col s12">
              <!-------->
              <!-- TODO username-->
              <!--------->

            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <!-------->
              <!-- TODO password-->
              <!--------->

            </div>
          </div>
          <!-------->
          <!-- TODO error message-->
          <!--------->

          <button md-button type="submit">Login</button>
        </form>
      </div>
    </div>`,
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public errorMsg: string;

  private username: FormControl = new FormControl();
  private password: FormControl = new FormControl();

  form: FormGroup;

  constructor(private loginService: LoginService, private router: Router) {
  }

  login(event) {
    this.loginService.authenticate(this.form.value).subscribe(user => {
      //ACTION: NAVIGATE TO SEARCH PAGE WHEN LOGIN SUCCEEDS
    }, err => {
      if (err.status === 401) {
        //ACTION: LOGIN ERROR, SHOW ERROR MESSAGE USER/PASS WRONG
      } else {
        this.errorMsg = "Internal server error!"
      }
    });
  }

  ngOnInit(): void {
    this.username.valueChanges.subscribe(e => {
      this.errorMsg = null;
    });
    this.password.valueChanges.subscribe(e => {
      this.errorMsg = null;
    })

    this.form = new FormGroup({
      username: this.username,
      password: this.password
    });
  }
}
