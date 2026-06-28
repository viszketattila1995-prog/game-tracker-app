package com.attila.taskmanager.gametrackerapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameItem {

    private Long id;

    private String title;

    private String developer;

    private Integer releaseYear;

    private String platformName;

    private String manufacturer;

    private String coverUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime addedAt;
}
