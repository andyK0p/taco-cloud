package ru.spring.tacocloud.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.spring.tacocloud.domain.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findOne(String id) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
