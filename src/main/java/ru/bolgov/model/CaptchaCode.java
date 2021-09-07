package ru.bolgov.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "captcha_codes")
public class CaptchaCode {

    /** id каптча */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Дата и время генерации кода капчи */
    @NotNull
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    /** Код, отображаемый на картинкке капчи */
    @NotBlank
    @Column(name = "code", nullable = false)
    private String code;

    /** Код, передаваемый в параметре */
    @NotBlank
    @Column(name = "secret_code", nullable = false)
    private String secretCode;
}
