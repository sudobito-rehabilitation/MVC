package sudobito.rehabilitation.mvc.step5.adapters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step3.inner_controllers.Step3InnerController;
import sudobito.rehabilitation.mvc.step5.model.ModelView;

import java.util.HashMap;
import java.util.Map;

public class Step5ControllerV3HandlerAdapter implements Step5MyHandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Step3InnerController);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Step3InnerController controller = (Step3InnerController) handler;
        Map<String, String> paramMap = createParamMap(request);
//        ModelView modelView = controller.process(paramMap);
//        return modelView;
        return null;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}
