package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.models.Match;
import ar.edu.utn.frc.tup.lciii.models.MatchDifficult;
import ar.edu.utn.frc.tup.lciii.models.RoundMatch;
import ar.edu.utn.frc.tup.lciii.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {

    Match createMatch (User user, MatchDifficult difficulty);
    Match getMatchById (Long matchId);

    RoundMatch playMatch(Match match, Integer number);
}
