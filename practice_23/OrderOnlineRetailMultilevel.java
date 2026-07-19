public class OrderOnlineRetailMultilevel {

    static class Order {
        int orderId;
        String orderDate;

        Order(int orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        String getOrderStatus() {
            return "Order placed";
        }

        public String toString() {
            return "Order{orderId=" + orderId + ", orderDate='" + orderDate + "'}";
        }
    }

    static class ShippedOrder extends Order {
        String trackingNumber;

        ShippedOrder(int orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        String getOrderStatus() {
            return "Shipped";
        }

        public String toString() {
            return "ShippedOrder{orderId=" + orderId + ", orderDate='" + orderDate + "', trackingNumber='" + trackingNumber + "'}";
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        String getOrderStatus() {
            return "Delivered";
        }

        public String toString() {
            return "DeliveredOrder{orderId=" + orderId + ", orderDate='" + orderDate + "', trackingNumber='" + trackingNumber + "', deliveryDate='" + deliveryDate + "'}";
        }
    }

    public static void main(String[] args) {
        Order o = new Order(101, "2026-01-10");
        ShippedOrder so = new ShippedOrder(102, "2026-01-11", "TR-778");
        DeliveredOrder d = new DeliveredOrder(103, "2026-01-12", "TR-779", "2026-01-15");

        System.out.println(o.getOrderStatus());
        System.out.println(so.getOrderStatus());
        System.out.println(d.getOrderStatus());
    }
}

