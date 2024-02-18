package sudobito.rehabilitation.mvc.step3.inner_controllers;

import jakarta.servlet.ServletException;
import sudobito.rehabilitation.mvc.step3.model.ModelView;

import java.io.IOException;
import java.util.Map;

public class Step3NewFormController implements Step3InnerController {
    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        return new ModelView("/WEB-INF/views/new-form.jsp");
    }
}
