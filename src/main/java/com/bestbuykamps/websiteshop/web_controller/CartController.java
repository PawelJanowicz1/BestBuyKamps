package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/cart/products")
public class CartController {
    private final CartService cartService;
    private final SessionUtil sessionUtil;
    private Long productId;
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService, SessionUtil sessionUtil) {
        this.cartService = cartService;
        this.sessionUtil = sessionUtil;
    }
    @PostMapping("/add")
    public String addProductToCart(@RequestParam Long productId, HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        Long cartId = cartService.getCartId(sessionId);
        cartService.addProductToCart(productId, cartId);
        logger.info("Product with ID {} added to cart", productId);
        return "redirect:forward:/";
    }
    @PostMapping("/plus")
    public String plusProductToCart(@RequestParam Long productId, HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        Long cartId = cartService.getCartId(sessionId);
        cartService.addProductToCart(productId, cartId);
        logger.info("Product with ID {} added to cart", productId);
        return "redirect:/cart";
    }
    @PostMapping("/remove")
    public String removeProduct(@RequestParam Long productId, HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        Long cartId = cartService.getCartId(sessionId);
        this.cartService.deleteProductFromCart(productId, cartId);
        logger.info("Product with ID {} removed from cart", productId);
        return "redirect:/cart";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long productId, HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        Long cartId = cartService.getCartId(sessionId);
        this.cartService.trashProductFromCart(productId, cartId);
        logger.info("Product with ID {} deleted from cart", productId);
        return "redirect:/cart";
    }
}