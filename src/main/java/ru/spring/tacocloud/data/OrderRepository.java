package ru.spring.tacocloud.data;

import ru.spring.tacocloud.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
