package com.ray.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Data//lonbom library
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private Integer price;
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")// jackson library
    private Date releaseDate;
    private boolean productAvailable;
    private Integer stockQuantity;

    private String imageName;
    private String imageType;
    @Lob// jpa persistance
    private byte[] imageDate;
}
