package ru.bolgov.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
public class Comment {

    /** id комментария */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Комментарий, на который оставлен этот комментарий (может быть NULL,
     * если комментарий оставлен просто к посту)
     */
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName = "id")
    private Comment parentComment;

    /** Пост, к которому написан комментарий */
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Post post;

    /** Автор комментария */
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private User user;

    /** Дата и время комментария */
    @NotNull
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    /** Текст комментария */
    @NotBlank
    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;
}