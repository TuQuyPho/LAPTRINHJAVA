package LAB2;
import java.util.Scanner;
import java.util.ArrayList;

class Xe {
    private String tenChuXe;
    private String loaiXe;
    private float triGiaXe;
    private int dungTichXylanh;

    public Xe(String tenChuXe, String loaiXe, float triGiaXe, int dungTichXylanh) {
        this.tenChuXe = tenChuXe;
        this.loaiXe = loaiXe;
        this.triGiaXe = triGiaXe;
        this.dungTichXylanh = dungTichXylanh;
    }
    public float tinhThue() {
        if (dungTichXylanh < 100) {
            return triGiaXe/100;
        } else if (dungTichXylanh <= 175) {
            return triGiaXe*3/100;
        } else {
            return triGiaXe*5/100;
        }
    }
    public String xuatThongTinXe() {
        return "Ten chu xe: " + tenChuXe + "\nLoai xe: " + loaiXe +
               "\nTri gia xe: " + triGiaXe + "\nDung tich xylanh: " + dungTichXylanh +
               "\nThue phai dong: " + tinhThue();
    }
}

public class P1C4 {
    private static ArrayList<Xe> danhSachXe = new ArrayList<>();
    public static void nhapDanhSachXe() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap ten chu xe (nhap rong de ket thuc): ");
            String tenChuXe = scanner.nextLine();
            if (tenChuXe.isEmpty()) {
                break;
            }
            System.out.println("Nhap loai xe: ");
            String loaiXe = scanner.nextLine();
            System.out.println("Nhap tri gia xe: ");
            float triGiaXe = scanner.nextFloat();
            System.out.println("Nhap dung tich xylanh cua xe: ");
            int dungTichXylanh = scanner.nextInt();
            scanner.nextLine();

            danhSachXe.add(new Xe(tenChuXe, loaiXe, triGiaXe, dungTichXylanh));
        }
        scanner.close();
    }
    public static void xuatThuePhaiDong() {
        for (Xe xe : danhSachXe) {
            System.out.println(xe.xuatThongTinXe());
        }
    }
    public static void main(String[] args) {
        nhapDanhSachXe();
        xuatThuePhaiDong();
    }
}
