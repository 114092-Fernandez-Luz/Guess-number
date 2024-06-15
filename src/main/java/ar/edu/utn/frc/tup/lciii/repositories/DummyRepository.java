package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.entities.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//cual es la entidad(tipo) con la cual voy a trabajar y el tipo de dato con el cual se identifica
@Repository
public interface DummyRepository extends JpaRepository<DummyEntity, Long> {
}
