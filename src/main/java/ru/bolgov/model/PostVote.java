package ru.bolgov.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_votes")
public class PostVote {
    /** id лайка/дизлайка */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Тот, кто поставил лайк / дизлайк */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    /** Пост, которому поставлен лайк / дизлайк */
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    /** Дата и время лайка / дизлайка */
    @NotNull
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    /** Лайк или дизлайк: 1 или -1 */
    @Column(name = "value", nullable = false, length = 1)
    private byte value;
}
