package arkis.SweetsList.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

    @RequestMapping("/")
    public ModelAndView home(ModelAndView mav){
        mav.setViewName("/common/home");
        return mav;
    }
}
