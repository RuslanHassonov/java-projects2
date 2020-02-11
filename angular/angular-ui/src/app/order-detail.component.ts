import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OrderSearchService} from "./order-search.service";

@Component({
  template: `

    <!--
    TODO This component will when activated via the router receive the order id. Use the order id to fetch the order detail.
    You will have to expand the OrderController on the Java side with an extra method "getOrder(Long orderId)" which returns that specific order
    Create a simple html table here to list the order details and a back button to go to the previous page
    -->
  `
})
export class OrderDetailComponent implements OnInit, OnDestroy {

  constructor(private route: ActivatedRoute, private searchOrderService: OrderSearchService) {
  }


  ngOnInit() {
  }

  ngOnDestroy() {
  }
}
