import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SearchorderComponent} from './searchorder.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatAutocompleteModule,
  MatCardModule, MatDatepickerModule,
  MatDialogModule,
  MatInputModule,
  MatOptionModule, MatPaginatorModule,
  MatRadioModule,
  MatSelectModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule,
} from "@angular/material";
import {SearchOrderService} from "./searchorder.service";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "./login.component";

import {LoginService} from "./login.service";
import {AuthenticationGuard} from "./authentication.guard";
import {HttpClientModule} from "@angular/common/http";
import {MatMomentDateModule} from "@angular/material-moment-adapter";
import {OrderDetailComponent} from "./order-detail.component";


@NgModule({
  declarations: [
    AppComponent,
    SearchorderComponent,
    LoginComponent,
    OrderDetailComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatTableModule,
    MatSortModule,
    MatDialogModule,
    MatOptionModule,
    MatInputModule,
    MatRadioModule,
    MatCardModule,
    MatToolbarModule,
    MatAutocompleteModule,
    MatSelectModule,
    MatDatepickerModule,
    MatPaginatorModule,
    MatMomentDateModule
  ],
  providers: [SearchOrderService, LoginService, AuthenticationGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
