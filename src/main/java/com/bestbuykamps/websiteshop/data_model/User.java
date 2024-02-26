package com.bestbuykamps.websiteshop.data_model;
import jakarta.persistence.*;
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "contact_details_id", insertable = false, updatable = false)
    private Long contactDetailsId;

    @OneToOne
    @JoinColumn(name = "contact_details_id", referencedColumnName = "id")
    private ContactDetails contactDetails;

    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

}