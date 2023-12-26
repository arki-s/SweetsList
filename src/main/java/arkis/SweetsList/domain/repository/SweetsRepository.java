package arkis.SweetsList.domain.repository;

import arkis.SweetsList.domain.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SweetsRepository extends JpaRepository<Sweets, Integer>{
    Optional<Sweets> findById(Integer name);

}
