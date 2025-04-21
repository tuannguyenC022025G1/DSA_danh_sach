public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Constructor mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor với dung lượng ban đầu
    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }

    // Thêm phần tử tại vị trí index
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            ensureCapacity(size + 1);
        }
        // Dịch chuyển các phần tử từ index trở đi sang phải
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    // Xóa phần tử tại vị trí index
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) elements[index];
        // Dịch chuyển các phần tử sang trái để điền vào vị trí bị xóa
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    // Trả về kích thước của danh sách
    public int size() {
        return size;
    }

    // Sao chép danh sách
    @SuppressWarnings("unchecked")
    public E clone() {
        try {
            MyList<E> clonedList = (MyList<E>) super.clone();
            clonedList.elements = new Object[elements.length];
            for (int i = 0; i < size; i++) {
                clonedList.elements[i] = this.elements[i];
            }
            return (E) clonedList;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    // Kiểm tra xem danh sách có chứa phần tử o không
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (elements[i] == null) return true;
            } else {
                if (o.equals(elements[i])) return true;
            }
        }
        return false;
    }

    // Tìm vị trí đầu tiên của phần tử o
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o == null) {
                if (elements[i] == null) return i;
            } else {
                if (o.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(size + 1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    // Đảm bảo dung lượng tối thiểu của danh sách
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    // Lấy phần tử tại vị trí i
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return (E) elements[i];
    }

    // Xóa toàn bộ danh sách
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}