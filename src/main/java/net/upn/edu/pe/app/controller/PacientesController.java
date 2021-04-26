package net.upn.edu.pe.app.controller;

import net.upn.edu.pe.app.dao.PacienteDao;
import net.upn.edu.pe.app.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import util.Utiles;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/pacientes")
@Controller
public class PacientesController {
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Autowired
    private PacienteDao pacienteDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPacientes(Model model) throws SQLException {
        List<Paciente> pacientes = pacienteDao.findAll();
        List<String> listaFechas = Utiles.getNextDays(4);

        model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
        model.addAttribute("Vpacientes", pacientes);
        model.addAttribute("fechas",listaFechas);

        return "pacientes/pacientesView";
    }

    @RequestMapping(value = "/detalle", method = RequestMethod.GET)
    public String mostrarDetalle(Model model, @RequestParam("dni") final String _dni, @RequestParam("fecha") String _fecha){

        Paciente pac = pacienteDao.findByDni(_dni);

        model.addAttribute("paciente",pac);
        model.addAttribute("fecha",_fecha);

        return "pacientes/pacienteDatos";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String buscar(@RequestParam("fecha") String fecha, Model model){
        List<String> listaFechas = Utiles.getNextDays(4);

        model.addAttribute("fechas", listaFechas);
        model.addAttribute("fechaBusqueda", fecha);
        //model.addAttribute("Vpacientes", listaPacientes);
        return "pacientes/pacientesView";
    }

    @RequestMapping(value = "/agregar",method = RequestMethod.GET)
    public ModelAndView agregarVista(ModelAndView model){
        model.addObject("paciente",new Paciente());
        model.setViewName("pacientes/pacientesAgregar");
        return model;
    }

    @RequestMapping(value = "/agregarPaciente",method = RequestMethod.POST)
    public String agregarPaciente(Model model, Paciente paciente){
        pacienteDao.insert(paciente);
        
        return "redirect:/pacientes/";
    }

    @RequestMapping(value = "/editar",method = RequestMethod.GET)
    public ModelAndView editarVista(ModelAndView model, @RequestParam("dni") String dni){
        Paciente pac = pacienteDao.findByDni(dni);

        model.addObject("paciente",pac);
        model.addObject("pacienteEditado",new Paciente());
        model.setViewName("pacientes/pacientesEditar");
        return model;
    }

    @RequestMapping(value = "/editarPaciente",method = RequestMethod.POST)
    public String editarPaciente(Model model, Paciente pacienteEditado){
        pacienteDao.update(pacienteEditado);

        return "redirect:/pacientes/";
    }

    @RequestMapping(value = "/eliminarPaciente",method = RequestMethod.GET)
    public String eliminarPaciente(Model model, @RequestParam("dni") String dni){
        pacienteDao.delete(dni);

        return "redirect:/pacientes/";
    }
}
