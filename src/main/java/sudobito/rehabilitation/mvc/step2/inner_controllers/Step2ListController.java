package sudobito.rehabilitation.mvc.step2.inner_controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step2.model.Step2MyView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Step2ListController implements Step2InnerController {
    @Override
    public Step2MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Object> members = new ArrayList<>();
        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/views/members.jsp";
        return new Step2MyView(viewPath);
    }
}
