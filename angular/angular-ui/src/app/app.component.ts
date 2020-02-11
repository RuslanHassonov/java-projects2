import {Component} from '@angular/core';
import {LoginService} from "./login.service";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-root',
  styleUrls: ['./app.component.scss'],
  template: `
    <mat-card class="demo-card demo-basic">
      <mat-card-content>
        <div *ngIf="isAuthenticated()" align="right">
          <button mat-button (click)="logout()">logout</button>
        </div>
      </mat-card-content>
    </mat-card>

    <router-outlet></router-outlet>

    <mat-card class="demo-card demo-basic">
      <mat-card-content>
        <div align="center">
          Footer here
        </div>
      </mat-card-content>

    </mat-card>
  `

})
export class AppComponent {

  constructor(private loginService: LoginService, public dialog: MatDialog) {
  }

  //TODO Interrupt logout flow by first showing a dialog

  public logout() {
    this.loginService.logout();
  }

  isAuthenticated(): boolean {
    return this.loginService.isAuthenticated();
  }
}
