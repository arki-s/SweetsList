package arkis.SweetsList.domain.service;

import arkis.SweetsList.domain.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewsService {

    @Autowired
    ReviewsRepository reviewsRepository;
}
