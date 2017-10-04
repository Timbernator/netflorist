/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.netflorist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Reverside
 */

@Controller
public class MainControl {
   
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    
    @RequestMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    @RequestMapping("/register")
    public String showRegisterPage(){
        return "register";
    }
    @RequestMapping("/forgotPassword")
    public String showForgotPasswordPage(){
        return "forgotPassword";
    }
    @RequestMapping("/registered")
    public String showRegisteredPage(){
        return "registered";
    }
    @RequestMapping("/viewProducts")
    public String viewProductsPage(){
        return "viewProducts";
    }
    @RequestMapping("/adminPage")
    public String viewAdminPage(){
        return "adminPage";
    }
    @RequestMapping("/users")
    public String viewUsersPage(){
        return "users";
    }
    @RequestMapping("/adminRegister")
    public String viewAdminAddPage(){
        return "adminRegister";
    }
    @RequestMapping("/registration")
    public String confirmationPage()
    {
        return "adminAdded";
    }
    @RequestMapping("/adminProducts")
    public String viewAdminProductsPage()
    {
        return "adminProducts";
    }

    @RequestMapping("/addProduct")
    public String addProductPage()
    {
        return "addProduct";
    }
//    @RequestMapping("/upload")
//    public String addProductImagePage()
//    {
//        return "upload";
//    }
    @RequestMapping("/checkout")
    public String checkoutPage()
    {
        return "payment";
    }

    @RequestMapping("/order")
    public String orderPage()
    {
        return "order";
    }
    @RequestMapping("/adminOrder")
    public String adminOrderPage()
    {
        return "adminOrder";
    }
    @RequestMapping("/checkedError")
    public String getErrorPage()
    {
        return "checkedError";
    }
    

//
//     @RequestMapping("/{page}")
//    public String returnPage(@PathVariable("page") String page){
//         System.out.println(page);
//        return page;
//    }
    
}
