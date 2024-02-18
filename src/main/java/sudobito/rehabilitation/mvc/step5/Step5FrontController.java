package sudobito.rehabilitation.mvc.step5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.ObjectUtils;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4ListController;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4NewFormController;
import sudobito.rehabilitation.mvc.step4.inner_controllers.Step4SaveController;
import sudobito.rehabilitation.mvc.step5.adapters.Step5ControllerV3HandlerAdapter;
import sudobito.rehabilitation.mvc.step5.adapters.Step5MyHandlerAdapter;
import sudobito.rehabilitation.mvc.step5.inner_controllers.Step5Handler;
import sudobito.rehabilitation.mvc.step5.inner_controllers.Step5ListController;
import sudobito.rehabilitation.mvc.step5.inner_controllers.Step5NewFormController;
import sudobito.rehabilitation.mvc.step5.inner_controllers.Step5SaveController;
import sudobito.rehabilitation.mvc.step5.model.ModelView;
import sudobito.rehabilitation.mvc.step5.model.Step5MyView;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class Step5FrontController extends HttpServlet {
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<Step5MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public Step5FrontController() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    public void initHandlerMappingMap() {
        String pathPrefix ="/front-controller/v3";
        handlerMappingMap.put(pathPrefix + "/members/new-form", new Step5NewFormController());
        handlerMappingMap.put(pathPrefix + "/members/save", new Step5SaveController());
        handlerMappingMap.put(pathPrefix + "/members", new Step5ListController());

        //V4 추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new
                Step4NewFormController());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new
                Step4SaveController());
        handlerMappingMap.put("/front-controller/v5/v4/members", new
                Step4ListController());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new Step5ControllerV3HandlerAdapter());
//        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);
        if (ObjectUtils.isEmpty(handler)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Step5MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView modelView = adapter.handle(request, response, handler);

        Step5MyView view = viewResolver(modelView.getViewName());
        view.render(modelView.getModel(), request, response);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private Step5MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (Step5MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
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
    private Step5MyView viewResolver(String viewName) {
        return new Step5MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
