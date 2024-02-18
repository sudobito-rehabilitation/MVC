package sudobito.rehabilitation.mvc.step3.inner_controllers;

import jakarta.servlet.ServletException;
import sudobito.rehabilitation.mvc.step3.model.ModelView;

import java.io.IOException;
import java.util.Map;

public interface Step3InnerController {
    ModelView process(Map<String, String> paramMap) throws ServletException, IOException;
}
