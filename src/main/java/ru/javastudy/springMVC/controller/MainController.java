package ru.javastudy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;


@Controller
public class MainController {

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*
    So che if work my version
    */

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "myView";
    }


    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user",method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getName().equals("") && user.getPassword().equals("")) {
            modelAndView.setViewName("error");
        } else if (user.getName().equals("BeNdEr") && user.getPassword().equals("09707")) {
            modelAndView.setViewName("admin");
        } else {
            modelAndView.setViewName("secondPage");
        }

        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}
