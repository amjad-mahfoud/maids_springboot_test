package sy.amjad.sales.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sy.amjad.sales.domain.Client;
import sy.amjad.sales.services.IClientService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController implements IBaseController<Client> {

    private final IClientService<Client, UUID> service;
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    public ClientController(IClientService<Client, UUID> service) {
        this.service = service;
    }

    @Override
//    @GetMapping
    public List<Client> get() {
        logger.info("this is a info message from client controller");
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
