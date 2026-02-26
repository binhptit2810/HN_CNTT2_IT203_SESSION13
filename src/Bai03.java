import java.util.ArrayList;
import java.util.List;

public class Bai03 {
    // Phương thức Generic tìm phần tử chung
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> ketQua = new ArrayList<T>();
        for (T phanTu : listA) {
            if (listB.contains(phanTu) && !ketQua.contains(phanTu)) {
                ketQua.add(phanTu);
            }
        }
        return ketQua;
    }
    public static void main(String[] args) {

        //Test Case 1
        List<Integer> khoaNoi1 = new ArrayList<Integer>();
        khoaNoi1.add(101);
        khoaNoi1.add(102);
        khoaNoi1.add(105);

        List<Integer> khoaNgoai1 = new ArrayList<Integer>();
        khoaNgoai1.add(102);
        khoaNgoai1.add(105);
        khoaNgoai1.add(108);

        List<Integer> ketQua1 = findCommonPatients(khoaNoi1, khoaNgoai1);
        System.out.println("Test Case 1 Output: " + ketQua1);


        //Test Case 2
        List<String> khoaNoi2 = new ArrayList<String>();
        khoaNoi2.add("DN01");
        khoaNoi2.add("DN02");
        khoaNoi2.add("DN03");

        List<String> khoaNgoai2 = new ArrayList<String>();
        khoaNgoai2.add("DN02");
        khoaNgoai2.add("DN04");

        List<String> ketQua2 = findCommonPatients(khoaNoi2, khoaNgoai2);
        System.out.println("Test Case 2 Output: " + ketQua2);
    }
}