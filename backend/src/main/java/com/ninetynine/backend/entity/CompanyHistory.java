package com.ninetynine.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class CompanyHistory {

    @Id
    @GeneratedValue
    private Long id;
    private String sharePrice;
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_company", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;

    public CompanyHistory(Company company, String sharePrice, LocalDateTime dateTime) {
       this.company = company;
        this.sharePrice = sharePrice;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompanyHistory company = (CompanyHistory) o;
        return id != null && Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
