package sudobito.rehabilitation.mvc.step1.inner_controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Step1InnerController {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
