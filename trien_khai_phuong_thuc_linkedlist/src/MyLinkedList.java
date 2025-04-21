class Node {
    Node next;
    Object data;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }
}

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    // Constructor mặc định
    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    // Thêm phần tử tại vị trí index
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == numNodes) {
            addLast(element);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(element);
        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }

    // Thêm phần tử vào đầu danh sách
    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    // Thêm phần tử vào cuối danh sách
    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        numNodes++;
    }

    // Xóa phần tử tại vị trí index
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node removedNode = temp.next;
        temp.next = removedNode.next;
        numNodes--;
        return (E) removedNode.getData();
    }

    // Xóa phần tử e nếu tồn tại
    public boolean remove(Object e) {
        if (head == null) return false;
        if (head.getData().equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.getData().equals(e)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            numNodes--;
            return true;
        }
        return false;
    }

    // Trả về kích thước của danh sách
    public int size() {
        return numNodes;
    }

    // Sao chép danh sách
    @SuppressWarnings("unchecked")
    public E clone() {
        MyLinkedList<E> clonedList = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            clonedList.addLast((E) temp.getData());
            temp = temp.next;
        }
        return (E) clonedList;
    }

    // Kiểm tra xem danh sách có chứa phần tử o không
    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if (o == null) {
                if (temp.getData() == null) return true;
            } else {
                if (o.equals(temp.getData())) return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Tìm vị trí đầu tiên của phần tử o
    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (o == null) {
                if (temp.getData() == null) return index;
            } else {
                if (o.equals(temp.getData())) return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // Đảm bảo dung lượng tối thiểu (không cần thiết cho LinkedList, nhưng để đầy đủ phương thức)
    public void ensureCapacity(int minCapacity) {
        // LinkedList không cần cơ chế mở rộng dung lượng như ArrayList
    }

    // Lấy phần tử tại vị trí i
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + numNodes);
        }
        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    // Lấy phần tử đầu tiên
    @SuppressWarnings("unchecked")
    public E getFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return (E) head.getData();
    }

    // Lấy phần tử cuối cùng
    @SuppressWarnings("unchecked")
    public E getLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    // Xóa toàn bộ danh sách
    public void clear() {
        head = null;
        numNodes = 0;
    }
}