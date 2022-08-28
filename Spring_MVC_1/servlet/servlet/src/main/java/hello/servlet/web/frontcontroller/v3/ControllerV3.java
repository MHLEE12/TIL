package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    // servlet에 종속적이지 않는다.
    ModelView process(Map<String, String> paramMap);
}
