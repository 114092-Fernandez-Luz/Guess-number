package ar.edu.utn.frc.tup.lciii.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Match {

    private Long id;

    private User user;

    private MatchDifficult difficult;

    private Integer numberToGuess;

    private Integer remaningTries;

    private MatchStatus status;
}
