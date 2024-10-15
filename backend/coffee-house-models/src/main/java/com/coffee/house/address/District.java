package com.coffee.house.address;

import java.util.Set;

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
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Integer id;

    @Column(name = "_name")
    private String districtName;

    @Column(name = "_prefix")
    private String districtPrefix;

    @ManyToOne()
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "district")
    private Set<Ward> wards;

    public String getFullDistrict() {
        return new StringBuilder()
                .append(districtPrefix)
                .append(" ")
                .append(districtName)
                .toString();
    }
}
