package org.sample.mvc;

import org.sample.mvc.controller.Controller;
import org.sample.mvc.model.User;
import org.sample.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCreateController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserRepository.save(new User(request.getParameter("userId"), request.getParameter("name")));

        return "redirect:/users";
    }
}
