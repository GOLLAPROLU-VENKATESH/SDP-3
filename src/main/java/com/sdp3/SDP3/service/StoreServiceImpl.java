package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Store;
import com.sdp3.SDP3.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void registerMerchant(Store store) {
        storeRepository.save(store);
    }

    @Override
    public Store getUserByUserId(Long userId) {
        return storeRepository.findByUser_id(userId);
    }
}
