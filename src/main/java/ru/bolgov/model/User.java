package ru.bolgov.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    /** id пользователя */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Является ли пользователь модератором (может ли править
     * глобальные настройки сайта и модерировать посты)
     */
    @NotNull
    @Column(name = "is_moderator", nullable = false)
    private Boolean isModerator;

    /** Дата и время регистрации пользователя */
    @NotNull
    @Column(name = "reg_time", nullable = false)
    private LocalDateTime regTime;

    /** Имя пользователя */
    @NotBlank
    @Size(max=255)
    @Column(name = "name", nullable = false)
    private String name;

    /** E-mail пользователя */
    @NaturalId(mutable = true)
    @Email
    @NotBlank
    @Size(max=255)
    @Column(name = "email", nullable = false)
    private String email;

    /** Хэш пароля пользователя */
    @NotBlank
    @Size(max=255)
    @Column(name = "password", nullable = false)
    private String password;

    /** Код для восстановления пароля, может быть NULL */
    @Column(name = "code")
    private String code;

    /** Фотография (ссылка на файл), может быть NULL */
    @Column(name = "photo", columnDefinition = "TEXT")
    private String photo;

    /** Публикации пользователя */
    @NotNull
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Post> posts = new HashSet<>();

    /** Публикации, модерируемые пользователем */
    @NotNull
    @OneToMany(mappedBy = "moderatedBy", fetch = FetchType.LAZY, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.EXTRA)
    private final Set<Post> moderatedPosts = new HashSet<>();

    /** Комментарии пользователя */
    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<Comment> comments = new HashSet<>();

    /** Лайки / дизлайки пользователя */
    @NotNull
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<PostVote> votes = new HashSet<>();
}
