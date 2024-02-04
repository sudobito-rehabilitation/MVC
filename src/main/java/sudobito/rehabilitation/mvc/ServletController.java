package sudobito.rehabilitation.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ServletController {
    void process(HttpServletRequest request, HttpServletResponse response);
}
