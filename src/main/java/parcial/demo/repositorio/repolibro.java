package parcial.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import parcial.demo.entidades.libro;

@Repository
public interface repolibro extends CrudRepository<libro, Long>{

}
