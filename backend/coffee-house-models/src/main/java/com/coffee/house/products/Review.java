package com.coffee.house.products;

import java.util.Date;
import java.util.Set;

import com.coffee.house.entity.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "review_code")
    private String reviewCode;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "review_created")
    private Date reviewCreated;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerReview;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "review")
    private Set<Comment> comments;
}
