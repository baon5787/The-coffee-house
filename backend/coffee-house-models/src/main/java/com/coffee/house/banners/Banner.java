package com.coffee.house.banners;

import com.coffee.house.products.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "banners")
public class Banner {

    @Id
    @Column(name = "banner_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "banner_image")
    private String bannerImage;

    @Column(name = "banner_image_name")
    private String bannerImageName;

    @Column(name = "banner_title")
    private String banner_title;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToOne()
    @JoinColumn(name = "banner_category_id")
    private BannerCategory bannerCategory;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product productBanner;
}
