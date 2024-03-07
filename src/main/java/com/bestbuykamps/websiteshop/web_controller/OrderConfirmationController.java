package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.business_service.OrdersService;
import com.bestbuykamps.websiteshop.data_model.Orders;
import com.bestbuykamps.websiteshop.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
@Controller
@RequestMapping("/")
public class OrderConfirmationController {
private final OrdersService ordersService;
private final OrderRepository orderRepository;

    public OrderConfirmationController(OrdersService ordersService, OrderRepository orderRepository) {
        this.ordersService = ordersService;
        this.orderRepository = orderRepository;
    }

    @GetMapping("confirmation")
    public String showOrderConfirmation(Model model) {
Long orderNumber = ordersService.getOrderNumber();;
        model.addAttribute("orderNumber", orderNumber);
        return "ORDER_PLACED";
    }
    }