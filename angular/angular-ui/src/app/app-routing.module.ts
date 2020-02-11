import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationGuard} from "./authentication.guard";

import {LoginComponent} from "./login.component";

const routes: Routes = [
  {
    path: '', children: [
      {
        path: "ui/authenticated",
        canActivate: [AuthenticationGuard],
        children: [
          //TODO Complete routes for search and detail page
        ]
      }, {
        path: "ui/public",
        children: [
          {path: "login", component: LoginComponent}
        ]
      },
      {path: '**', redirectTo: "ui/public/login"}
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule {
}
