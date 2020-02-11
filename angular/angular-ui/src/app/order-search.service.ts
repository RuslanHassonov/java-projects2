import {Order} from "./order";

import {OrderSearchCriteria} from "./ordersearchcriteria";

import {Product} from "./product";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class OrderSearchService {

  constructor(private http: HttpClient) {
  }

  getOrder(id: number): Observable<Order> {
    let requestoptions = {
      'headers': new HttpHeaders({'Content-Type': 'application/json'}),
      'withCredentials': true,
      'params': new HttpParams().set("id", "" + id)
    };

    //TODO Call /api/authenticated/orders/getOrder
    return null;
  }

  findOrders(orderSearchCriteria: OrderSearchCriteria): Observable<Order[]> {
    let requestoptions = {
      'headers': new HttpHeaders({'Content-Type': 'application/json'}),
      'withCredentials': true,
    };

    //TODO Call /api/authenticated/orders/findOrders
    return null;
  }

  findProducts(productName: string): Observable<Product[]> {
    let requestoptions = {
      'headers': new HttpHeaders({'Content-Type': 'application/json'}),
      'withCredentials': true,
      'params': new HttpParams().set("productName", productName)
    };

    //TODO Call /api/authenticated/products/findProducts
    return null;

  }
}
