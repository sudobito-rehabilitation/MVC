package sudobito.rehabilitation.mvc.step2.inner_controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step2.model.Step2MyView;

import java.io.IOException;

public class Step2SaveController implements Step2InnerController {
    @Override
    public Step2MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object member = new Object();
        request.setAttribute("member", member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        return new Step2MyView(viewPath);
    }
}
