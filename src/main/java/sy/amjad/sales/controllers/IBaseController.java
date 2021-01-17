package sy.amjad.sales.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface IBaseController<T> {

    @GetMapping
    List<T> get();

    @PutMapping
    T update(T entity);

    @PostMapping
    T add(T entity);
}
