package com.bestbuykamps.websiteshop.web_controller;
import com.bestbuykamps.websiteshop.business_service.CartService;
import com.bestbuykamps.websiteshop.business_service.ProductService;
import com.bestbuykamps.websiteshop.data_model.CartItem;
import com.bestbuykamps.websiteshop.data_model.Product;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopRestController {
    private final ProductService productService;
    private final CartService cartService;

    public ShopRestController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }
    //TODO dodać przpięcie z ręki 1L na otrzymywany w przyszłości cartID
    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
    }

    @RequestMapping(path = "/products", method = RequestMethod.DELETE)
    public void deleteProduct(@RequestBody Product product) {
        this.productService.deleteProduct(product);
    }

    @RequestMapping(path = "/cart", method = RequestMethod.POST)
    public List<CartItem> showCart(@RequestBody Long cartId) {
        return this.cartService.getCartItems(cartId);
    }

    @RequestMapping(path = "/cart/totalPrice", method = RequestMethod.POST)
    public BigDecimal getTotalPrice(@RequestBody Long cartId) {
        return this.cartService.getTotalCartValue(cartId);
    }
}