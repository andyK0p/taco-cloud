package ru.spring.tacocloud.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.spring.tacocloud.domain.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    public List<Order> findByDeliveryZip(String deliveryZip);
    public List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
    public List<Order> findByDeliveryNameAndDeliveryCityAllIgnoresCase(String deliveryZip, String deliveryCity);
    public List<Order> findByDeliveryCityOrderByDeliveryName(String city);
}
