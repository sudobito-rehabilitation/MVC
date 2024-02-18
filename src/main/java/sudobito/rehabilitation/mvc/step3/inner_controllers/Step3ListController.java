package sudobito.rehabilitation.mvc.step3.inner_controllers;

import jakarta.servlet.ServletException;
import sudobito.rehabilitation.mvc.step3.model.ModelView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Step3ListController implements Step3InnerController {
    @Override
    public ModelView process(Map<String, String> param) throws ServletException, IOException {
        List<Object> members = new ArrayList<>();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
