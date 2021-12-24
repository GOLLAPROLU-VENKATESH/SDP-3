package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Wallet;
import com.sdp3.SDP3.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public Wallet findWalletByStoreId(Long uid) {
        return walletRepository.findByStore(uid);
    }
}
