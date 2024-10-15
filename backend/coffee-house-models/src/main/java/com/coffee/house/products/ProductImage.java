package com.coffee.house.products;

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
@Table(name = "product_images")
public class ProductImage {

    @Id
    @Column(name = "product_image_id")
    private Integer id;

    @Column(name = "product_image_name")
    private String productImageName;

    @Column(name = "product_image_url")
    private String productImageUrl;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product productImage;
}
