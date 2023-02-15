package br.com.alura.mudi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaCOntroller {
    @GetMapping
    public String getFormularioParaOferta(){
        return "oferta/home";
    }
}
