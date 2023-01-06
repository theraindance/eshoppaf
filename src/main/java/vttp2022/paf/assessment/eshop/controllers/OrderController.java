package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

// public class OrderController {

// 	//TODO: Task 3

// }

@RestController
@RequestMapping("/customers")
public class OrderController {
    
	@Autowired
    private CustomerRepository customerRepository;

//     @GetMapping("/{name}")
//     public ResponseEntity<?> findCustomerByName(@PathVariable String name) {
//         Customer customer = customerRepository.findCustomerByName(name);
//         if (customer == null) {
//             return new ResponseEntity<>("Customer " + name + " not found", HttpStatus.NOT_FOUND);
//         }
//         return new ResponseEntity<>(customer, HttpStatus.OK);
//     }
// }

@GetMapping("/{name}")
public ResponseEntity<?> findCustomerByName(@PathVariable String name) {
    Customer customer = customerRepository.findCustomerByName(name);
    if (customer == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"user" + name + "not available\"}");
    }
    return ResponseEntity.ok(customer);
}

@PutMapping("/orders/{orderId}")
public ResponseEntity<String> updateListOfOrderedItems(@PathVariable Long orderId, @RequestBody List<String> listOfOrderedItems) {
    OrderRepository orderRepository = new OrderRepository();  // Create an instance of the OrderRepository class
    try {
        // save the list of ordered items in the database
        int rowsAffected = orderRepository.updateListOfOrderedItems(orderId, listOfOrderedItems);

        // If the save was successful, return a success status code and the number of rows affected
        return ResponseEntity.ok().body(String.valueOf(rowsAffected));
    } catch (Exception e) {
        // If the save failed, return an internal server error status code and a JSON payload with an error message
        String error = "{\"error\":\"Internal Server failure\"}";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

@PostMapping("/dispatch/{orderId}")
public ResponseEntity<String> dispatchOrder(@PathVariable Long orderId) {

    OrderRepository orderRepository = new OrderRepository();  // Create an instance of the OrderRepository class

	try {
        // Dispatch the order to the warehouse
        int rowsAffected = orderRepository.dispatchOrder(orderId);


        // If the dispatch was successful, return a success status code and details of order
		// fail to make it work
		String message = 
			// "{\"order_id\": \" " + Order.getOrderId() + 
			// "\", \"name\": \" " + Order.getName() + 
			// "\", \"address\": \" " + Order.getAddress() + 
			// "\", \"email\": \" " + Order.getEmail() + 
			// "\", \"items\": \" " + Order.getLineItems() + 
			"\", \"message\": \"createdBy: Chua Kok Hin\"}";

        return ResponseEntity.ok().body(String.valueOf(rowsAffected));
    } 
	
	catch (Exception e) {
        // If the dispatch failed, return an internal server error status code and a JSON payload with an error message
        String error = "{\"error\":\"Server failure\"}";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

}







