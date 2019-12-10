import {Component, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {SearchOrderService} from "./searchorder.service";
import {Order} from "./order";
import {LoginService} from "./login.service";
import {Router} from "@angular/router";

@Component({
  templateUrl: './searchorder.component.html',
  styleUrls: ['./searchorder.component.css']
})
export class SearchorderComponent implements OnInit {

  form: FormGroup;

  constructor(private searchOrderService: SearchOrderService, private loginService: LoginService, private router: Router) {

  }

  ngOnInit() {
  }

  public logout() {
    this.loginService.logout();
  }

  toDetail(row: Order) {
    this.router.navigate(["ui/authenticated/orderDetail/" + row.id]);
  }

  search(event:any) {

  }
}

