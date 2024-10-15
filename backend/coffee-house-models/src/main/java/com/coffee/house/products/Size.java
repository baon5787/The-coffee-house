package com.coffee.house.products;

import java.util.Set;

import com.coffee.house.orders.OrderItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "sizes")
public class Size {

    @Id
    @Column(name = "size_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "size_name")
    private String sizeName;

    @Column(name = "size_price")
    private Double sizePrice;

    @Column(name = "size_code")
    private String sizeCode;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "size")
    private Set<Warehouse> warehouses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "sizeOrderItem", orphanRemoval = true)
    private Set<OrderItem> orderItems;
}
