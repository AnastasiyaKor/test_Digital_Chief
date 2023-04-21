package com.example.demo.dto;

import com.example.demo.Marker;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    @NotBlank(groups = {Marker.Create.class})
    @Email(groups = {Marker.Create.class, Marker.Update.class})
    private String email;
    @NotBlank(groups = {Marker.Create.class})
    private String phoneNumber;
}
