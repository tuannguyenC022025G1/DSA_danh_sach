public class MyLinkedListTest {
    public static void main(String args[]) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Thêm phần tử
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("List after adding elements: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Thêm phần tử vào đầu
        list.addFirst(0);
        System.out.println("List after adding 0 at the beginning: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Thêm phần tử tại vị trí cụ thể
        list.add(2, 4);
        System.out.println("List after adding 4 at index 2: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Xóa phần tử tại vị trí
        list.remove(1);
        System.out.println("List after removing element at index 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Xóa phần tử cụ thể
        list.remove(Integer.valueOf(3));
        System.out.println("List after removing element 3: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Kiểm tra chứa phần tử
        System.out.println("List contains 2: " + list.contains(2));
        System.out.println("List contains 5: " + list.contains(5));

        // Tìm vị trí phần tử
        System.out.println("Index of 4: " + list.indexOf(4));

        // Lấy phần tử đầu và cuối
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Xóa danh sách
        list.clear();
        System.out.println("List size after clear: " + list.size());
    }
}