import java.util.ArrayList;
import java.util.Scanner;

class Patient1 {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient1(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDisease() { return disease; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDisease(String disease) { this.disease = disease; }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Ten: " + name +
                " | Tuoi: " + age +
                " | Gioi tinh: " + gender +
                " | Benh ly: " + disease;
    }
}

class PatientManager1 {
    private ArrayList<Patient1> list = new ArrayList<>();

    // CREATE
    public void addPatient(Patient1 patient) {
        for (Patient1 p : list) {
            if (p.getId() == patient.getId()) {
                System.out.println("ID da ton tai!");
                return;
            }
        }
        list.add(patient);
        System.out.println("Them benh nhan thanh cong.");
    }

    // DELETE
    public void removePatient(int patientId) {
        for (Patient1 p : list) {
            if (p.getId() == patientId) {
                list.remove(p);
                System.out.println("Xoa benh nhan thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan.");
    }

    // UPDATE
    public void updatePatient(int patientId, String name, int age, String gender, String disease) {
        for (Patient1 p : list) {
            if (p.getId() == patientId) {
                p.setName(name);
                p.setAge(age);
                p.setGender(gender);
                p.setDisease(disease);
                System.out.println("Cap nhat thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan.");
    }

    // SEARCH
    public void searchPatientByName(String name) {
        boolean found = false;
        for (Patient1 p : list) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay benh nhan.");
        }
    }

    // DISPLAY
    public void displayPatients() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }
        for (Patient1 p : list) {
            System.out.println(p);
        }
    }
}

public class btth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientManager1 manager = new PatientManager1();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them benh nhan");
            System.out.println("2. Xoa benh nhan");
            System.out.println("3. Cap nhat benh nhan");
            System.out.println("4. Tim kiem theo ten");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhap ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ten: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap gioi tinh: ");
                    String gender = sc.nextLine();
                    System.out.print("Nhap benh ly: ");
                    String disease = sc.nextLine();
                    manager.addPatient(new Patient1(id, name, age, gender, disease));
                    break;

                case 2:
                    System.out.print("Nhap ID can xoa: ");
                    manager.removePatient(Integer.parseInt(sc.nextLine()));
                    break;

                case 3:
                    System.out.print("Nhap ID can cap nhat: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ten moi: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhap tuoi moi: ");
                    int newAge = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap gioi tinh moi: ");
                    String newGender = sc.nextLine();
                    System.out.print("Nhap benh ly moi: ");
                    String newDisease = sc.nextLine();
                    manager.updatePatient(updateId, newName, newAge, newGender, newDisease);
                    break;

                case 4:
                    System.out.print("Nhap ten can tim: ");
                    manager.searchPatientByName(sc.nextLine());
                    break;

                case 5:
                    manager.displayPatients();
                    break;

                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (choice != 6);
    }
}