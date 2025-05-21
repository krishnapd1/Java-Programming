
class Grades {
    private int subject1, subject2, subject3;
    private int total;
    private double avg;
    private String grade;

    public Grades(int subject1, int subject2, int subject3) {
        if (subject1 < 0 || subject1 > 100 || subject2 < 0 || subject2 > 100 || subject3 < 0 || subject3 > 100) {
            throw new IllegalArgumentException("Invalid Marks! Must be between 0 and 100.");
        }
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        calculateTotal();
        calculateAverage();
        assignGrade();
    }

    private void calculateTotal() {
        total = subject1 + subject2 + subject3;
    }

    private void calculateAverage() {
        avg = total / 3.0;
    }

    private void assignGrade() {
        if (subject1 < 35 || subject2 < 35 || subject3 < 35 || avg < 50) {
            grade = "Fail";
        } else if (avg >= 70) {
            grade = "A";
        } else if (avg >= 60) {
            grade = "B";
        } else {
            grade = "C";
        }
    }

    public void display() {
        System.out.println("\nMarks: " + subject1 + ", " + subject2 + ", " + subject3);
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
    }
}

// OrderDetails Class
class OrderDetails {
    private int orderId;
    private String orderName;
    private int orderQty;
    private double orderPrice;
    private double discount;
    private double totalPrice;
    private final double originalTotalPrice;

    public OrderDetails(int orderId, String orderName, int orderQty, double orderPrice) {
        if (orderQty <= 0 || orderPrice <= 0) {
            throw new IllegalArgumentException("Quantity and Price must be greater than 0.");
        }
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;
        this.originalTotalPrice = orderQty * orderPrice;
        this.totalPrice = originalTotalPrice;
    }

    public void applyDiscount() {
        discount = originalTotalPrice * 0.05;
        totalPrice = originalTotalPrice - discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void display() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Order Name: " + orderName);
        System.out.println("Order Quantity: " + orderQty);
        System.out.println("Order Price per unit: " + orderPrice);
        System.out.println("Total Price before discount: " + originalTotalPrice);
        System.out.println("Discount: " + discount);
        System.out.println("Total Price after discount: " + totalPrice);
    }
}

// Main Class
public class MainApp {
    public static void main(String[] args) {
        try {
            System.out.println("------ Student Grades ------");
            Grades student1 = new Grades(85, 75, 90);
            student1.display();

            Grades student2 = new Grades(40, 60, 55);
            student2.display();

            System.out.println("\n------ Order Details ------");
            OrderDetails order1 = new OrderDetails(101, "Laptop", 2, 50000);
            OrderDetails order2 = new OrderDetails(102, "Smartphone", 3, 30000);

            order1.applyDiscount();
            order2.applyDiscount();

            order1.display();
            order2.display();

            System.out.println("\n------ Order with Higher Price ------");
            if (order1.getTotalPrice() > order2.getTotalPrice()) {
                order1.display();
            } else {
                order2.display();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}