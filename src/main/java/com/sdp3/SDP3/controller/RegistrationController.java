package com.sdp3.SDP3.controller;


import com.sdp3.SDP3.entites.Store;
import com.sdp3.SDP3.entites.Users;
import com.sdp3.SDP3.service.StoreService;
import com.sdp3.SDP3.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("user") Users users, Model model){
        model.addAttribute("title","Home - Wood & Yarn");
        usersService.saveUser(users);
        model.addAttribute("signupsuccess",1);
        return "home";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@ModelAttribute("user") Users users,Model model,HttpSession session){
        model.addAttribute("title","Home - Wood & Yarn");
        System.out.println(users.getEmail()+" "+users.getPassword());
        Users u=usersService.loginUser(users);
        if(u.getEmail().equals("new")){
            model.addAttribute("loginfailednewuser",1);
            return "home";
        }
        else if(u.getEmail().equals("epw")){
            model.addAttribute("loginfailed",1);
            return "home";
        }
        else {
            try{
                Store s=storeService.getUserByUserId(u.getUserId());
                Long storeid=s.getUsers().getUserId();
                session.setAttribute("storeid",storeid);
                System.out.println(storeid);
            } catch (Exception e){
            }
            session.setAttribute("id",u.getUserId());
            session.setAttribute("user",u.getUserName());
            model.addAttribute("loginsuccess",1);
            model.addAttribute("sessionId",u.getUserId());
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
