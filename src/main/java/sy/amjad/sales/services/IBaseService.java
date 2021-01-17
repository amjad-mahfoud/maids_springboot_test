package sy.amjad.sales.services;

import java.util.List;

public interface IBaseService<T, ID> {

    List<T> get();

    T update(T entity);

    T add(T entity);
}
