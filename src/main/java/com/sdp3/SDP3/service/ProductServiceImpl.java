package com.sdp3.SDP3.service;


import com.sdp3.SDP3.entites.Product;
import com.sdp3.SDP3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(String pid) {
        Long id=Long.parseLong(pid);
        Product p=productRepository.findByProductId(id);
        return p;
    }

    @Override
    public List<Product> getProductsByStoreId(Long storeId) {

        return productRepository.findByStoreId(storeId);
    }
}
