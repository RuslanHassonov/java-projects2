package be.mobyus.rest.controller.authenticated.products;

import be.mobyus.service.OrderService;
import be.mobyus.service.ProductService;
import be.mobyus.service.domain.Order;
import be.mobyus.service.domain.OrderSearchCriteria;
import be.mobyus.service.domain.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("authenticated/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(path = "findProducts", method = GET, produces= "application/json")
	public Collection<Product> findOrders(@RequestParam String productName) {
		return productService.findProducts(productName);
	}
}
