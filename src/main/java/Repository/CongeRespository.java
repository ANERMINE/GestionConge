package Repository;

import Entities.Conge;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CongeRespository extends JpaRepository<Conge, Long> {
}
