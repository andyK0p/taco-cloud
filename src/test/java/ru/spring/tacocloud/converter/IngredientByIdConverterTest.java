package ru.spring.tacocloud.converter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.spring.tacocloud.data.IngredientRepository;
import ru.spring.tacocloud.data.JdbcIngredientRepository;
import ru.spring.tacocloud.domain.Ingredient;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IngredientByIdConverterTest {
    public static final String WRONG_INGREDIENT_ID = "SOME WRONG ID";
    IngredientByIdConverter converter;
    IngredientRepository mockRepo = Mockito.mock(JdbcIngredientRepository.class);


    @Before
    public void setUp() {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
        Mockito.when(mockRepo.findAll()).thenReturn(ingredients);
        converter = new IngredientByIdConverter(mockRepo);
    }

    @Test
    public void convertIngredientById_success() {
        Ingredient actual = this.getIngredientConvertedById("SLSA");
        assertEquals("Salsa", actual.getName());
        assertEquals("SAUCE", actual.getType().name());

        actual = this.getIngredientConvertedById("CHED");
        assertEquals("Cheddar", actual.getName());
        assertEquals("CHEESE", actual.getType().name());
    }

    @Test
    public void convertIngredientById_failed() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> this.getIngredientConvertedById(WRONG_INGREDIENT_ID));

        String expectedMessage = "Ingredient with id '" + WRONG_INGREDIENT_ID + "' not found!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    private Ingredient getIngredientConvertedById(String id) {
        return converter.convert(id);
    }
}