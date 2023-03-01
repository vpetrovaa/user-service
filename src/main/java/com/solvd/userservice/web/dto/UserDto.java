package com.solvd.userservice.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @NotNull(message = "Id is required")
    private Long id;

    @NotNull(message = "Email is required")
    @Length(max = 45, message = "Email must be shorter than 45 characters")
    @Email(message = "Email is not valid")
    private String email;

    @NotNull(message = "Name is required")
    @Length(max = 45, message = "Name must be shorter than 45 characters")
    private String name;

    @NotNull(message = "Surname is required")
    @Length(max = 45, message = "Surname must be shorter than 45 characters")
    private String surname;

}