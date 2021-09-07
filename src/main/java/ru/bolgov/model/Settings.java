package ru.bolgov.model;

import org.hibernate.annotations.NaturalId;
import ru.bolgov.enums.GlobalSettings;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "global_settings")
public class Settings {

    /** id настройки */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Системное имя настройки */
    @NaturalId
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "code", nullable = false)
    private GlobalSettings.Code code;

    /** Название настройки */
    @NotBlank
    @Size(max=255)
    @Column(name = "name", nullable = false)
    private String name;

    /** Значение настройки */
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "value", nullable = false)
    private GlobalSettings.Value value;

}
