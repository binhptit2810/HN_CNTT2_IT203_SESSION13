import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai02 {

    public static List<String> xuLyDanhMucThuoc(List<String> danhSachNhap) {
        ArrayList<String> danhSachKhongTrung = new ArrayList<String>();
        // Lọc trùng
        for (String thuoc : danhSachNhap) {
            if (!danhSachKhongTrung.contains(thuoc)) {
                danhSachKhongTrung.add(thuoc);
            }
        }
        // Sắp xếp A-Z
        Collections.sort(danhSachKhongTrung);

        return danhSachKhongTrung;
    }

    public static void main(String[] args) {
        ArrayList<String> danhSachNhap = new ArrayList<String>();
        danhSachNhap.add("Paracetamol");
        danhSachNhap.add("Ibuprofen");
        danhSachNhap.add("Panadol");
        danhSachNhap.add("Paracetamol");
        danhSachNhap.add("Aspirin");
        danhSachNhap.add("Ibuprofen");

        System.out.println("Input: " + danhSachNhap);

        List<String> ketQua = xuLyDanhMucThuoc(danhSachNhap);

        System.out.println("Output: " + ketQua);
    }
}