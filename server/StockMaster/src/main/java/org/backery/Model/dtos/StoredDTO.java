package org.backery.Model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.backery.Model.Entities.Product;

import java.time.LocalDate;


@Data
@Setter
@Getter
@AllArgsConstructor
public class StoredDTO {

    int id;
    String name;
    Product idProduct;
    int available;
    LocalDate updated;
}
