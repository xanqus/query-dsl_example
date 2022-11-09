package com.ll.exam.qsl.product.domain;

import com.ll.exam.qsl.base.MyGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(generator = MyGenerator.generatorName)
    @GenericGenerator(name = MyGenerator.generatorName, strategy = "com.ll.exam.qsl.base.MyGenerator")
    private String productId;

    private String productName;

    private Integer price;

    private Integer stockQuantity;

}
