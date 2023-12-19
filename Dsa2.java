public class Dsa2 {

    public static void main(String[] args) {
        LinkedList<Integer> x = new LinkedList<>();
        x.add(10);
        x.add(20);
        x.add(50);
        x.add(30);
        x.add(40);

        System.out.println(x); // [10, 20, 50, 30, 40]

        int m = x.max();
        System.out.println(m); // 50

        x.delete(50);
        System.out.println(x); // [10, 20, 30, 40]

        x.delete(10);
        System.out.println(x); // [20, 30, 40]

        x.addBeg(15);
        System.out.println(x); // [15, 20, 30, 40]

        x.addBeg(5);
        System.out.println(x); // [5, 15, 20, 30, 40]

        int n = x.count();
        System.out.println("No. of Nodes: " + n); // 5

        x.insertAt(25, 4);
        System.out.println(x); // [5, 15, 20, 25, 30, 40]

        x.insertAt(2, 1);
        System.out.println(x); // [2, 5, 15, 20, 25, 30, 40]

        x.deleteAt(3);
        System.out.println(x); // [2, 5, 20, 25, 30, 40]

        x.deleteAt(1);
        System.out.println(x); // [5, 20, 25, 30, 40]

        x.insertOrder(27);
        System.out.println(x);

    }
}

class LinkedList<T extends Comparable<T>> {

    Node<T> first;

    void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (first == null) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    int max() {
        if (first == null) {
            return Integer.MIN_VALUE; 
        }

        int max = (Integer) first.getData();
        Node<T> current = first.getNext();

        while (current != null) {
            int currentData = (Integer) current.getData();
            if (currentData > max) {
                max = currentData;
            }
            current = current.getNext();
        }

        return max;
    }

    void delete(T value) {
        if (first == null) {
            return;
        }

        if (first.getData().equals(value)) {
            first = first.getNext();
            return;
        }

        Node<T> current = first;
        while (current.getNext() != null && !current.getNext().getData().equals(value)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    void addBeg(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(first);
        first = newNode;
    }

    int count() {
        int count = 0;
        Node<T> current = first;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    void insertAt(T data, int position) {
        if (position < 1 || position > count() + 1) {
            return;
        }

        Node<T> newNode = new Node<>(data);

        if (position == 1) {
            newNode.setNext(first);
            first = newNode;
            return;
        }

        Node<T> current = first;
        for (int i = 1; i < position - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    void deleteAt(int position) {
        if (position < 1 || position > count()) {
            return;
        }

        if (position == 1) {
            first = first.getNext();
            return;
        }

        Node<T> current = first;
        for (int i = 1; i < position - 1; i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
    }

    void insertOrder(T data) {
        Node<T> newNode = new Node<>(data);

        if (first == null || data.compareTo(first.getData()) < 0) {
            newNode.setNext(first);
            first = newNode;
            return;
        }

        Node<T> current = first;

        while (current.getNext() != null && data.compareTo(current.getNext().getData()) > 0) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public String toString() {
        String result = "[";
        Node<T> current = first;

        while (current != null) {
            result += current.getData();
            if (current.getNext() != null) {
                result += ", ";
            }
            current = current.getNext();
        }

        result += "]";
        return result;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }

    void setNext(Node<T> nextNode) {
        next = nextNode;
    }

    Node<T> getNext() {
        return next;
    }

    T getData() {
        return data;
    }
}

