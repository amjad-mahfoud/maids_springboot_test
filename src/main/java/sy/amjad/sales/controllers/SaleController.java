package sy.amjad.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sy.amjad.sales.domain.Sale;
import sy.amjad.sales.dtos.SaleWithTransactionDto;
import sy.amjad.sales.services.ISaleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/sales")
public class SaleController implements IBaseController<Sale> {

    private final ISaleService<Sale, UUID> service;

    @Autowired
    public SaleController(ISaleService<Sale, UUID>  service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<Sale> get() {
        return service.get();
    }

    @Override
    @PutMapping
    public Sale update(@RequestBody Sale entity) {
        return service.update(entity);
    }

    @Override
    @PostMapping
    public Sale add(@RequestBody Sale entity){
        return service.add(entity);
    }

    @PostMapping(path = "add_sale_with_transaction")
    public Sale addSaleWithMultipleTransactions(@RequestBody SaleWithTransactionDto entity){
        return service.addSaleWithTransaction(entity);
    }
}
