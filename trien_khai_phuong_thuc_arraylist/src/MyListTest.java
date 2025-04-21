public class MyListTest {
    public static void main(String args[]) {
        MyList<Integer> list = new MyList<>();

        // Thêm phần tử
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List after adding elements: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Thêm phần tử tại vị trí cụ thể
        list.add(1, 4);
        System.out.println("List after adding 4 at index 1: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Xóa phần tử
        list.remove(2);
        System.out.println("List after removing element at index 2: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Kiểm tra chứa phần tử
        System.out.println("List contains 2: " + list.contains(2));
        System.out.println("List contains 5: " + list.contains(5));

        // Tìm vị trí phần tử
        System.out.println("Index of 4: " + list.indexOf(4));

        // Xóa danh sách
        list.clear();
        System.out.println("List size after clear: " + list.size());
    }
}