package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     *
     * @param paramMap
     * @param model
     * @return viewName
     */

    // front controller에서 텅텅빈 model을 만들어서 보내주는데 controller는 값을 넣기만 하면 되고
    // String인 viewName만 반환하면 된다
    String process(Map<String, String > paramMap, Map<String, Object> model);
}
