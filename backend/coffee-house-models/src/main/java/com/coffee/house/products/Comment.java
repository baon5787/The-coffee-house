package com.coffee.house.products;

import java.util.List;

import com.coffee.house.entity.Customer;
import com.coffee.house.entity.User;

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
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToOne()
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customerComment;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userComment;

    @ManyToOne()
    @JoinColumn(name = "comment_parent_id")
    private Comment parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Comment> children;
}
