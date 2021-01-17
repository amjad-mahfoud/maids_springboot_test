package sy.amjad.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sy.amjad.sales.domain.Product;
import sy.amjad.sales.services.IProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController implements IBaseController<Product> {

    private final IProductService<Product, UUID> service;

    @Autowired
    public ProductController(IProductService<Product, UUID> service) {
        this.service = service;
    }

    @Override
//    @GetMapping
    public List<Product> get() {
        return service.get();
    }

    @Override
//    @PutMapping
    public Product update(@RequestBody Product entity) {
        return service.update(entity);
    }

    @Override
//    @PostMapping
    public Product add(@RequestBody Product entity){
        return service.add(entity);
    }
}
