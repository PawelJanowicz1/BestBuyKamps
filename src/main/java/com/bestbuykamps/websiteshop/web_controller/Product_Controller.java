package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/")
public class Product_Controller {

    private final ProductService productService;
    private final CartService cartService;
    private final SessionUtil sessionUtil;


    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    public Product_Controller(ProductService productService, CartService cartService, SessionUtil sessionUtil) {
        this.productService = productService;
        this.cartService = cartService;
        this.sessionUtil = sessionUtil;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(Model model, HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        logger.info(sessionId);
        model.addAttribute("sessionId", sessionId);
        model.addAttribute("products", this.productService.getProducts());
        return "PRODUCTS_PAGE";
    }

   @GetMapping("/cart")
    public String showCartPage(Model model, HttpServletRequest request) {
       String sessionId = sessionUtil.checkSession(request);
       logger.info("wlazłem do showCartPage w PC");
       Long cartId = cartService.getCartId(sessionId);
       logger.info("cart Id: {}", cartId);
       model.addAttribute("cartItems", this.cartService.getCartItems(cartId));
       model.addAttribute("totalCartValue", this.cartService.getTotalCartValue(cartId));
       return "CART_PAGE";
   }

    @PostMapping()
    public String addProductToCart(@RequestParam Long productId, HttpServletRequest request) {
        String sessionId = sessionUtil.checkSession(request);
        Long cartId = cartService.getCartId(sessionId);
        cartService.addProductToCart(productId, cartId);
        return "PRODUCTS_PAGE";
    }

    @GetMapping("/login")
    public String moveToLoginPage(){
        return "LOGIN_PAGE";
    }
}