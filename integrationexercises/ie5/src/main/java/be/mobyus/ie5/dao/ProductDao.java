package be.mobyus.ie5.dao;

import be.mobyus.ie5.entities.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findProducts(String productName);
}
