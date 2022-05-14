package com.example.th2.entity;

import com.example.th2.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity extends Product {

    @Id
    @Column(name = "code")
    @Override
    public String getCode() {
        return super.getCode();
    }

    @Column(name = "description")
    @Override
    public String getDes() {
        return super.getDes();
    }

    @Column(name = "price")
    @Override
    public double getPrice() {
        return super.getPrice();
    }
}
