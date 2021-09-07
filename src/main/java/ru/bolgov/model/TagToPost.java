package ru.bolgov.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tag2post")
public class TagToPost {

    /** id связи */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** id поста */
    @NotBlank
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "post_id", referencedColumnName="id")
    private Post post;

    /** id тэга */
    @NotBlank
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tag_id", referencedColumnName="id")
    private Tag tag;
}
