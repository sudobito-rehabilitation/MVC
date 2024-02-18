package sudobito.rehabilitation.mvc.step5.inner_controllers;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class Step5SaveController implements Step5Handler {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Object member = new Object();
        // memberRepo.save();

        model.put("member", member);
        return "save-result";
    }
}
