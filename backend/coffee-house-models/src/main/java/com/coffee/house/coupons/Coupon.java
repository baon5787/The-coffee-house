package com.coffee.house.coupons;

import java.util.Date;
import java.util.Set;

import com.coffee.house.enums.CouponStatus;
import com.coffee.house.enums.CouponType;
import com.coffee.house.orders.OrderInfo;
import com.coffee.house.products.Product;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "coupons")
public class Coupon {

    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "coupon_quantity")
    private Integer couponQuantity;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "coupon_condition")
    private Integer couponCondition;

    @Column(name = "coupon_price")
    private Double couponPrice;

    @Column(name = "coupon_expired")
    private Date couponExpired;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status")
    private CouponStatus couponStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type")
    private CouponType couponType;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "coupon_category_id")
    private CouponCategory couponCategory;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productCoupon;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "couponOrderInfo")
    private Set<OrderInfo> orderInfos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "couponCartInfo")
    private Set<CartInfo> cartInfos;
}
