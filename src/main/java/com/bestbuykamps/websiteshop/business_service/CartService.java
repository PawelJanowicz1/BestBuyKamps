package com.bestbuykamps.websiteshop.business_service;

import com.bestbuykamps.websiteshop.data_model.*;
import com.bestbuykamps.websiteshop.data_model.CartItemRepository;
import com.bestbuykamps.websiteshop.data_model.CartRepository;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import com.bestbuykamps.websiteshop.web_controller.CheckoutController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    private final CartItemRepository cartItemRepository;
    private static final Logger log = LoggerFactory.getLogger(CartService.class);

    private static final Logger logger = LoggerFactory.getLogger(CheckoutController.class);


    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }


    public void addProductToCart(Long productId, Long cartId) {
        log.info("Adding product with ID {} to the cart.", productId);
        // Sprawdzenie czy cart nie jest pusty
        boolean match = cartRepository.getById(cartId).getCartItems() == null;
        if (!match) {
            // cart nie był pusty
            for (CartItem cartItem : cartRepository.getById(cartId).getCartItems()) {
                // sprawdzenie czy w koszyku znajduje się item ktory chcemy dodać
                if (cartItem.getProduct().getId().equals(productId)) {
                    // produkt został znaleziony więc zwiększamy jego quantity
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItemRepository.save(cartItem);
                }
            }
            if(!cartRepository.getById(cartId).getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId))) {
                // produkt nie został znaleziony wiec dodajemy go do koszyka z quantity 1
                addCartItem(productId, cartId);
            }
        } else {
            // koszyk był pusty więc dodajemy go do koszyka z quantity 1
            addCartItem(productId, cartId);
        }
    }

    //TODO: naprawić minus
    public void deleteProductFromCart(Long productId, Long cartId) {
        // odpytanie czy koszyk istnieje
        // nie istnieje - ogarnać wyjątek
        // istnieje - sprawdzić czy jest klucz w mapie o wartości productId
        // jeżeli q: równe 1 , usuwamy klucz+wartość
        //jeżeli q: > 1(2,3...X) zmniejszamy q: o 1
        Optional<Cart> cart = cartRepository.findById(cartId);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                    if (cartItem.getQuantity() == 0) {
                        trashProductFromCart(productId, cartId);
                        break;
                    }
                    break;
                    //wyjście z forEach
                }
            }
            cartRepository.save(cart.get());
        }
    }

    public void trashProductFromCart(Long productId, Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        boolean match = cart.get().getCartItems().stream().anyMatch(item -> item.getProduct().getId().equals(productId)); // zwraca boolean czy produkt jest w koszyku
        if (match) {
            for (CartItem cartItem : cart.get().getCartItems()) {
                if (cartItem.getProduct().getId().equals(productId)) {
                    cart.get().deleteCartItem(cartItem);
                    break;
                }
            }
            cartRepository.save(cart.get());
        }
    }

    public List<CartItem> getCartItems(Long cartId) {
        return this.cartRepository.findById(cartId).get().getCartItems();
    }

    // total cart value poprawione na BigDecimal
    public BigDecimal getTotalCartValue(Long cartId){
        Optional<Cart> cart = cartRepository.findById(cartId);
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem cartItem : cart.get().getCartItems()) {
            BigDecimal productPrice = BigDecimal.valueOf(cartItem.getProduct().getPrice());
            BigDecimal quantity = BigDecimal.valueOf(cartItem.getQuantity());
            totalPrice = totalPrice.add(productPrice.multiply(quantity));
        }
        return totalPrice;
    }

    public Long getCartIdBySessionId(String sessionId){
        List<Cart> carts = cartRepository.findAll();
        for (Cart cart: carts ) {
            if(cart.getSessionId().equals(sessionId)){
                return cart.getId();
            }
        }
        return -1L;
    }

    // zwraca cart Id w postaci longa na podstawie sessionId
    public Long getCartId(String sessionId) {
        // jesli pamiętaliśmy w endpoincie przejść przez sessionUtil.checkSession(request); to wiemy na pewno, że koszyk i sesja istnieją
        // czyli wystarczy znaleźć ID koszyka po ID sesji
        Optional<Cart> cartWithMatchingSessionId = cartRepository.findAll().stream().filter(cart -> cart.getSessionId().equals(sessionId)).findFirst();
        return cartWithMatchingSessionId.get().getId();


//        logger.info("wlazłem do getCartId, sessionId: {}", sessionId);
//        Optional<Cart> cart = createCart(sessionId);
//        logger.info("Current cart ID: {}", cart.get().getId().toString());
//        return cart.get().getId();
    }

    public void createCart (String sessionId){
        Optional<Cart> cart = findCartIdBySessionId(sessionId);
        if (cart.isEmpty()) {
            cart = Optional.of(new Cart());
            cart.get().setSessionId(sessionId);
            cart.get().setCartItems(new ArrayList<>());
            cartRepository.save(cart.get());
            cartRepository.flush();
        }
//        return cart;
    }

    public Optional<Cart> findCartIdBySessionId(String sessionId) {
        boolean isCartFound = cartRepository.findAll().stream().anyMatch(cart -> cart.getSessionId().equals(sessionId));
        if(isCartFound){
            List<Cart> carts = cartRepository.findAll();
            for (Cart cart: carts ) {
                if(cart.getSessionId().equals(sessionId)){
                    return Optional.of(cart);
                }
            }
//            logger.info(String.valueOf(Optional.of(cartRepository.findAll().stream().findFirst().filter(cart -> cart.getSessionId().equals(sessionId)).get())));
//            return Optional.of(cartRepository.findAll().stream().findFirst().filter(cart -> cart.getSessionId().equals(sessionId)).get());
        }
        logger.info("jestem pusty");
        return Optional.empty();
    }

    public Cart getCart(String sessionId) {
        return cartRepository.findAll().stream()
                .filter(cart -> cart.getSessionId().equals(sessionId))
                .findFirst()
                .orElse(null);
    }

    public void addCartItem(Long productId, Long cartId){
        CartItem cartItem = new CartItem();
        cartItem.setCart(cartRepository.getById(cartId));
        cartItem.setQuantity(1);
        cartItem.setProduct(productRepository.getById(productId));
        logger.info("Item ustawiony");
        logger.info(cartItem.toString());
        cartItemRepository.save(cartItem);
    }
}
