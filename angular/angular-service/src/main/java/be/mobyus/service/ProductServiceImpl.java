package be.mobyus.service;

import be.mobyus.service.dao.ProductRepository;
import be.mobyus.service.domain.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Collection<Product> findProducts(String productName) {
        if(StringUtils.isBlank(productName)|| productName.length()<2){
            return new ArrayList();
        }
        return productRepository.findProducts(productName);
    }
}
