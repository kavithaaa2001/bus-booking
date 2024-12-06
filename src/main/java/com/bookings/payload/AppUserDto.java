package com.bookings.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUserDto {
    private Long id;


    @Size(min=2,max=30,message = "name field shd be at least 2 char and less than 30")
    private String name;


    @Pattern(regexp= "^[A-Za-z0-9._%+-]+@gmail.com$",message = "Invalid email format")
    private String email;


    @Pattern(regexp="^\\+\\d{1,3}\\s?[6-9]\\d{9}$",message = "invalid mobile number")
    private String mobile;


    @Size(min=3,max=10,message = "username shd be at least 3 or less than 10 char")
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", message = "Password must be at least 8 characters long, "
            + "contain one uppercase, one lowercase, one number, "
            + "and one special character.")
    private String password;



}