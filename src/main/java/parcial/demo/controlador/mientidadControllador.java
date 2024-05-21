package parcial.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parcial.demo.dtos.libroDTO;
import parcial.demo.entidades.libro;
import parcial.demo.servicios.libroServicio;

@RestController
@RequestMapping(value = "/libro")
public class mientidadControllador {
    libroServicio libroServicio;
    
    @Autowired
    mientidadControllador(libroServicio libroServicio){
        this.libroServicio = libroServicio;
    };

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public libroDTO get(@PathVariable Long id){
        return libroServicio.get(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<libroDTO> get(){
        return libroServicio.get();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public libroDTO save(@RequestBody libro libroe){
        return libroServicio.save(libroe);
    }
    @CrossOrigin(origins = "*")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public libroDTO update(@RequestBody libro libroe){
        return libroServicio.update(libroe);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        libroServicio.delete(id);
    }
}
