import {AfterViewInit, Component} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {OrderSearchCriteria} from "./ordersearchcriteria";
import {Order} from "./order";
import {Product} from "./product";
import {Observable} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {switchMap} from "rxjs/operators";
import {Router} from "@angular/router";
import {OrderSearchService} from "./order-search.service";

@Component({
  templateUrl: './order-search.component.html',
  styleUrls: ['./order-search.component.css']
})
export class OrderSearchComponent implements AfterViewInit {

  form: FormGroup;

  firstName: FormControl = new FormControl();
  lastName: FormControl = new FormControl();
  orderMinAmount: FormControl = new FormControl();
  orderMaxAmount: FormControl = new FormControl();
  numberOfProducts: FormControl = new FormControl();
  orderDate: FormControl = new FormControl();
  product: FormControl = new FormControl();

  dataSource: MatTableDataSource<Order> = new MatTableDataSource<Order>();

  //Autocomplete binding
  filteredOptionsResult: Observable<Product[]> = new Observable();

  options = [];

  length: number = 0;

  constructor(private searchOrderService: OrderSearchService, private router: Router) {
    this.form = new FormGroup({
      user:
        new FormGroup({
          firstName: new FormControl(),
          lastName: new FormControl(),
        }),
      orderMinAmount: this.orderMinAmount,
      orderMaxAmount: this.orderMaxAmount,
      orderDate: this.orderDate,
      product: this.product
    });

    this.filteredOptionsResult = this.product.valueChanges.pipe(switchMap(val => {
      return this.searchOrderService.findProducts(val);
    }));
  }

  ngAfterViewInit() {
    //TODO Connect paginator one in place
    //this.dataSource.paginator = this.paginator;
  }

  filter(val: string): Product[] {
    return this.options.filter(option => new RegExp(`^${val}`, 'gi').test(option.productName));
  }

  displayFn(product: Product): string {
    return product ? product.productName : "";
  }

  public search() {
    this.dataSource.connect().next(null);
    let orderSearchCriteria: OrderSearchCriteria = this.form.value;

    this.searchOrderService.findOrders(this.form.value).subscribe(orders => {
      this.length = orders.length;
      this.dataSource.data = orders;
    });
  }

  select(row: Order) {
    //TODO Navigate to the detail page passing along the order id (row.id)
  }
}
