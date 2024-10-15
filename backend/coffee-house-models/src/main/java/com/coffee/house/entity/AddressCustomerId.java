package com.coffee.house.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
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
public class AddressCustomerId implements Serializable {

    @Column(name = "size_id")
    private int productId;

    @Column(name = "ward_id")
    private int wardId;
}
