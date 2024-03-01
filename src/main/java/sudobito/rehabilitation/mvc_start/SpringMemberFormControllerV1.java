package sudobito.rehabilitation.mvc_start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 스프링이 자동으로 스프링 빈으로 등록
@Controller
public class SpringMemberFormControllerV1 {
    // 요청 정보를 매핑
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        return new ModelAndView("new-form");
    }
}
