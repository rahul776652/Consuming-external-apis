package com.steeam.api.Service;
//
//import com.steeam.api.Domain.Customer;
//import com.steeam.api.Domain.Order;
//import com.steeam.api.Domain.Product;
//import com.steeam.api.Repository.CustomerRepository;
//import com.steeam.api.Repository.OrderRepository;
//import com.steeam.api.Repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import java.time.LocalDate;
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//@org.springframework.stereotype.Service
//public class Service {
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private ProductRepository productRepository;
//
//
//
//    public void addCustomer(Customer customer){
//        customerRepository.save(customer);
//    }
//
//    public void addProduct(Product product){
//        productRepository.save(product);
//    }
//    public void addOrder(Order order){
//        orderRepository.save(order);
//    }
//
//
//    List<Product> result = productRepository.findAll()
//            .stream()
//            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//            .filter(p -> p.getPrice() > 100)
//            .collect(Collectors.toList());
//
//
//    List<Order> results = orderRepository.findAll()
//            .stream()
//            .filter(o -> o.getProducts()
//                    .stream()
//                    .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
//            .collect(Collectors.toList());
//
//
////    List<Product> list = productRepository.findAll()
////            .stream()
////            .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
////            .map(p -> p.withPrice(p.getPrice() * 0.9))
////            .collect(Collectors.toList());
//
////    List<Product> list1 = orderRepository.findAll()
////            .stream()
////            .filter(o -> o.getCustomer().getTier() == 2)
////            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
////            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) >= 0)
////            .filter(o -> o.getProducts().stream())
////            .distinct()
////            .collect(Collectors.toList());
//
//    Optional<Product> products = productRepository.findAll()
//            .stream()
//            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//            .sorted(Comparator.comparing(Product::getPrice))
//            .findFirst();
//
//    Optional<Product> product = productRepository.findAll()
//            .stream()
//            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//            .min(Comparator.comparing(Product::getPrice));
//
//    List<Order> result1 = orderRepository.findAll()
//            .stream()
//            .sorted(Comparator.comparing(Order::getOrderDate).reversed())
//            .limit(3)
//            .collect(Collectors.toList());
//
//    List<Product> result2 = orderRepository.findAll()
//            .stream()
//            .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
//            .peek(o -> System.out.println(o.toString()))
//            .flatMap(o -> o.getProducts().stream())
//            .distinct()
//            .collect(Collectors.toList());
//
//    Double result3 = orderRepository.findAll()
//            .stream()
//            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
//            .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
//            .flatMap(o -> o.getProducts().stream())
//            .mapToDouble(p -> p.getPrice())
//            .sum();
//
//
//    Double result4 = orderRepository.findAll()
//            .stream()
//            .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
//            .flatMap(o -> o.getProducts().stream())
//            .mapToDouble(p -> p.getPrice())
//            .average().getAsDouble();
//
////    DoubleSummaryStatistics statistics = productRepository.findAll()
////            .stream()
////            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
////            .mapToDouble(p -> p.getPrice())
////            .summaryStatistics();
////
////    String output = String.format("count = %d, average = %f, max = %f, min = %f, sum = %f",
////            statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum());
////    System.out.println(output);
//
//
//    Map<Long, Integer> result5 = orderRepository.findAll()
//            .stream()
//            .collect(
//                    Collectors.toMap(
//                            order -> order.getId(),
//                            order -> order.getProducts().size()
//                    )
//            );
//
//
//    Map<Customer, List<Order>> result6 = orderRepository.findAll()
//            .stream()
//            .collect(
//                    Collectors.groupingBy(Order::getCustomer)
//            );
//
//    Map<Order, Double> result7 = orderRepository.findAll()
//            .stream()
//            .collect(
//                    Collectors.toMap(
//                            Function.identity(),
//                            order -> order.getProducts().stream()
//                                    .mapToDouble(p -> p.getPrice()).sum()
//                    )
//            );
//
//
//    Map<String, List<String>> result8 = productRepository.findAll()
//            .stream()
//            .collect(
//                    Collectors.groupingBy(
//                            Product::getCategory,
//                            Collectors.mapping(product -> product.getName(), Collectors.toList()))
//            );
//
////    Map<String, Optional<Product>> result9 = productRepository.findAll()
////            .stream()
////            .collect(
////                    Collectors.groupingBy(
////                            Product::getCategory,
////                            Collectors.maxBy(Comparator.comparing(Product::getPrice)));
//
//}
