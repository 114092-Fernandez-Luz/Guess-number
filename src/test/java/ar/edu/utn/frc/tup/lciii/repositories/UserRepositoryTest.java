package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
public class UserRepositoryTest {

    @Autowired

    private TestEntityManager entityManager;

    @Autowired
    private  UserRepository userRepository;

    @Test
    public void getByEmailTest(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("LFernandez");
        userEntity.setEmail("114092@frc.utn.edu.ar");

        entityManager.persist(userEntity);
        entityManager.flush();

        Optional<UserEntity> result = userRepository.getByEmail("114092@frc.utn.edu.ar");
        assertEquals("LFernandez", result.get().getUserName());

    }
}
