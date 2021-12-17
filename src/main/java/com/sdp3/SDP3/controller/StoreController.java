package com.sdp3.SDP3.controller;

import com.sdp3.SDP3.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/addProducts",method = RequestMethod.POST)
    public void addProduct(){

    }
    @RequestMapping(value = "/addBlog")
    public String addBlog(){

        return "store";
    }
    @RequestMapping(value = "/regiEvent")
    public String eventRegister(){

        return "store";
    }
}
