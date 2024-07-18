package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Invoice {

    private Long id;

    private List<Order> orderList;

    public Invoice(long id, List<Order> orderList) {
        this.id=id;
        this.orderList=orderList;
    }

    public double calculateInvoice(){

             return orderList.stream()
                     .flatMap(order -> order.getProductList().stream())
                     .mapToDouble(Product::getPrice)
                     .sum();

    }

    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", orderList=" + orderList +
                '}';
    }
}
