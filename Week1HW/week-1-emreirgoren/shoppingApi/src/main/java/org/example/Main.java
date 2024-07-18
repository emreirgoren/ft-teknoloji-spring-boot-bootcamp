package org.example;

import model.Customer;
import model.Invoice;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        /**
         * Müşteriler
         */
        Customer customer1 = new Customer("Emre", "Irgoren", 20);
        Customer customer2 = new Customer("Yunus", "Irgoren", 21);
        Customer customer3 = new Customer("Mustafa", "Irgoren", 22);
        Customer customer4 = new Customer("Cem", "Dirman", 23);
        Customer customer5 = new Customer("Cem", "Java1", 24);
        Customer customer6 = new Customer("Cem", "Java2", 26);
        Customer customer7 = new Customer("Cem", "Java3", 27);
        Customer customer8 = new Customer("Patika", "Dev", 28);


        /**
         * Sistemdeki müşteri Listesi
         */
        List<Customer> customerList = new ArrayList<>();

        /**
         * Müşterilerin Listeye eklenmesi
         */
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);
        customerList.add(customer7);
        customerList.add(customer8);

        /**
         * Ürünler
         */
        Product product1 = new Product("Elma", "Meyve", 4.99, 3000L);
        Product product2 = new Product("Armut", "Meyve", 5.99, 4000L);
        Product product3 = new Product("Portakal", "Meyve", 6.99, 5000L);
        Product product4 = new Product("Gold", "Metal",3000,10L);

        /**
         * Sipariş Listeleri
         */

        /**
         * Emre Sipariş Listesi
         */
        List<Product> productList1 = new ArrayList<>();
        productList1.add(product1);
        productList1.add(product2);

        /**
         *Yunus Sipariş Listesi
         */
        List<Product> productList2 = new ArrayList<>();
        productList2.add(product2);
        productList2.add(product3);

        /**
         * Cem Dirman Sipariş Listesi
         */

        List<Product> productList4 = new ArrayList<>();
        productList4.add(product1);
        productList4.add(product2);

        /**
         * Cem Java1 Sipariş Listesi
         */

        List<Product> productList5 = new ArrayList<>();
        productList5.add(product1);
        productList5.add(product2);
        productList5.add(product3);

        /**
         * Cem Java2 Sipariş Listesi
         */

        List<Product> productList6 = new ArrayList<>();
        productList6.add(product1);

        /**
         * Cem Java3 Sipariş Listesi
         */

        List<Product> productList7 = new ArrayList<>();
        productList7.add(product2);

        /**
         * Patika Dev Sipariş Listesi
         */

        List<Product> productList8 = new ArrayList<>();
        productList8.add(product4);

        /**
         * Siparişlerin Oluşturulması
         */

        Order order1 = new Order(1, customer1, productList1);
        Order order2 = new Order(2, customer2, productList2);
        Order order4 = new Order(4, customer4, productList4);
        Order order5 = new Order(5, customer5, productList5);
        Order order6 = new Order(6, customer6, productList6);
        Order order7 = new Order(7, customer7, productList7);
        Order order8 = new Order(8, customer8, productList8);

        /**
         * Sipariş Listeleri Ornekleri
         */
        List<Order> orderList1 = new ArrayList<>();
        orderList1.add(order1);
        orderList1.add(order2);

        /**
         * Price 1500 Buyuk olan birden fazla sipariş
         */
        List<Order> orderList2 = new ArrayList<>();
        orderList2.add(order8);
        orderList2.add(order7);

        /**
         * Price 1500 buyuk olan birden fazla sipariş
         */
        List<Order> orderList3 = new ArrayList<>();
        orderList3.add(order8);
        orderList3.add(order7);
        orderList3.add(order6);

        /**
         * Faturaların Oluşturulması
         */

        Invoice invoice1 = new Invoice(1L, orderList1);
        Invoice invoice2 = new Invoice(2L, orderList2);
        Invoice invoice3 = new Invoice(3L,orderList3);


        /**
         * Faturaların Listelenmesi
         */

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);

        /**
         * Bütün siparişlerin listesi
         */

        List<Order> allOrderList = new ArrayList<>();
        allOrderList.add(order1);
        allOrderList.add(order2);
        allOrderList.add(order4);
        allOrderList.add(order5);
        allOrderList.add(order6);
        allOrderList.add(order7);
        allOrderList.add(order8);

        /**
         *  • Sistemdeki bütün müşterisi sayısını bulan
         */

        long customerSize = customerList.stream()
                .count();

        System.out.println("Müşteri Sayısı: " + customerSize);


        /**
         *  • İsmi Cem olan müşterilerin aldıkları ürün sayısını bulan
         */

        long customerNameCem = allOrderList.stream()
                .filter(order -> order.getCustomer().getName().equals("Cem")) // order4 ve order5 listeleri
                .flatMap(order -> order.getProductList().stream())
                .count();
        System.out.println(customerNameCem);
        


        /**
         *  • İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını
         *    hesaplayın
         */
/*
        List<Product> totalPrice = allOrderList.stream()
                .filter(order -> order.getCustomer().getName().equals("Cem") &&
                        order.getCustomer().getAge() < 30 &&
                        order.getCustomer().getAge() > 25)

                .flatMap(order -> order.getProductList().stream())
                .collect(Collectors.toList());
*/

        double productsTotalPriceByCem = allOrderList.stream()
                .filter(order -> order.getCustomer().getName().equals("Cem") &&
                        order.getCustomer().getAge() < 30 &&
                        order.getCustomer().getAge() > 25)
                .flatMap(order -> order.getProductList().stream())
                .mapToDouble(Product::getPrice).sum();


        System.out.println(productsTotalPriceByCem);


        /**
         *  • Sistemdeki 1500 TL üzerindeki faturaları listeleyin
         */

        List<Invoice> invoiceOver1500List = new ArrayList<>();


        invoiceOver1500List = invoiceList.stream()
                .filter(invoice -> invoice.calculateInvoice() > 1500 )
                .collect(Collectors.toList());

        invoiceOver1500List.forEach(System.out::println);

        /**
         * Test Amaçlı
         */
        double invoiceOver1500Size = invoiceList.stream()
                .filter(invoice -> invoice.calculateInvoice() > 1500 )
                .collect(Collectors.toList()).stream().count();
        System.out.println(invoiceOver1500Size);

    }


}