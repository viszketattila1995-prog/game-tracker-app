package com.attila.taskmanager.gametrackerapp.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameCreateCommand {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Developer cannot be blank")
    private String developer;

    @NotNull(message = "Release Year cannot be empty")
    @Min(1970)
    @Max(2030)
    private Integer releaseYear;

    @NotNull(message = "Platform must be selected")
    private Long platformId;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    private String coverUrl;
}
