package com.bestbuykamps.websiteshop.business_service;


import java.util.Optional;

import com.bestbuykamps.websiteshop.data_model.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class CartServiceTest {
//    /*    @Autowired
//        private CartRepository cartRepository;
//        @Autowired
//        private ProductRepository productRepository;
//        @Autowired
//        private CartItemRepository cartItemRepository;*/
//    @Autowired
//    private CartService cartService;
//
//    //    @InjectMocks
////    private CartService cartService;
//    private String sessionId;
//    private Long productId;
//    private Long cartId;
//    private CartItem cartItem;
//    private Product product;
//
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        cartService = new CartService(cartRepository, productRepository, cartItemRepository);
//        Product product1 = new Product("Call of duty Modern Warfare 3", "Gry Komputerowe", 59.99);
//        sessionId = "sessionId";
//        productId = 1L;
//        cartId = 1L;
//        Cart cart = createCart();
//        cartItem = new CartItem();
//        cartItem.setQuantity(1);
//        cartItem.setProductId();
//        cart.setCartItems();
//        when(cartService.getCartIdBySessionId(sessionId)).thenReturn(cart.getId());
//        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
//    }
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//   /* @Test
//    public void testFindAllProducts() {
//        Discount discount = new Discount("PERCENT", 10.0);
//        Product product1 = new Product("Call of duty Modern Warfare 3", "Gry Komputerowe", 59.99, discount, "/images/callofduty.jpg");
//        Product product2 = new Product("Cyberpunk 2077", "Gry Komputerowe", 49.99, discount, "/images/Cyberpunk_2077.jpeg");
//
//        List<Product> expectedProducts = Arrays.asList(product1, product2);
//    }*/
//
//    @SpringBootTest
//    public void whenDeleteProductFromCart_thenProductIsRemovedAndCartSaved() {
//        deleteProductAndAssertItIsRemoved(sessionId, productId, cartId);
//        verify(cartRepository, times(1)).save(any(Cart.class));
//    }
//
//    private void deleteProductAndAssertItIsRemoved(String sessionId, Long productId, Long cartId) {
//
//        cartService.deleteProductFromCart(sessionId, productId);
//        Cart updatedCart = cartRepository.findById(cartId).get();
//        assertFalse(updatedCart.getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)));
//    }
//
//    private Cart createCart() {
//        Cart cart = new Cart();
//        cart.setId(cartId);
//        cart.setSessionId(sessionId);
//        CartItem cartItem = new CartItem();
//        cartItem.setId(1L);
//        cartItem.setCart(cart);
//        Product product = new Product();
//        product.setId(productId);
//        cartItem.setProduct(product);
//        cart.getCartItems().add(cartItem);
//        return cart;
//    }
//
//    @BeforeEach
//    public void setup() {
//        cartService = new CartService(cartRepository, productRepository, cartItemRepository);
//    }
//
//    @Test
//    public void addCartItemTest() {
//        Long cartId = 1L;
//        Long productId = 1L;
//        Cart cart = new Cart();
//        Product product = new Product();
//
//        when(cartRepository.getById(anyLong())).thenReturn(cart);
//        when(productRepository.getById(anyLong())).thenReturn(product);
//
//        cartService.addCartItem(productId, cartId);
//
//        verify(cartItemRepository, times(1)).save(Mockito.any(CartItem.class));
//    }

}