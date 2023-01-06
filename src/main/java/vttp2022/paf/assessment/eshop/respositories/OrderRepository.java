package vttp2022.paf.assessment.eshop.respositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.OrderStatus;

@Repository
// public class OrderRepository {
// 	// TODO: Task 3
// }

public class OrderRepository {

	private JdbcTemplate jdbcTemplate;
    
	public int updateListOfOrderedItems(Long orderId, List<String> listOfOrderedItems) {
        // updating sql list
        String sql = "UPDATE customers SET list_of_ordered_items = ? WHERE order_id = ?";
		// set the values in SQL for placeholders
        Object[] params = {listOfOrderedItems, orderId};
        // Execute the SQL UPDATE statement and return the number of rows affected
        return jdbcTemplate.update(sql, params);
    }

	//temp
	public int dispatchOrder(Long orderId) {
		return 0;
	}
	
	// public void updateOrderStatus(long orderId, OrderStatus status) {
	// 	String sql = "INSERT INTO order_status (order_id, delivery_id, status, status_update) VALUES (?, ?, ?, ?)";
	// 	jdbcTemplate.update(sql, orderId, status.getDeliveryId(), status.getStatus(), status.getStatusupdate());
	// }
}
