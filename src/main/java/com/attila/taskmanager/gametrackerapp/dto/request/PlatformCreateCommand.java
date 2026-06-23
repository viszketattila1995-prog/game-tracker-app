package com.attila.taskmanager.gametrackerapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformCreateCommand {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "This field cannot be blank")
    private String manufacturer;
}
