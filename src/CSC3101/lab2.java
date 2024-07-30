package CSC3101;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:2

public class lab2 {
    public static void main(String[] args) {
        //q1
        Order order1=new Order(1);
        Order order2=new Order(2);
        Customer cust1=new Customer(1,"zhangsan",order1);
        Customer cust2=new Customer(2,"lisi",order2);
        //q2
        Order order3=new Order(1,cust1);
        Order order4=new Order(2,cust2);
        //q3
        cust1.setId(100);
        cust2.setId(200);
        cust1.setName("wangwu");
        cust2.setName("zhaoliu");
        order3.setOrderNo(3);
        order4.setOrderNo(4);
        //q4
        System.out.println("Customer 1->name:"+cust1.getName()+" id:"+cust1.getId()+" order id:"+cust1.getOrder().getOrderNo());
        System.out.println("Customer 2->name:"+cust2.getName()+" id:"+cust2.getId()+" order id:"+cust2.getOrder().getOrderNo());

        System.out.println("Order 3->id:"+order3.getOrderNo()+"  Order Owner name:"+order3.getCust().getName()+"  Order Owner id:"+order3.getCust().getId());
        System.out.println("Order 4->id:"+order4.getOrderNo()+"  Order Owner name:"+order4.getCust().getName()+"  Order Owner id:"+order4.getCust().getId());
    }
}

class Customer {
    private int id;
    private String name;
    private Order order;

    public Customer(int id, String name, Order order) {
        this.id = id;
        this.name = name;
        this.order = order;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

}

class Order {
    private int orderNo;
    private Customer cust;

    public Order(int orderNo) {
        this.orderNo = orderNo;
    }

    public Order(int orderNo, Customer cust) {
        this.orderNo = orderNo;
        this.cust = cust;
    }

    public Order() {
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Customer getCust() {
        return cust;
    }

}
