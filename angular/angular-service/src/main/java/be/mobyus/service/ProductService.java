package be.mobyus.service;

import be.mobyus.service.domain.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> findProducts(String productName);
}
