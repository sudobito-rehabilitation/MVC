package sudobito.rehabilitation.mvc.step2.inner_controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sudobito.rehabilitation.mvc.step2.model.Step2MyView;

import java.io.IOException;

public interface Step2InnerController {
    Step2MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
