package com.sdp3.SDP3.controller;

import com.sdp3.SDP3.entites.Blog;
import com.sdp3.SDP3.entites.Product;
import com.sdp3.SDP3.entites.Store;
import com.sdp3.SDP3.entites.Users;
import com.sdp3.SDP3.service.BlogService;
import com.sdp3.SDP3.service.ProductService;
import com.sdp3.SDP3.service.StoreService;
import com.sdp3.SDP3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title","Home - Wood & Yarn");
        model.addAttribute("user",new Users());
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products",products);
        return "home";
    }

    @RequestMapping("/")
    public String h(Model model){
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products",products);
        return "home";
    }

    @RequestMapping("/shop")
    public String shop(Model model){
        model.addAttribute("title","Shop - Wood & Yarn");
        List<Product> products=productService.getAllProducts();
        model.addAttribute("products",products);
        return "shop";
    }

    @RequestMapping("/adds")
    public String advertisement(Model model){
        model.addAttribute("title","Add's - Wood & Yarn");
        List<Blog> blogs=blogService.getAllBlogs();
        model.addAttribute("blogs",blogs);
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

    @RequestMapping("/orders")
    public String orders(Model model){
        model.addAttribute("title","Orders - Wood & Yarn");
        return "orders";
    }

}
