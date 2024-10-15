package com.coffee.house.address;

import java.util.Set;

import com.coffee.house.entity.AddressCustomer;
import com.coffee.house.entity.AddressUser;

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
@Table(name = "ward")
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ward_id")
    private Integer id;

    @Column(name = "_name")
    private String wardName;

    @Column(name = "_prefix")
    private String wardPrefix;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "wardUserAdresss")
    private Set<AddressUser> addressUsers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "wardCustomerAdresss")
    private Set<AddressCustomer> addressCustomers;

    public String getFullWard() {
        return new StringBuilder()
                .append(wardPrefix)
                .append(" ")
                .append(wardName)
                .toString();
    }
}
