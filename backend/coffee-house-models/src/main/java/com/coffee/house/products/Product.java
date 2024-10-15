package com.coffee.house.products;

import java.util.Set;

import com.coffee.house.banners.Banner;
import com.coffee.house.enums.Status;
import com.coffee.house.orders.OrderItem;
import com.coffee.house.shopcart.CartItem;

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
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "sku")
    private String sku;

    @Column(name = "product_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "default_image")
    private String defaultImage;

    @Column(name = "default_price")
    private Double defaultPrice;

    @Column(name = "image_name")
    private String imageName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Warehouse> warehouses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productCartItem", orphanRemoval = true)
    private Set<CartItem> cartItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productOrderItem", orphanRemoval = true)
    private Set<OrderItem> orderItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productSalesOff")
    private Set<SalesOff> salesOffs;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productBanner")
    private Set<Banner> banners;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productImage")
    private Set<ProductImage> productImages;
}
