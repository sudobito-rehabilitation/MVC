package sudobito.rehabilitation.mvc.step3.inner_controllers;

import jakarta.servlet.ServletException;
import sudobito.rehabilitation.mvc.step3.model.ModelView;

import java.io.IOException;
import java.util.Map;

public class Step3SaveController implements Step3InnerController {
    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Object member = new Object();
        // memberRepo.save();
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
