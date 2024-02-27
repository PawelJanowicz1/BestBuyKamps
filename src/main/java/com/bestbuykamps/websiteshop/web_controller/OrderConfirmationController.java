package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Random;
@Controller
@RequestMapping("/")
public class OrderConfirmationController {
private final OrderRepository orderRepository;

    public OrderConfirmationController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("confirmation")
    public String showOrderConfirmation(Model model) {
        Random random = new Random();
        int orderNumber = random.nextInt(1000000);
        model.addAttribute("orderNumber", orderNumber);
        return "ORDER_PLACED";
    }
}