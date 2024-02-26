package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import com.bestbuykamps.websiteshop.data_model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @GetMapping("register")
    public String moveToRegisterPage(){
        return "REGISTER_PAGE";
    }

    @PostMapping("register")
    public String processRegistration(@RequestParam String username,
                                      @RequestParam String password,
                                      @RequestParam String name,
                                      @RequestParam String lastName,
                                      @RequestParam String email,
                                      @RequestParam String phone,
                                      @RequestParam String address,
                                      @RequestParam String country,
                                      @RequestParam String city,
                                      @RequestParam String zip) {
        logger.info("Received checkout request with following data:");
        logger.info("Username: {}", username);
        logger.info("Last Name: {}", password);
        logger.info("Name: {}", name);
        logger.info("Last Name: {}", lastName);
        logger.info("Email: {}", email);
        logger.info("Phone: {}", phone);
        logger.info("Address: {}", address);
        logger.info("Country: {}", country);
        logger.info("City: {}", city);
        logger.info("ZIP Code: {}", zip);

        //TODO: stworzenie instancji usera i zmapowanie danych na klasę User
        User user = new User(username, password);
        ContactDetails contactDetails = new ContactDetails();

        return "REGISTER_SUCCESS";
    }

}
