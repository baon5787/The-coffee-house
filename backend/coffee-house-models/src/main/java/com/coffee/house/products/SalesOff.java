package com.coffee.house.products;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "sales_off")
public class SalesOff {

    @Id
    @Column(name = "sales_off_id")
    private Integer id;

    @Column(name = "sales_off_code")
    private String salesOffCode;

    @Column(name = "sales_off_price")
    private String salesOffPrice;

    @Column(name = "sales_off_start")
    private Date salesOffStart;

    @Column(name = "sales_off_expired")
    private Date salesOffExpired;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product productSalesOff;
}
