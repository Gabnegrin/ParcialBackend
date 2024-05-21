package parcial.demo.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parcial.demo.dtos.libroDTO;
import parcial.demo.entidades.libro;
import parcial.demo.repositorio.repolibro;

@Service
public class libroServicio {
    ModelMapper modelMapper;
    repolibro repolibro;

    @Autowired
    libroServicio(repolibro repolibro, ModelMapper modelMapper){
        this.repolibro = repolibro;
        this.modelMapper = modelMapper;
    }




    public libroDTO get(Long id){
        Optional<libro>libro_opt = repolibro.findById(id);
        libroDTO libroDTO = null;
        if(libro_opt.isPresent()){
            libro libro = libro_opt.get();
            libroDTO = modelMapper.map(libro, libroDTO.class);
        }
        return libroDTO;
    }

    public List<libroDTO> get(){
        List<libro> libros = (List<libro>) repolibro.findAll();
        List<libroDTO> libroDTOs = libros.stream()
                                                        .map(libro -> modelMapper.map(libro, libroDTO.class))
                                                        .collect(Collectors.toList());
        return libroDTOs;
    }
    
    @SuppressWarnings("null")
    public libroDTO save(libro libroe){
        libro libro = libroe;
        libro = repolibro.save(libroe);
        libroDTO libroDTO = modelMapper.map(libro, libroDTO.class);
        return libroDTO;
    }

    @SuppressWarnings("null")
    public libroDTO update(libro libroe){
        Optional<libro> libroOpt = repolibro.findById(libroe.getId());
    
        if (libroOpt.isPresent()) {
            libro libro = libroOpt.get();

            if(libroe.getAutor() != null){
                libro.setAutor(libroe.getAutor());
            }
            if(libroe.getEdicion() != null){
                libro.setEdicion(libroe.getEdicion());
            }
            if(libroe.getNombre() != null){
                libro.setNombre(libroe.getNombre());
            }
            if(libroe.getPrecio() != 0){
                libro.setPrecio(libroe.getPrecio());
            }
            if(libroe.getFama() != 0){
                libro.setFama(libroe.getFama());
            }
            if(libroe.getFe_escritura() != null){
                libro.setFe_escritura(libroe.getFe_escritura());
            }
            
            
            libro libroActualizado = repolibro.save(libro);
            libroDTO libroDTO = modelMapper.map(libroActualizado, libroDTO.class);
            return libroDTO;
        } else {
            return null;
        }
    }
    @SuppressWarnings("null")
    public void delete(Long id){
    Optional<libro> libro_opt = repolibro.findById(id);
    libro_opt.ifPresent(libro -> {
        libro.setEliminado(true);
        repolibro.save(libro);
    });
}
}
