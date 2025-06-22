package com.ecommerce.project.payload;

import com.ecommerce.project.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddressDTO {


    private Long addressId;

    private String street;

    private String buildingName;

    private String city;

    private String state;

    private String country;

    private String zipcode;

}
