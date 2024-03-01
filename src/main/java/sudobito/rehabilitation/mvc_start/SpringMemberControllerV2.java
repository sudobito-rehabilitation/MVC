package sudobito.rehabilitation.mvc_start;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 클래스 단위 -> 메서드 단위
 * @RequestMapping 클래스 레벨과 메서드 레벨 조합
 */
@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    @RequestMapping("/new-form")
    public ModelAndView newForm(){
        return null;
    }

    @RequestMapping("save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
