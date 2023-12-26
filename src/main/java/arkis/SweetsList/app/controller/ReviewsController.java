package arkis.SweetsList.app.controller;

import arkis.SweetsList.domain.model.Review;
import arkis.SweetsList.domain.model.Sweets;
import arkis.SweetsList.domain.repository.ReviewsRepository;
import arkis.SweetsList.domain.repository.SweetsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReviewsController {

    @Autowired
    ReviewsRepository reviewsRepository;

    @Autowired
    SweetsRepository sweetsRepository;

    @GetMapping("review/index")
    public ModelAndView reviewIndex(ModelAndView mav){
        mav.setViewName("review/index");

        List<Review> reviewList = reviewsRepository.findAll();
        mav.addObject("reviewList", reviewList);

        return mav;
    }

    @Transactional
    @PostMapping("review/{reviewId}/delete")
    public ModelAndView deleteReview(ModelAndView mav){

        return new ModelAndView("redirect:/review/index");
    }


}
