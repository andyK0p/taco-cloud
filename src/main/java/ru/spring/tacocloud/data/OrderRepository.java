package ru.spring.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.tacocloud.domain.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByDeliveryZip(String deliveryZip);
    List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
    List<Order> findByDeliveryNameIgnoreCaseAndDeliveryCityIgnoreCase(String deliveryZip, String deliveryCity);
    List<Order> findByDeliveryCityOrderByDeliveryName(String city);
}
