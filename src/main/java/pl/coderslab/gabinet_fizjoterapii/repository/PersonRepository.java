package pl.coderslab.gabinet_fizjoterapii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.gabinet_fizjoterapii.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByEmail(String email);

    boolean existsPersonByEmail(String email);

    @Query("select p.password from Person p where p.email = :email")
    String findPasswordByEmail(@Param("email") String email);
}