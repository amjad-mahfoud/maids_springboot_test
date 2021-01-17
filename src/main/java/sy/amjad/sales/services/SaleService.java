package sy.amjad.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sy.amjad.sales.domain.Sale;
import sy.amjad.sales.repositories.ISaleRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SaleService implements ISaleService<Sale, UUID> {

    ISaleRepository repository;

    @Autowired
    public SaleService(ISaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sale> get() {
        return repository.findAll();
    }

    @Override
    public Sale update(Sale entity) {
        return repository.save(entity);
    }

    @Override
    public Sale add(Sale entity) {
        return repository.save(entity);
    }
}
