package sudobito.rehabilitation.mvc.step5.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step5.model.ModelView;

public interface Step5MyHandlerAdapter {
    boolean supports(Object handler);

    // 실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 ModelView를 직접 생성해서라도 반환해야
    // 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler);
}
