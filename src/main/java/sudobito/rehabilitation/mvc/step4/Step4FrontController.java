package sudobito.rehabilitation.mvc.step4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4InnerController;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4ListController;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4NewFormController;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4SaveController;
import sudobito.rehabilitation.mvc.step4.model.ModelView;
import sudobito.rehabilitation.mvc.step4.model.Step4MyView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class Step4FrontController extends HttpServlet {
    private final Map<String, Step4InnerController> innerControllerMap = new HashMap<>();

    public Step4FrontController() {
        String pathPrefix ="/front-controller/v3";
        innerControllerMap.put(pathPrefix + "/members/new-form", new Step4NewFormController());
        innerControllerMap.put(pathPrefix + "/members/save", new Step4SaveController());
        innerControllerMap.put(pathPrefix + "/members", new Step4ListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        Step4InnerController calleeController = innerControllerMap.get(requestURI);
        if (Objects.isNull(calleeController)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = calleeController.process(paramMap, model);

        Step4MyView myView = viewResolver(viewName);

        myView.render(model, request, response);
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
    private Step4MyView viewResolver(String viewName) {
        return new Step4MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
