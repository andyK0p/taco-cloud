package ru.spring.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.tacocloud.domain.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
