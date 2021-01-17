package sy.amjad.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sy.amjad.sales.domain.Client;
import sy.amjad.sales.services.IClientService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController implements IBaseController<Client> {

    private final IClientService<Client, UUID> service;

    @Autowired
    public ClientController(IClientService<Client, UUID> service) {
        this.service = service;
    }

    @Override
//    @GetMapping
    public List<Client> get() {
        return service.get();
    }

    @Override
//    @PutMapping
    public Client update(@RequestBody Client entity) {
        return service.update(entity);
    }

    @Override
//    @PostMapping
    public Client add(@RequestBody Client entity) {
        return service.add(entity);
    }
}
