package gt.edu.umg.ingenieria.sistemas.laboratorio1.dao;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Nullable
    Client findClientByNit(@Nullable String nit);

    @Query("select c from Client c where firstName=?1")
    Client findByName(String nombre);
    
    @Query("select c from Client c where lastName=?1")
    Client findByLastName(String apellido);
}
