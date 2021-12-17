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
public class HomeController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StoreService storeService;

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title","Home - Wood & Yarn");
        model.addAttribute("user",new Users());
        return "home";
    }

    @RequestMapping("/")
    public String h(){
        return "home";
    }

    @RequestMapping("/shop")
    public String shop(Model model){
        model.addAttribute("title","Shop - Wood & Yarn");
        return "shop";
    }

    @RequestMapping("/adds")
    public String advertisemrnt(Model model){
        model.addAttribute("title","Add's - Wood & Yarn");
        return "advertisement";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","AboutUs - Wood & Yarn");
        return "about";
    }

    @RequestMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title","ContactUs - Wood & Yarn");
        return "contact";
    }

    @RequestMapping("/events")
    public String events(Model model){
        model.addAttribute("title","Events - Wood & Yarn");
        return "events";
    }

    @RequestMapping(value = "/store")
    public String store(Model model,HttpSession session){
        model.addAttribute("title","Store - Wood & Yarn");
        Long uid=(Long) session.getAttribute("storeid");
        Store s=storeService.getUserByUserId(uid);
        model.addAttribute("store",s);
        return "store";
    }

}
