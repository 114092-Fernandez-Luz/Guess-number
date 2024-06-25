package ar.edu.utn.frc.tup.lciii.dtos;

import ar.edu.utn.frc.tup.lciii.models.MatchDifficult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private MatchDifficult difficult;

    private Integer remaningTries;

}
