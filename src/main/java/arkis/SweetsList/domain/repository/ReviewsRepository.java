package arkis.SweetsList.domain.repository;

import arkis.SweetsList.domain.model.Review;
import arkis.SweetsList.domain.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Integer>{
    Optional<Review> findById(Integer name);

    Optional<Review> findBySweets(Sweets sweets);
}
