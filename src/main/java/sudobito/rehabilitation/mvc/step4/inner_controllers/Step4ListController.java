package sudobito.rehabilitation.mvc.step4.inner_controllers;

import jakarta.servlet.ServletException;
import sudobito.rehabilitation.mvc.step4.model.ModelView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Step4ListController implements Step4InnerController {
    @Override
    public String process(Map<String, String> param, Map<String, Object> model) throws ServletException, IOException {
        List<Object> members = new ArrayList<>();

        model.put("members", members);
        return "members";
    }
}
