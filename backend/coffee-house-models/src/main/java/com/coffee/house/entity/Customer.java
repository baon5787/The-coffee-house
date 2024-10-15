package com.coffee.house.entity;

import java.util.Date;
import java.util.Set;

import com.coffee.house.enums.AuthenticationProvider;
import com.coffee.house.enums.Gender;
import com.coffee.house.orders.OrderInfo;
import com.coffee.house.products.Comment;
import com.coffee.house.products.Review;
import com.coffee.house.shopcart.CartInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "phone_number")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "photo_name")
    private String photoName;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "lasted_time")
    private Date lastedTime;

    @Column(name = "fail_attempt")
    private Integer failedAttempt;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "lock_time")
    private Date lockTime;

    @Column(name = "joined_date")
    private Date joinedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
    private AuthenticationProvider authProvider;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerReview")
    private Set<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerComment")
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<CustomerToken> tokens;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerCartInfo")
    private Set<CartInfo> cartInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerOrderInfo")
    private Set<OrderInfo> ordersInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerAddress")
    private Set<AddressCustomer> addressCustomers;
}
