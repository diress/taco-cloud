package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;

import sia.tacocloud.domain.Order;

public interface OrderRepository
        extends CrudRepository<Order, Long> {

}
