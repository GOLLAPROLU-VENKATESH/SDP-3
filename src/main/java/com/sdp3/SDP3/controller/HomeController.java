package com.sdp3.SDP3.controller;

import com.sdp3.SDP3.entites.Users;
import com.sdp3.SDP3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UsersService usersService;

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

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("user") Users users,Model model,HttpSession session){

        model.addAttribute("title","Home - Wood & Yarn");
        usersService.saveUser(users);
        model.addAttribute("signupsuccess",1);
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute("user") Users users,Model model,HttpSession session){
        model.addAttribute("title","Home - Wood & Yarn");
        boolean b=usersService.loginUser(users);
        if(b){
            Users u=usersService.getUserByEmail(users.getEmail());
            session.setAttribute("id",u.getUserId());
            session.setAttribute("user",u.getUserName());
            model.addAttribute("loginsuccess",1);
            model.addAttribute("sessionId",u.getUserId());
//            System.out.println(u.getUserId());
            return "home";
        }else{
            model.addAttribute("loginfailed",1);
            return "home";
        }
    }
    @RequestMapping(value = "/logout")
    public String logout(Model model,HttpSession session){
        session.invalidate();
        model.addAttribute("logoutsuccess",1);
        return "home";
    }

}
