package arkis.SweetsList.app.controller;

import arkis.SweetsList.domain.model.Review;
import arkis.SweetsList.domain.model.Sweets;
import arkis.SweetsList.domain.repository.ReviewsRepository;
import arkis.SweetsList.domain.repository.SweetsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class SweetsController {

    @Autowired
    SweetsRepository sweetsRepository;

    @Autowired
    ReviewsRepository reviewsRepository;

    @GetMapping("sweets/index")
    public ModelAndView sweetsindex(ModelAndView mav){
        mav.setViewName("sweets/index");

        List<Sweets> sweetsList = sweetsRepository.findAll();
        mav.addObject("sweetsList", sweetsList);

        return mav;
    }

    @GetMapping("sweets/{sweetsId}/detail")
    public ModelAndView sweetsdetail(ModelAndView mav, @PathVariable int sweetsId){
        mav.setViewName("sweets/detail");
        Optional<Sweets> data = sweetsRepository.findById((Integer)sweetsId);
        mav.addObject("sweets", data.get());
        return mav;
    }

    @GetMapping("sweets/create")
    public ModelAndView sweetscreate(ModelAndView mav, @ModelAttribute("formModel")Sweets sweets){
        mav.setViewName("sweets/create");
        return mav;
    }

    @PostMapping("sweets/create")
    public ModelAndView sweetscreateform(ModelAndView mav, @ModelAttribute("formModel")Sweets sweets){
        sweetsRepository.saveAndFlush(sweets);
        return new ModelAndView("redirect:/sweets/index");
    }

    @GetMapping("sweets/{sweetsId}/edit")
    public ModelAndView sweetsedit(ModelAndView mav, @ModelAttribute("formModel")Sweets sweets, @PathVariable int sweetsId){
        mav.setViewName("sweets/edit");
        Optional<Sweets> data = sweetsRepository.findById((Integer)sweetsId);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @Transactional
    @PostMapping("sweets/edit")
    public ModelAndView sweetseditform(ModelAndView mav, @ModelAttribute("formModel")Sweets sweets){
        sweetsRepository.saveAndFlush(sweets);
        return new ModelAndView("redirect:/sweets/index");
    }

    @Transactional
    @PostMapping("sweets/{sweetsId}/delete")
    public ModelAndView sweetsdelete(ModelAndView mav, @RequestParam Integer sweetsId){
        sweetsRepository.deleteById(sweetsId);
        return new ModelAndView("redirect:/sweets/index");
    }

    @GetMapping("sweets/detail/{sweetsId}")
    public ModelAndView sweetsdetail(ModelAndView mav, @ModelAttribute("reviewModel")Review review,@PathVariable Integer sweetsId){
        mav.setViewName("sweets/detail");

        Optional<Sweets> data = sweetsRepository.findById(sweetsId);
        Sweets sweets = data.get();
        mav.addObject("sweets", sweets);

        LocalDate today = LocalDate.now();
        mav.addObject("today", today);

        mav.addObject("reviewModel", new Review());

        return mav;
    }

    @PostConstruct
    public void init() {
        Sweets s1 = new Sweets();
        s1.setName("クリスマスパンケーキ");
        s1.setComment("ピスタチオのクリームが惜しみなくトッピングされた一品");
        s1.setCalorie(2000);
        sweetsRepository.saveAndFlush(s1);

        Sweets s2 = new Sweets();
        s2.setName("りんごのパンケーキ");
        s2.setComment("りんごのコンポートが惜しみなくトッピングされた一品");
        s2.setCalorie(2000);
        sweetsRepository.saveAndFlush(s2);

        Sweets s3 = new Sweets();
        s3.setName("ハロウィンパンケーキ");
        s3.setComment("紫芋のクリームが惜しみなくトッピングされた一品");
        s3.setCalorie(2000);
        sweetsRepository.saveAndFlush(s3);

        Sweets s4 = new Sweets();
        s4.setName("スイートポテトパンケーキ");
        s4.setComment("安然芋のクリームが惜しみなくトッピングされた一品");
        s4.setCalorie(2000);
        sweetsRepository.saveAndFlush(s3);


        LocalDate today = LocalDate.now();

        Review r1 = new Review();
        r1.setDate(today);
        r1.setComment("クリスマスにふさわしい一品でした！ただ、たっぷりのクリームのほかにソースを追加しないとちょっとボソボソしちゃうかも。");
        r1.setRating(4);
        r1.setSweets(s1);
        reviewsRepository.saveAndFlush(r1);

        Review r2 = new Review();
        r2.setDate(today.minusDays(2));
        r2.setComment("キャラメルクリームが美味しかったです。ただ、個人的にりんごのコンポートがちょっと多すぎかなという印象でした。");
        r2.setRating(3);
        r2.setSweets(s2);
        reviewsRepository.saveAndFlush(r2);

    }

}
