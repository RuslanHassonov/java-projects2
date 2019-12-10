import {Injectable} from "@angular/core";

import {User} from "./user";
import {Router} from "@angular/router";

import {environment} from "../environments/environment";
import {HttpClient, HttpHeaders, HttpParams, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {concatMap, map} from "rxjs/operators";


@Injectable()
export class LoginService {

  private authenticated: boolean;

  constructor(private http: HttpClient, private router: Router) {
  }

  public authenticate(credentials: any): Observable<User> {
    let params = new HttpParams()
      .set('username', credentials.username)
      .set('password', credentials.password);

    return this.http.post(environment.backend + "/api/open/login", null, {
      'params': params,
      'withCredentials': true
    }).pipe(concatMap(response => this.getUser()));
  }

  public isAuthenticated(): boolean {
    return this.authenticated;
  }

  public refreshAuthentication(): Observable<User> {
    return this.getUser();
  }

  public logout() {
    this.http.get(environment.backend + "/logout", {'withCredentials': true}).subscribe((response) => {
      this.router.navigate(["public/login"]);
    });
  }

  private getUser(): Observable<User> {
    let headers: HttpHeaders = new HttpHeaders();
    headers.set('Content-Type', 'application/json');

    return this.http.get(environment.backend + "/api/authenticated/user/get", {
      'withCredentials': true,
      'headers': headers
    }).pipe(map((response: any) => {
      return response;
    }));
  }

}
