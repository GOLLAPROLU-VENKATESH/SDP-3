package com.sdp3.SDP3.controller;

import com.sdp3.SDP3.entites.Store;
import com.sdp3.SDP3.entites.Users;
import com.sdp3.SDP3.service.StoreService;
import com.sdp3.SDP3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class MerchantController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private StoreService storeService;


    @RequestMapping("/merchantRegister")
    public String merchant(Model model){
        model.addAttribute("title","Be a Merchant - Wood & Yarn");
        return "merch";
    }

    @RequestMapping(value="/merchantRegister",
            method = RequestMethod.POST)
    public String merchantRegister(@ModelAttribute("store") Store store, Model model, HttpSession session,
                                   @RequestParam("storeimage") MultipartFile file){
        try{
            model.addAttribute("title","Be a Merchant - Wood & Yarn");
            Long uid=(Long) session.getAttribute("id");
            if(file.isEmpty()){
                store.setStoreImage("test.jpg");
            }else{
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                store.setStoreImage(fileName);
                File f=new ClassPathResource("static/img").getFile();
                Path p= Paths.get(f.getAbsolutePath()+File.separator+file.getOriginalFilename());
                Files.copy(file.getInputStream(),p, StandardCopyOption.REPLACE_EXISTING);
            }
            Users users=usersService.getUserByUserId(uid);
            store.setUsers(users);
            storeService.registerMerchant(store);

//            setting storeid in the session
            Store s=storeService.getUserByUserId(uid);
            Long storeid=s.getUsers().getUserId();
            session.setAttribute("storeid",storeid);
            System.out.println(storeid);

        }
        catch (Exception e){

        }

        return "store";
    }


}
