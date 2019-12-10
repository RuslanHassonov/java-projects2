import {User} from "./user";
import {Product} from "./product";

export class OrderSearchCriteria {

  customer: User = new User()
  product: Product;
  orderDate: Date;
  orderMinAmount: number;
  orderMaxAmount: number;
}
