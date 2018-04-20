package com.rayes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KnightController {


    @RequestMapping(value = "/knight", method = RequestMethod.GET)
    public ModelAndView knight() {
        return new ModelAndView("knight");
    }
}
