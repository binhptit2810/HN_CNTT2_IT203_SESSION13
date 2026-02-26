import java.util.ArrayList;
import java.util.Iterator;

public class Bai01 {
    public static void main(String[] args) {

        // Tạo danh sách ban đầu
        ArrayList<Double> danhSach = new ArrayList<Double>();
        danhSach.add(36.5);
        danhSach.add(40.2);
        danhSach.add(37.0);
        danhSach.add(12.5);
        danhSach.add(39.8);
        danhSach.add(99.9);
        danhSach.add(36.8);

        // In danh sách ban đầu
        System.out.println("danh sách ban đầu : " + danhSach);

        // Dùng Iterator để xóa giá trị không hợp lệ
        Iterator<Double> it = danhSach.iterator();
        while (it.hasNext()) {
            Double nhietDo = it.next();
            if (nhietDo < 34.0 || nhietDo > 42.0) {
                it.remove();
            }
        }
        // In danh sách sau khi lọc
        System.out.println("danh sách sau khi lọc " + danhSach);

        // Tính nhiệt độ trung bình
        double tong = 0;
        for (Double nd : danhSach) {
            tong += nd;
        }

        double trungBinh = tong / danhSach.size();

        // In kết quả
        System.out.printf("Nhiệt độ trung bình : %.2f", trungBinh);
    }
}