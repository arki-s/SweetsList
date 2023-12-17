package arkis.SweetsList.domain.repository;

import arkis.SweetsList.domain.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SweetsRepository extends JpaRepository<Sweets, Integer>{
}
