import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Patient {
    String id;
    String fullName;
    int age;
    String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }
    @Override
    public String toString() {
        return "| ID : " + id + " | FullName : " + fullName + " | Age : " + age + " | Diagnosis : " + diagnosis + " |";
    }
}
public class Bai05 {

    static ArrayList<Patient> list = new ArrayList<Patient>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    showPatients();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("lựa chọn ko hợp lệ.");
            }

        } while (choice != 6);
    }

    static void showMenu() {
        System.out.println("=============MENU=============");
        System.out.println("1.Tiếp nhận bệnh nhân");
        System.out.println("2. cập nhật chuẩn đoán");
        System.out.println("3. xuất viện");
        System.out.println("4. sắp xếp danh sách bệnh nhân");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("6. Thoát");
        System.out.println("================================");
    }

    // chưc năng 1
    static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        // Kiểm tra trùng ID
        for (Patient p : list) {
            if (p.id.equals(id)) {
                System.out.println("ID đã tồn tại");
                return;
            }
        }

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        list.add(new Patient(id, name, age, diagnosis));
        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    // chức năng 2
    static void updateDiagnosis() {
        System.out.print("Nhập id bệnh nhân để cập nhật: ");
        String id = sc.nextLine();

        for (Patient p : list) {
            if (p.id.equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                p.diagnosis = sc.nextLine();
                System.out.println("chẩn đoán đã được cập nhật.");
                return;
            }
        }

        System.out.println("không tìm thấy bệnh nhân với id đã cho");
    }

    // chức năng 3
    static void dischargePatient() {
        System.out.print("Nhập id bệnh nhân để xuất viện: ");
        String id = sc.nextLine();

        for (Patient p : list) {
            if (p.id.equals(id)) {
                list.remove(p);
                System.out.println("Bệnh nhân đã xuất viện.");
                return;
            }
        }

        System.out.println("không tìm thấy bệnh nhân với id đã cho");
    }

    // chức năng 4
    static void sortPatients() {

        Collections.sort(list, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                // Sắp xếp tuổi giảm dần
                if (p2.age != p1.age) {
                    return p2.age - p1.age;
                }

                // Nếu tuổi bằng nhau -> tên A-Z
                return p1.fullName.compareToIgnoreCase(p2.fullName);
            }
        });

        System.out.println("Danh sách bệnh nhân đã được sắp xếp");
    }

    // chức năng 5
    static void showPatients() {
        if (list.isEmpty()) {
            System.out.println("danh sách rỗng .");
            return;
        }

        System.out.println("Danh sách bệnh nhân");
        for (Patient p : list) {
            System.out.println(p);
        }
    }
}