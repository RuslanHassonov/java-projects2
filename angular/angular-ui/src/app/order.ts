import {User} from "./user";
import {Product} from "./product";

export class Order{

  id:number;
  user:User;
  orderDate: Date;
  totalAmount:number;
  products: Product[];

}
