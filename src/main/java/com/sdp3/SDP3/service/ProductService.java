package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    List<Product> getAllProducts();

    Product findProductById(String pid);

    List<Product> getProductsByStoreId(Long storeId);

    Product getByProductById(Long pid);
}
