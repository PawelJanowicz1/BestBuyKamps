package com.bestbuykamps.websiteshop.web_controller;

import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ContactDetailsService;
import com.bestbuykamps.websiteshop.business_service.OrdersService;
import com.bestbuykamps.websiteshop.data_model.OrderRepository;
import com.bestbuykamps.websiteshop.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final ContactDetailsService contactDetailsService;
    private final OrdersService ordersService;
    private final SessionUtil sessionUtil;




    public CheckoutController(ContactDetailsService contactDetailsService, OrdersService ordersService, SessionUtil sessionUtil) {
        this.contactDetailsService = contactDetailsService;
        this.ordersService = ordersService;
        this.sessionUtil = sessionUtil;
    }

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

    @GetMapping()
    public String checkoutPage() {
        return "CHECKOUT_PAGE";
    }

    @PostMapping()
    public String processCheckout(Model model ,@RequestParam String name,
                                  @RequestParam String lastName,
                                  @RequestParam String email,
                                  @RequestParam String phone,
                                  @RequestParam String address,
                                  @RequestParam String country,
                                  @RequestParam String city,
                                  @RequestParam String zip,
                                  HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        logger.info("Received checkout request with following data:");
        logger.info("session id : {}", sessionId);
        logger.info("Name: {}", name);
        logger.info("Last Name: {}", lastName);
        logger.info("Email: {}", email);
        logger.info("Phone: {}", phone);
        logger.info("Address: {}", address);
        logger.info("Country: {}", country);
        logger.info("City: {}", city);
        logger.info("ZIP Code: {}", zip);

        contactDetailsService.createContactDetails(name,lastName,email,phone,address,country,city,zip , sessionId);
        ordersService.createNewOrder(sessionId);
        showOrderConfirmation(model , sessionId);


        return "redirect:/confirmation";
    }


    public void showOrderConfirmation(Model model , String sessionId) {
        Long orderNumber = ordersService.getOrder(sessionId).getOrderNumber();
        model.addAttribute("orderNumber", orderNumber);
    }

}