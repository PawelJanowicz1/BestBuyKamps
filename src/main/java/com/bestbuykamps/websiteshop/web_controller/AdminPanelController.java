package com.bestbuykamps.websiteshop.web_controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @GetMapping("/panel")
    public String moveToAdminPanel(){
        return "ADMIN_PANEL";
    }

    @GetMapping("/logout")
    public String logoutFromAdminPanel(){
        return "redirect:forward:/";
    }
}