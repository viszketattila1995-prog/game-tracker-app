package com.attila.taskmanager.gametrackerapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformDropdownResponse {

    private Long id;

    private String name;

    private String manufacturer;
}
