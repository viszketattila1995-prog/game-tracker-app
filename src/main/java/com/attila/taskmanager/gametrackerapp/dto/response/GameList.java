package com.attila.taskmanager.gametrackerapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameList {

    private Long id;

    private String title;

    private String developer;

    private String platformName;

    private String status;

    private String coverUrl;
}
