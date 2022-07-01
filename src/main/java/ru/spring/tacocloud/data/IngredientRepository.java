package ru.spring.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.spring.tacocloud.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
