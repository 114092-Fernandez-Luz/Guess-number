package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.models.MatchDifficult;
import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private MatchDifficult difficult;

    @Column
    private Integer numberToGuess;
    @Column
    private Integer remaningTries;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}
