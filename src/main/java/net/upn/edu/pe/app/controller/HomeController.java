package net.upn.edu.pe.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;

import net.upn.edu.pe.app.model.Paciente;
import net.upn.edu.pe.app.model.Consulta;
import net.upn.edu.pe.app.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.Utiles;

@Controller
public class HomeController {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String irHome() {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mostrarPrincipal(Model model) {

        List<String> peliculas = new LinkedList<>();
        peliculas.add("El Padrino");
        peliculas.add("Batman");
        peliculas.add("Avengers");
        peliculas.add("Forrest Gump");

        model.addAttribute("Vpeliculas",peliculas);
        return "home";
    }

    @RequestMapping(value = "/pacientes", method = RequestMethod.GET)
    public String mostrarPacientes(Model model){
        List<Paciente> pacientes = getPacientes();
        List<String> listaFechas = Utiles.getNextDays(4);

        model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
        model.addAttribute("Vpacientes", pacientes);
        model.addAttribute("fechas",listaFechas);

        return "pacientesView";
    }

    public List<Paciente> getPacientes(){
        try {
            List<Consulta> historial = new LinkedList<>();
            historial.add(new Consulta(new Date(),"Dolor estómago", "Gastritis", "No tiene"));

            List<Paciente> listaPacientes = new LinkedList<>();
            listaPacientes.add(new Paciente("76867868", "Reusche Sáenz", "Eduardo Julio", 19, true, "Soltero", 78.4f, 176, "Jr. Independencia 961", new Date(), historial));

            return listaPacientes;
        }
        catch (Exception ex){
            return null;
        }
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String buscar(@RequestParam("fecha") String fecha, Model model){
        List<String> listaFechas = Utiles.getNextDays(4);
        List<Paciente> pacientes = getPacientes();

        model.addAttribute("fechas", listaFechas);
        model.addAttribute("fechaBusqueda", fecha);
        model.addAttribute("Vpacientes", pacientes);
        return "pacientesView";
    }

    @RequestMapping(value = "/detalle", method = RequestMethod.GET)
    public String mostrarDetalle(Model model, @RequestParam("dni") String _dni, @RequestParam("fecha") String _fecha){

        model.addAttribute("nombre","Eduardo Reusche Sáenz");
        model.addAttribute("edad","20");
        model.addAttribute("estatura",175);
        model.addAttribute("dni",_dni);
        model.addAttribute("fecha",_fecha);

        return "detalle";
    }
}
