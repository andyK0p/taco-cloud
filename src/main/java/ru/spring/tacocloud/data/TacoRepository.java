package ru.spring.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.tacocloud.domain.Taco;
@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
