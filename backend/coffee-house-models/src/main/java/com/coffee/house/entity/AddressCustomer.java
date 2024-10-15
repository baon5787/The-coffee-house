package com.coffee.house.entity;

import com.coffee.house.address.Ward;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "address_customers")
public class AddressCustomer {

    @EmbeddedId
    private AddressCustomerId primaryKey;

    @Column(name = "road")
    private String road;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "seletive")
    private Boolean seletive;

    @Column(name = "shipping")
    private Boolean shipping;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customerAddress;

    @ManyToOne()
    @JoinColumn(name = "ward_id")
    private Ward wardCustomerAdresss;
}
