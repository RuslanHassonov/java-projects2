package be.mobyus.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import be.mobyus.service.domain.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Override
	public Collection<Product> findProducts(String productName) {
		return new ArrayList<>();
	}
}
