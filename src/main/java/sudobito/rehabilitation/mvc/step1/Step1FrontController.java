package sudobito.rehabilitation.mvc.step1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step1.inner_controllers.Step1InnerController;
import sudobito.rehabilitation.mvc.step1.inner_controllers.Step1ListController;
import sudobito.rehabilitation.mvc.step1.inner_controllers.Step1NewFormController;
import sudobito.rehabilitation.mvc.step1.inner_controllers.Step1SaveController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class Step1FrontController extends HttpServlet {
    private final Map<String, Step1InnerController> innerControllerMap = new HashMap<>();

    public Step1FrontController() {
        String pathPrefix ="/front-controller/v1";
        innerControllerMap.put(pathPrefix + "/members/new-form", new Step1NewFormController());
        innerControllerMap.put(pathPrefix + "/members/save", new Step1SaveController());
        innerControllerMap.put(pathPrefix + "/members", new Step1ListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        Step1InnerController calleeController = innerControllerMap.get(requestURI);
        if (Objects.isNull(calleeController)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        calleeController.process(request, response);
    }
}
