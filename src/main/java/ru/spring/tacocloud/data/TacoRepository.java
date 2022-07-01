package ru.spring.tacocloud.data;

import ru.spring.tacocloud.domain.Taco;

public interface TacoRepository {
    Taco save(Taco taco);
}
