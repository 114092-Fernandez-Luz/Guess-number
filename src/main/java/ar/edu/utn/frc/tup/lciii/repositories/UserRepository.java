package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import ar.edu.utn.frc.tup.lciii.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//cual es la entidad(tipo) con la cual voy a trabajar y el tipo de dato con el cual se identifica
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> getByEmail(String email);
    Optional<UserEntity> findById(Long userId);
}
