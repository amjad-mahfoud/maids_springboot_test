package sy.amjad.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sy.amjad.sales.domain.Client;
import sy.amjad.sales.repositories.IClientRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ClientService implements IClientService<Client, UUID>{

    IClientRepository repository;

    @Autowired
    public ClientService(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> get() {
        return repository.findAll();
    }

    @Override
    public Client update(Client entity) {
        return repository.save(entity);
    }

    @Override
    public Client add(Client entity) {
        return repository.save(entity);
    }
}
