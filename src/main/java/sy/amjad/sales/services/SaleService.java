package sy.amjad.sales.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sy.amjad.sales.domain.Product;
import sy.amjad.sales.domain.Sale;
import sy.amjad.sales.domain.SaleTransaction;
import sy.amjad.sales.dtos.SaleWithTransactionDto;
import sy.amjad.sales.dtos.TransactionDto;
import sy.amjad.sales.exceptions.ResourceNotFoundException;
import sy.amjad.sales.repositories.IProductRepository;
import sy.amjad.sales.repositories.ISaleRepository;
import sy.amjad.sales.repositories.ITransactionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SaleService implements ISaleService<Sale, UUID> {
    private static final Logger logger = LoggerFactory.getLogger(SaleService.class);
    ISaleRepository repository;
    ITransactionRepository transactionRepository;
    IProductRepository productRepository;

    @Autowired
    public SaleService(ISaleRepository repository, ITransactionRepository transactionRepository, IProductRepository productRepository) {
        this.repository = repository;
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
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

    @Override
    public Sale addSaleWithTransaction(SaleWithTransactionDto entity) {
        logger.info(this.getClass().getName() +": " + entity);
        UUID saleId = entity.getId();
        boolean saleExists = repository.existsById(saleId);
        if (!saleExists)
            throw new ResourceNotFoundException("No such sale operation to add too");
        for (TransactionDto dto : entity.getTransactions()) {
            Optional<Product> product = productRepository.findById(dto.getProductId());
            if (product.isEmpty())
                throw new ResourceNotFoundException("No such product: " + dto.getProductId());

            SaleTransaction t = new SaleTransaction();
            t.setProduct(product.get());
            t.setQuantity(dto.getQuantity());
            t.setTotal(dto.getQuantity() * product.get().getPrice());
            transactionRepository.save(t);
        }
        return null;
    }
}
