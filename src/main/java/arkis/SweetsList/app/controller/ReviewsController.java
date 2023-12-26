package arkis.SweetsList.app.controller;

import arkis.SweetsList.domain.model.Review;
import arkis.SweetsList.domain.model.Sweets;
import arkis.SweetsList.domain.repository.ReviewsRepository;
import arkis.SweetsList.domain.repository.SweetsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @PostMapping("review/create")
    public ModelAndView reviewcreate(ModelAndView mav, @ModelAttribute("reviewModel")Review review, RedirectAttributes redirectAttributes){

        LocalDate today = LocalDate.now();
        review.setDate(today);
        reviewsRepository.saveAndFlush(review);

        Optional<Sweets> data = sweetsRepository.findById(review.getSweets().getSweetsId());
        Sweets s = data.get();
        mav.addObject("sweets", s);
        int sweetsId = s.getSweetsId();

        redirectAttributes.addAttribute("sweetsId",sweetsId);
        return new ModelAndView("redirect:/sweets/detail/{sweetsId}");
    }

    @Transactional
    @PostMapping("review/{reviewId}/delete")
    public ModelAndView deleteReview(ModelAndView mav, @RequestParam Integer reviewId){
        reviewsRepository.deleteById(reviewId);

        return new ModelAndView("redirect:/review/index");
    }


}
