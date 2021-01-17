package sy.amjad.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sy.amjad.sales.domain.Client;

import java.util.UUID;

@Repository
public interface IClientRepository extends JpaRepository<Client, UUID> {

}
