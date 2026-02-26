import java.util.LinkedList;

public class Bai04 {

    // Class quản lý phòng cấp cứu
    static class EmergencyRoom {
        private LinkedList<String> waitingList = new LinkedList<String>();
        // Bệnh nhân thường -> thêm cuối hàng
        public void patientCheckIn(String name) {
            waitingList.addLast("NORMAL-" + name);
        }
        // Ca nguy kịch -> thêm đầu hàng
        public void emergencyCheckIn(String name) {
            waitingList.addFirst("EMERGENCY-" + name);
        }

        // Gọi bệnh nhân đầu tiên
        public void treatPatient() {
            if (waitingList.isEmpty()) {
                System.out.println("không còn bệnh nhân nào");
                return;
            }

            String patient = waitingList.removeFirst();

            if (patient.startsWith("EMERGENCY-")) {
                System.out.println("đang cấp cứu: "
                        + patient.replace("EMERGENCY-", ""));
            } else {
                System.out.println("đang khám: "
                        + patient.replace("NORMAL-", ""));
            }
        }
    }

    public static void main(String[] args) {

        EmergencyRoom er = new EmergencyRoom();
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");
        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}