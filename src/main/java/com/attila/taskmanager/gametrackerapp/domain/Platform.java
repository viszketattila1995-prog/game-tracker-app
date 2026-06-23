package com.attila.taskmanager.gametrackerapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "platform")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String manufacturer;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL)
    private List<Game> games;

}
