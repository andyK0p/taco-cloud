package ru.spring.tacocloud.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.spring.tacocloud.domain.Ingredient;
import ru.spring.tacocloud.domain.Taco;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Repository
public class JdbcTacoRepository implements TacoRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "INSERT INTO Taco (name, createdAt) VALUES (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                taco.getName(),
                                new Timestamp(taco.getCreatedAt().getTime())));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        return tacoId;
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbcTemplate.update(
                "INSERT INTO Taco_Ingredients (taco, ingredient) VALUES (?, ?)",
                tacoId, ingredient.getId());

    }
}
