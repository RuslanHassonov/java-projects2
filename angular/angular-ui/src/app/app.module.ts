import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {OrderSearchComponent} from './order-search.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatOptionModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule
} from "@angular/material";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "./login.component";

import {LoginService} from "./login.service";
import {AuthenticationGuard} from "./authentication.guard";
import {HttpClientModule} from "@angular/common/http";
import {MatMomentDateModule} from "@angular/material-moment-adapter";
import {OrderDetailComponent} from "./order-detail.component";
import {CdkTableModule} from "@angular/cdk/table";
import {OrderSearchService} from "./order-search.service";


@NgModule({
  declarations: [
    AppComponent,
    OrderSearchComponent,
    LoginComponent,
    OrderDetailComponent
  ],
  entryComponents: [
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
    MatMomentDateModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatTableModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    CdkTableModule,
    ReactiveFormsModule,
  ],
  providers: [OrderSearchService, LoginService, AuthenticationGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
