package com.sdp3.SDP3.service;

import com.sdp3.SDP3.entites.Wallet;

public interface WalletService {
    void createWallet(Wallet wallet);

    Wallet findWalletByStoreId(Long uid);
}
