package arkis.SweetsList.domain.service;

import arkis.SweetsList.domain.repository.SweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SweetsService {

    @Autowired
    SweetsRepository sweetsRepository;
}
