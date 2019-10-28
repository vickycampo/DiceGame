package com.DicesGame.game.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Getter @Setter @NoArgsConstructor

public class Dices
{
    private Integer rollId;

    private Integer diceNumber;

    private Integer roll;
}