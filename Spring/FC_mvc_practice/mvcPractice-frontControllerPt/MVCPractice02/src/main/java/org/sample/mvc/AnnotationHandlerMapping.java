package org.sample.mvc;

import org.example.mvc.AnnotationHandler;
import org.reflections.Reflections;
import org.sample.mvc.annotation.Controller;
import org.sample.mvc.annotation.RequestMapping;
import org.sample.mvc.controller.RequestMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationHandlerMapping implements HandlerMapping {

    private final Object[] basePackage;
    private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<HandlerKey, org.example.mvc.AnnotationHandler>();

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    @Override
    public Object findHandler(HandlerKey handlerKey) {
        return handlers.get(handlerKey);
    }

    public void initialize() {
        Reflections reflections = new Reflections(basePackage);

        Set<Class<?>> clazzWithContollerAnnotation = reflections.getTypesAnnotatedWith(Controller.class);

        clazzWithContollerAnnotation.forEach(clazz ->
                Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
                    RequestMapping requestMapping = declaredMethod.getDeclaredAnnotation(RequestMapping.class);

                    Arrays.stream(getRequestMethods(requestMapping))
                            .forEach(requestMethod -> handlers.put(
                                    new HandlerKey(requestMethod, requestMapping.value()), new org.example.mvc.AnnotationHandler(clazz, declaredMethod)
                            ));
                })
        );
    }

    private RequestMethod[] getRequestMethods(RequestMapping requestMapping) {
        return requestMapping.method();
    }
}
