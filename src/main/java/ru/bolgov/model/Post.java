package ru.bolgov.model;

import ru.bolgov.enums.ModerationStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    /** id поста */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Скрыта или активна публикация: 0 или 1 */
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    /** Статус модерации, по умолчанию значение "NEW" */
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "moderation_status", nullable = false)
    private ModerationStatus moderationStatus = ModerationStatus.NEW;

    /** ID пользователя-модератора, принявшего решение, или NULL */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "moderator_id", referencedColumnName="id")
    private User moderatedBy;

    /** Автор поста */
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName="id")
    private User author;

    /** Дата и время публикации поста */
    @NotNull
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    /** Заголовок поста */
    @NotBlank
    @Size(max=255)
    @Column(name = "title", nullable = false)
    private String title;

    /** Текст поста */
    @NotBlank
    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    /** Количество просмотров поста */
    @Column(name = "view_count", nullable = false)
    private int viewCount;
}
