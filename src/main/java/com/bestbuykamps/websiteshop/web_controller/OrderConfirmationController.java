package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.business_service.OrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class OrderConfirmationController {
private final OrdersService ordersService;

    public OrderConfirmationController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @GetMapping("confirmation")
    public String showOrderConfirmation(Model model) {
Long orderNumber = ordersService.getOrderNumber();;
        model.addAttribute("orderNumber", orderNumber);
        return "ORDER_PLACED";
    }
    }