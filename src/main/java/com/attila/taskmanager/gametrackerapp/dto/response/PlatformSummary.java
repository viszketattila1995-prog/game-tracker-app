package com.attila.taskmanager.gametrackerapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformSummary {

    private Long id;

    private String platformName;

    private String manufacturer;

    private Integer sumOfGames;

    private Long sumOfCompleted;
}
