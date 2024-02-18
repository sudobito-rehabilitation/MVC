package sudobito.rehabilitation.mvc.step4.inner_controllers;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public interface Step4InnerController {
    String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException;
}
