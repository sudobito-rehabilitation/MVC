package sudobito.rehabilitation.mvc.step4.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelView {
    // 뷰의 이름
    private String viewName;

    // 뷰를 렌더링할 때 필요한 model 객체
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
