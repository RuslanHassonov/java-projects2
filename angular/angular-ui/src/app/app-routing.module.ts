import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationGuard} from "./authentication.guard";
import {SearchorderComponent} from "./searchorder.component";
import {LoginComponent} from "./login.component";
import {AppRoutes} from "./app.routes";
import {OrderDetailComponent} from "./order-detail.component";

const routes: Routes = [
  {
    path: '', children: [
      {
        path: AppRoutes.authenticated,
        canActivate: [AuthenticationGuard],
        children: [
          //TODO add routes for the search and detail page
        ]
      }, {
        path: AppRoutes.public,
        children: [
          {path: AppRoutes.login, component: LoginComponent}
        ]
      },
      {path: '**', redirectTo: AppRoutes.loginRoute}
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule {
}
