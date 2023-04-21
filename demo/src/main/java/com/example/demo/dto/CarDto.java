package com.example.demo.dto;

import com.example.demo.Marker;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    private Long id;
    @NotBlank(groups = {Marker.Create.class})
    private String stamp;
    @NotBlank(groups = {Marker.Create.class})
    private String model;
    @NotNull(groups = {Marker.Create.class})
    private Integer year;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 14, message = "Длина должна быть не более 14 символов")
    private String transmission;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 10, message = "Длина должна быть не более 10 символов")
    private String carBody;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 10, message = "Длина должна быть не более 10 символов")
    private String carColorBody;
    @NotBlank(groups = {Marker.Create.class})
    private String engineCapacity;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 13, message = "Длина должна быть не более 13 символов")
    private String fuelType;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 15, message = "Длина должна быть не более 15 символов")
    private String drive;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 6, message = "Длина должна быть не более 6 символов")
    private String wheel;
    @NotBlank(groups = {Marker.Create.class})
    @Size(groups = {Marker.Create.class, Marker.Update.class},
            max = 9, message = "Длина должна быть не более 9 символов")
    private String stateNumber;
    @NotNull(groups = {Marker.Create.class})
    private long owner;
}
