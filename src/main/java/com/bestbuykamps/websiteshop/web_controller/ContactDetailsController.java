package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ContactDetailsService;
import com.bestbuykamps.websiteshop.data_model.ContactDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ContactDetailsController {
    private final ContactDetailsService contactDetailsService;
    private final CartService cartService;

    public ContactDetailsController(ContactDetailsService contactDetailsService, CartService cartService) {
        this.contactDetailsService = contactDetailsService;
        this.cartService = cartService;
    }

//    @GetMapping("checkout")
//    public ContactDetails getContactDetails(@RequestBody ContactDetails contactDetails){
//        return contactDetails;
//    }
}
