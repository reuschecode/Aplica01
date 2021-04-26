package net.upn.edu.pe.app.controller;

import net.upn.edu.pe.app.dao.UsuarioDAO;
import net.upn.edu.pe.app.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginRegisterController {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarLogeo(Model model){

        return "login";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String procesarLogin(Model model, @ModelAttribute("email") String email, @ModelAttribute("password") String password){
        Usuario usuario = usuarioDAO.validateUsuario(email,password);

        if(usuario != null){
            model.addAttribute("nombres", usuario.getNombres());
            model.addAttribute("apellidos", usuario.getApellidos());
            return "includes/home";
        }
        else{
            model.addAttribute("mensaje", "Nombre de usuario o contraseña invalidos, porfavor intentar nuevamente.");
            return "login";
        }
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String irHome(Model model){

        return "includes/home";
    }
}
