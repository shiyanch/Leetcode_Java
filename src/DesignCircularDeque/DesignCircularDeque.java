package DesignCircularDeque;

public class DesignCircularDeque {
    int[] array;
    int size;
    int front;
    int rear;
    public DesignCircularDeque(int k) {
        array = new int[k];
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            rear++;
        }
        array[front] = value;
        front = front == 0 ? array.length - 1 : front - 1;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = array.length - 1;
        }
        array[rear] = value;
        rear = rear == array.length - 1 ? 0 : rear + 1;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            front = front == array.length - 1 ? 0 : front + 1;
            size--;
            updateIfEmpty();
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            rear = rear == 0 ? array.length - 1 : rear - 1;
            size--;
            updateIfEmpty();
            return true;
        } else {
            return false;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        int index = front == array.length - 1 ? 0 : front + 1;
        return array[index];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = rear == 0 ? array.length - 1 : rear - 1;
        return array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void updateIfEmpty() {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
    }

    public static void main(String[] args) {
        DesignCircularDeque circularDeque = new DesignCircularDeque(5);
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.insertLast(0));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
    }
}
