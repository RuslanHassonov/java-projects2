package be.mobyus.service.dao;

import be.mobyus.service.domain.Product;

import java.util.Collection;

public interface ProductRepository {

    Collection<Product> findProducts(String productName);
}
