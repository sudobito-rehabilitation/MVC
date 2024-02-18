package sudobito.rehabilitation.mvc.step4.inner_controllers;

import jakarta.servlet.ServletException;
import sudobito.rehabilitation.mvc.step4.model.ModelView;

import java.io.IOException;
import java.util.Map;

public class Step4NewFormController implements Step4InnerController {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        return "new-form";
    }
}
