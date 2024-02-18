package sudobito.rehabilitation.mvc.step3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step2.inner_controllers.Step2InnerController;
import sudobito.rehabilitation.mvc.step2.inner_controllers.Step2ListController;
import sudobito.rehabilitation.mvc.step2.inner_controllers.Step2NewFormController;
import sudobito.rehabilitation.mvc.step2.inner_controllers.Step2SaveController;
import sudobito.rehabilitation.mvc.step2.model.Step2MyView;
import sudobito.rehabilitation.mvc.step3.inner_controllers.Step3InnerController;
import sudobito.rehabilitation.mvc.step3.inner_controllers.Step3ListController;
import sudobito.rehabilitation.mvc.step3.inner_controllers.Step3NewFormController;
import sudobito.rehabilitation.mvc.step3.inner_controllers.Step3SaveController;
import sudobito.rehabilitation.mvc.step3.model.ModelView;
import sudobito.rehabilitation.mvc.step3.model.Step3MyView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class Step3FrontController extends HttpServlet {
    private final Map<String, Step3InnerController> innerControllerMap = new HashMap<>();

    public Step3FrontController() {
        String pathPrefix ="/front-controller/v3";
        innerControllerMap.put(pathPrefix + "/members/new-form", new Step3NewFormController());
        innerControllerMap.put(pathPrefix + "/members/save", new Step3SaveController());
        innerControllerMap.put(pathPrefix + "/members", new Step3ListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        Step3InnerController calleeController = innerControllerMap.get(requestURI);
        if (Objects.isNull(calleeController)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        ModelView modelView = calleeController.process(paramMap);
        
        String viewName = modelView.getViewName();
        Step3MyView myView = viewResolver(viewName);
        // 뷰 객체를 통해서 HTML 화면을 렌더링 한다
        myView.render(modelView.getModel(), request, response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName
                        -> paramMap.put(paramName, request.getParameter(paramName))
                );

        return paramMap;
    }

    // 컨트롤러가 반환한 논리 뷰 이름을 실제 물리 뷰 경로로 변경
    // 이후 실제 물리 경로가 있는 MyView 객체를 반환
    private Step3MyView viewResolver(String viewName) {
        return new Step3MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
