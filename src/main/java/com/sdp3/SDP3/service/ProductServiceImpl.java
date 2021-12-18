package com.sdp3.SDP3.service;


import com.sdp3.SDP3.entites.Product;
import com.sdp3.SDP3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
