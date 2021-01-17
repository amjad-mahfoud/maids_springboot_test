package sy.amjad.sales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sy.amjad.sales.domain.Product;
import sy.amjad.sales.repositories.IProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService implements IProductService<Product, UUID> {

    IProductRepository repository;

    @Autowired
    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> get() {
        return repository.findAll();
    }

    @Override
    public Product update(Product entity) {
        return repository.save(entity);
    }

    @Override
    public Product add(Product entity) {
        return repository.save(entity);
    }
}
