package org.backery.Model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Setter
@Getter
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "product ID is mandatory")
    @Size(min = 3, max=50, message = "product ID should have at least 3 characters")
    int id;

    @NotBlank(message = "product name is mandatory")
    @Size(min = 5, max=50, message = "product name should have at least 5 characters")
    String name;
    @NotBlank(message = "product description is mandatory")
    @Size(min = 5, max=50, message = "product description should have at least 5 characters")
    String description;
    @NotBlank(message = "product image is mandatory")
    String imageurl;
}
