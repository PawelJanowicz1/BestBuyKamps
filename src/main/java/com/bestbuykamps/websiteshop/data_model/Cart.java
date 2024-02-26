package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "contact_details_id")
    private ContactDetails contactDetails;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "session_id")
    private String sessionId;

    public Cart() {
    }
    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getSessionId() {
        return sessionId;
    }


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void deleteCartItem(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItems=" + cartItems +
                ", contactDetails=" + contactDetails +
                ", userId=" + userId +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
    public void setId(Long cartId) {
    }
}