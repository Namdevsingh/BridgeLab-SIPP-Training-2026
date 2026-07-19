public class PacketBufferCircularQueueArray {

    static class PacketBuffer {
        private int[] data;
        private int front;
        private int count;

        PacketBuffer(int capacity) {
            data = new int[capacity];
            front = 0;
            count = 0;
        }

        boolean enqueue(int packetId) {
            if (count == data.length) return false;
            int idx = (front + count) % data.length;
            data[idx] = packetId;
            count++;
            return true;
        }

        int dequeue() {
            if (count == 0) throw new RuntimeException("Buffer empty");
            int val = data[front];
            front = (front + 1) % data.length;
            count--;
            return val;
        }
    }

    public static void main(String[] args) {
        PacketBuffer buffer = new PacketBuffer(5);
        buffer.enqueue(101);
        buffer.enqueue(102);
        buffer.enqueue(103);

        System.out.print(buffer.dequeue() + " ");
        System.out.print(buffer.dequeue() + " ");
        System.out.print(buffer.dequeue());
    }
}

