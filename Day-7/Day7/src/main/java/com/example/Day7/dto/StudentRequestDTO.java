package com.example.Day7.dto;

import jakarta.validation.constraints.*;

public class StudentRequestDTO {

    @NotBlank(message = "Name cannot be Empty")
    private String name;

    @NotNull(message = "Age is Required")
    @Min(value = 5, message = "Minimum age required is 5")
    @Max(value = 100, message = "Maximum age can be smaller then or equal to 100")
    private Integer age;

    @NotBlank(message = "Email cannot be Empty")
    @Email
    private String email;

    public StudentRequestDTO() {
    }

    public StudentRequestDTO(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
