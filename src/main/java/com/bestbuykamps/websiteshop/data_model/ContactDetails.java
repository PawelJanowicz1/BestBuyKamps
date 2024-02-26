package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;
@Entity
@Table(name = "contact_details")
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "adress", length = 300)
    private String adress;

    @Column(name = "postal_code", length = 6)
    private String postalCode;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "phone_number", length = 9)
    private String phoneNumber;

    @Column(name = "email", length = 30)
    private String email;
    @Column(name = "country", length = 20)
    private String country;

    @Column(name = "cart_id")
    private Long cartId;

    @OneToOne(mappedBy = "contactDetails")
    @JoinColumn(name = "cart_id")
    private Cart cart;


    @OneToOne(mappedBy = "contactDetails")
    @JoinColumn(name = "user_id")
    private User user;

    //konstruktor domyślny
    public ContactDetails() {
    }

    // gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCountry(String country) {
        this.country = country;

    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", cartId=" + cartId +
                ", cart=" + cart.getId() +
                ", user=" + user +
                '}';
    }
}