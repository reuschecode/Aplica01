package net.upn.edu.pe.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
    @GetMapping(value = "/create")
    public String create(){

        return "noticias/formNoticia";
    }
}
