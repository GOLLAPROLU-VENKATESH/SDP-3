package com.sdp3.SDP3.controller;

import com.sdp3.SDP3.entites.Blog;
import com.sdp3.SDP3.entites.Product;
import com.sdp3.SDP3.entites.Store;
import com.sdp3.SDP3.service.BlogService;
import com.sdp3.SDP3.service.ProductService;
import com.sdp3.SDP3.service.StoreService;
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
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/addProducts",method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, Model model, HttpSession session,
                             @RequestParam("productimage1") MultipartFile file1,
                             @RequestParam("productimage1") MultipartFile file2){
        Long uid=(Long) session.getAttribute("storeid");
        Store s=storeService.getUserByUserId(uid);
        model.addAttribute("store",s);
        try{
            if(file1.isEmpty()){
                product.setProductImage1("test.jpg");
            }else{
                String fileName = StringUtils.cleanPath(file1.getOriginalFilename());
                product.setProductImage1(fileName);
                File f=new ClassPathResource("static/img").getFile();
                Path p= Paths.get(f.getAbsolutePath()+File.separator+file1.getOriginalFilename());
                Files.copy(file1.getInputStream(),p, StandardCopyOption.REPLACE_EXISTING);
            }
            if(file2.isEmpty()){
                product.setProductImage2("test.jpg");
            }else{
                String fileName = StringUtils.cleanPath(file2.getOriginalFilename());
                product.setProductImage2(fileName);
                File f=new ClassPathResource("static/img").getFile();
                Path p= Paths.get(f.getAbsolutePath()+File.separator+file2.getOriginalFilename());
                Files.copy(file2.getInputStream(),p, StandardCopyOption.REPLACE_EXISTING);
            }
            product.setStore(s);
            productService.saveProduct(product);

        }catch (Exception e){

        }

        return "store";
    }




    @RequestMapping(value = "/addBlog",method = RequestMethod.POST)
    public String addBlog(@ModelAttribute("blog") Blog blog, Model model, HttpSession session,
                          @RequestParam("blogimage") MultipartFile file){

        Long uid=(Long) session.getAttribute("storeid");
        Store s=storeService.getUserByUserId(uid);
        model.addAttribute("store",s);
        try{
            if(file.isEmpty()){
                blog.setBlogImage("test.jpg");
            }else{
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                blog.setBlogImage(fileName);
                File f=new ClassPathResource("static/img").getFile();
                Path p= Paths.get(f.getAbsolutePath()+File.separator+file.getOriginalFilename());
                Files.copy(file.getInputStream(),p, StandardCopyOption.REPLACE_EXISTING);
            }
            blog.setStore(s);
            blogService.saveBlog(blog);
        }catch (Exception e){

        }
        return "store";
    }




    @RequestMapping(value = "/regiEvent")
    public String eventRegister(){

        return "store";
    }
}
