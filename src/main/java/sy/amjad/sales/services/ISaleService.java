package sy.amjad.sales.services;

import sy.amjad.sales.dtos.SaleWithTransactionDto;

public interface ISaleService<T, ID> extends IBaseService<T, ID> {
    T addSaleWithTransaction(SaleWithTransactionDto entity);
}
