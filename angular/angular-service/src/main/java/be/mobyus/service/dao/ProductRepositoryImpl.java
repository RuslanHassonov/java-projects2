package be.mobyus.service.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import be.mobyus.service.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public Collection<Product> findProducts(String productName) {
		return new ArrayList<>();
	}
}
