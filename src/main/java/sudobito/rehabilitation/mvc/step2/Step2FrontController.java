package sudobito.rehabilitation.mvc.step2;

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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class Step2FrontController extends HttpServlet {
    private final Map<String, Step2InnerController> innerControllerMap = new HashMap<>();

    public Step2FrontController() {
        String pathPrefix ="/front-controller/v1";
        innerControllerMap.put(pathPrefix + "/members/new-form", new Step2NewFormController());
        innerControllerMap.put(pathPrefix + "/members/save", new Step2SaveController());
        innerControllerMap.put(pathPrefix + "/members", new Step2ListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        Step2InnerController calleeController = innerControllerMap.get(requestURI);
        if (Objects.isNull(calleeController)) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Step2MyView view = calleeController.process(request, response);
        view.render(request, response);
    }
}
