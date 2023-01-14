package com.ecommerce.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdminDto {
    @Size(min = 3 , max = 10 , message =  "Invalid first name(3-10 characters)" )
    private String firstname;
    @Size(min = 3 , max = 10 , message = "Invalid lastName name(3-10 characters)")
    private String lastName;

    private String userName;
    @Size(min   = 3 , max = 10 , message = "Invalid password name(3-10 characters)")
    private String password;

    private String repeatPassword;



}
