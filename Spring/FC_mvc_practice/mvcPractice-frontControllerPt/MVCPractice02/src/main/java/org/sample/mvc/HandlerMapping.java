package org.sample.mvc;

import org.sample.mvc.controller.Controller;

public interface HandlerMapping {

    Object findHandler(HandlerKey handlerKey);
}
