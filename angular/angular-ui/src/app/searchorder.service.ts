import {Order} from "./order";

import {OrderSearchCriteria} from "./ordersearchcriteria";

import {Product} from "./product";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class SearchOrderService {

  constructor(private http: HttpClient) {
  }

  findOrders(orderSearchCriteria: OrderSearchCriteria): Observable<Order[]> {
    //TODO call -> /api/authenticated/orders/findOrders to find orders
    return null;
  }

  findProducts(productName: string): Observable<Product[]> {
    //TODO call -> /api/authenticated/products/findProducts to find products
    return null;
  }
}
