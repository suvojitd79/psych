package com.psych.game.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "players", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Player extends Human{

    @NotBlank
    @Getter
    @Setter
    private String email;

}
