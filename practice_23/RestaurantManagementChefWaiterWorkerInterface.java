public class RestaurantManagementChefWaiterWorkerInterface {

    interface Worker {
        void performDuties();
    }

    static class Person {
        String name;
        int id;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String toString() {
            return "Person{name='" + name + "', id=" + id + "}";
        }
    }

    static class Chef extends Person implements Worker {
        Chef(String name, int id) {
            super(name, id);
        }

        public void performDuties() {
            System.out.print(name + " is cooking special dishes.");
        }
    }

    static class Waiter extends Person implements Worker {
        Waiter(String name, int id) {
            super(name, id);
        }

        public void performDuties() {
            System.out.print(name + " is taking orders and serving food.");
        }
    }

    public static void main(String[] args) {
        Worker w1 = new Chef("Chef Arun", 1);
        Worker w2 = new Waiter("Waiter Nisha", 2);

        w1.performDuties();
        System.out.print("\n---\n");
        w2.performDuties();
    }
}

