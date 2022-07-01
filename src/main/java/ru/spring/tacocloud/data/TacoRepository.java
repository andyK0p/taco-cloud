package ru.spring.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.spring.tacocloud.domain.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
