package net.upn.edu.pe.app.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;

import net.upn.edu.pe.app.model.Antecedente;
import net.upn.edu.pe.app.model.Paciente;
import net.upn.edu.pe.app.model.Consulta;
import net.upn.edu.pe.app.model.Persona;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.Utiles;

import javax.sql.DataSource;
import javax.sql.rowset.Predicate;

@Controller
public class HomeController {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    List<Paciente> listaPacientes = new LinkedList<>();

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
            List<Antecedente> antecedentes1 = new LinkedList<Antecedente>();
            List<Consulta> historial1 = new LinkedList<Consulta>();
            List<Antecedente> antecedentes2 = new LinkedList<Antecedente>();
            List<Consulta> historial2 = new LinkedList<Consulta>();
            antecedentes1.add(new Antecedente(new Date(), "Enfermedad grave con Amígdalas", "Operación (Retiración de Amígdalas)", "Sin amígdalas", 1));
            antecedentes1.add(new Antecedente(new Date(), "Chequeo oncológico", "Citología de tejído de estomacal", "Cáncer de estómago", 2));
            antecedentes2.add(new Antecedente(new Date(), "Chequeo oncológico", "Citología de tejído de estomacal", "Cáncer de estómago", 3));
            historial1.add(new Consulta(new Date(), "Dolor de estómago", "Gastrítis", "Ninguno", 79.4, 189, 1));
            historial2.add(new Consulta(new Date(), "Malestar general", "Gripe", "Alergia", 69.4, 168, 2));
            historial2.add(new Consulta(new Date(), "Dolor de estómago", "Gastrítis", "Ninguno", 66.4, 168, 3));
            Paciente edu = new Paciente("76867868", "Reusche Sáenz", "Eduardo Julio", 19, true, "Soltero", 78.4, 176, "Jr. Independencia 961", new Date(), "1", antecedentes1, historial1);
            Paciente luis = new Paciente("45645665", "Gonzales Ramirez", "José Alonso", 25, true, "Casado", 65.8, 168, "Av. España 1564", new Date(), "2", antecedentes2, historial2);

            listaPacientes.add(edu);
            listaPacientes.add(luis);

            return listaPacientes;
        }
        catch (Exception ex){
            return null;
        }
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String buscar(@RequestParam("fecha") String fecha, Model model){
        List<String> listaFechas = Utiles.getNextDays(4);

        model.addAttribute("fechas", listaFechas);
        model.addAttribute("fechaBusqueda", fecha);
        model.addAttribute("Vpacientes", listaPacientes);
        return "pacientesView";
    }

    @RequestMapping(value = "/detalle", method = RequestMethod.GET)
    public String mostrarDetalle(Model model, @RequestParam("dni") final String _dni, @RequestParam("fecha") String _fecha){
        Paciente pac = null;
        for (Paciente paciente: listaPacientes) {
            if(paciente.getDni().equals(_dni)) pac = paciente;
        }
        
        model.addAttribute("nombre",pac.getApellidos() +", "+ pac.getNombres());
        model.addAttribute("edad",pac.getEdad());
        model.addAttribute("sexo",pac.isSexo() ? "Hombre" : "Mujer");
        model.addAttribute("estadoCivil", pac.getEstadoCivil());
        model.addAttribute("peso",pac.getPeso());
        model.addAttribute("talla",pac.getTalla());
        model.addAttribute("fechaNacimiento",pac.getFechaNacimiento());
        model.addAttribute("direccion",pac.getDireccion());
        model.addAttribute("dni",pac.getDni());
        model.addAttribute("historial",pac.getHistorialClinico());
        model.addAttribute("antecedentes",pac.getAntecedentesClinicos());
        model.addAttribute("fecha",_fecha);

        return "pacienteDatos";
    }
}
