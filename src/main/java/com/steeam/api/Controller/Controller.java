package com.steeam.api.Controller;

import com.steeam.api.Domain.Customer;
import com.steeam.api.Domain.Order;
import com.steeam.api.Domain.Product;
import com.steeam.api.Service.CustomerService;
import com.steeam.api.Service.OrderService;
import com.steeam.api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @PostMapping("addProduct")
    public ResponseEntity<String> registerNewProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product saved");
    }
    @PostMapping("addOrder")
    public ResponseEntity<String> registerNewOrder (@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.ok("Order Saved");
    }
    @PostMapping("addCustomer")
    public ResponseEntity<String> registerNewCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Customer Added");
    }
    @PostMapping("/orders/{orderId}/products/{productId}")
    public void addProductToOrder(@RequestParam Long productId, @PathVariable Long orderId) {
        orderService.addProductToOrder(productId, orderId);
    }
}
