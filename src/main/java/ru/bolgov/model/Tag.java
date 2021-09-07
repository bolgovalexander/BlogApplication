package ru.bolgov.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tags")
public class Tag {

    /** id тэга */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Текст тэга */
    @NaturalId
    @NotBlank
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;
}
