package sudobito.rehabilitation.mvc_structure.handlermapping_handleradapter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// /springmvc/old-controller 라는 이름의 스프링 빈으로 등록
// 빈의 이름으로 URL 매핑할 것
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("ColdController.handleRequest");
        // return null -- 과거
        // - View 조회할 수 있도록 변경
        return new ModelAndView("new-form");
    }
}
