import {async, TestBed} from '@angular/core/testing';
import {BrowserModule} from '@angular/platform-browser';
import {SearchorderComponent} from './searchorder.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {
  MdAutocompleteModule,
  MdButtonModule,
  MdButtonToggleModule,
  MdCardModule,
  MdCheckboxModule,
  MdChipsModule,
  MdDatepickerModule,
  MdDialogModule,
  MdExpansionModule,
  MdGridListModule,
  MdIconModule,
  MdInputModule,
  MdListModule,
  MdMenuModule,
  MdNativeDateModule,
  MdPaginatorModule,
  MdProgressBarModule,
  MdProgressSpinnerModule,
  MdRadioModule,
  MdRippleModule,
  MdSelectModule,
  MdSidenavModule,
  MdSliderModule,
  MdSlideToggleModule,
  MdSnackBarModule,
  MdSortModule,
  MdTableModule,
  MdTabsModule,
  MdToolbarModule,
  MdTooltipModule
} from "@angular/material";
import {HttpModule} from "@angular/http";

import {CdkTableModule} from "@angular/cdk/table";
import {routingForApp} from "./app.routes";
import {ReactiveFormsModule} from "@angular/forms";
import {LoginService} from "./login.service";
import {SearchOrderService} from "./searchorder.service";
import {Router, RouterModule} from "@angular/router";

describe('SearchorderComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[
        BrowserModule,
        BrowserAnimationsModule,
        HttpModule,
        MdAutocompleteModule,
        MdButtonModule,
        MdButtonToggleModule,
        MdCardModule,
        MdCheckboxModule,
        MdChipsModule,
        MdTableModule,
        MdDatepickerModule,
        MdDialogModule,
        MdExpansionModule,
        MdGridListModule,
        MdIconModule,
        MdInputModule,
        MdListModule,
        MdMenuModule,
        MdNativeDateModule,
        MdPaginatorModule,
        MdProgressBarModule,
        MdProgressSpinnerModule,
        MdRadioModule,
        MdRippleModule,
        MdSelectModule,
        MdSidenavModule,
        MdSliderModule,
        MdSlideToggleModule,
        MdSnackBarModule,
        MdSortModule,
        MdTabsModule,
        MdToolbarModule,
        MdTooltipModule,
        CdkTableModule,
        ReactiveFormsModule
      ],
      declarations: [
        SearchorderComponent
      ],
      providers:[SearchOrderService, LoginService, { provide: Router,useClass: RouterStub}]
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(SearchorderComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'app'`, async(() => {
    const fixture = TestBed.createComponent(SearchorderComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.length).toEqual(0);
  }));


  class RouterStub {
    navigateByUrl(url: string) { return url; }
  }
});
