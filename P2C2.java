package LAB2;

import java.util.ArrayList;
import java.util.Scanner;

public class P2C2 {
    public static void main(String[] args){
        QuanLyChuyenXe ql = new QuanLyChuyenXe();
        ql.nhapXuatDanhSachXe();
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nTONG DOANH THU CHUYEN NOI THANH LA: " + ql.tinhTongDoanhThuNoiThanh());
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nTONG DOANH THU CHUYEN NGOAI THANH LA: " + ql.tinhTongDoanhThuNgoaiThanh());
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nTONG DOANH THU 2 CHUYEN LA: " + ql.tinhTongDoanhThu2Chuyen());
        ql.inChuyenXeDoanhThuCaoNhat();
    }
}

class ChuyenXe{
    protected String maChuyenXe = "";
    protected String hoTenTaiXe = "";
    protected int soXe = 0;
    protected int khoiLuongHangHoa = 0;
    protected float doanhThu = 0.0f;
    public ChuyenXe(String maCX, String hoTenTX, int soxe, int klhh, float doanhthu){
        maChuyenXe=maCX;
        hoTenTaiXe=hoTenTX;
        soXe=soxe;
        khoiLuongHangHoa=klhh;
        doanhThu=doanhthu;
    }

    public ChuyenXe(){
        maChuyenXe="";
        hoTenTaiXe="";
        soXe=0;
        khoiLuongHangHoa=0;
        doanhThu=0;
    }
    public void Nhap(){
        Scanner sc =new Scanner(System.in);
        System.out.println("\n\nNHAP THONG TIN CHUYEN XE");
        System.out.println("Nhap ma chuyen xe: ");
        maChuyenXe=sc.nextLine();
        System.out.println("Nhap ho ten tai xe: ");
        hoTenTaiXe=sc.nextLine();
        System.out.println("Nhap so xe: ");
        soXe=sc.nextInt();
        System.out.println("Nhap khoi luong hang hoa: ");
        khoiLuongHangHoa=sc.nextInt();
        System.out.println("Nhap doanh thu: ");
        doanhThu=sc.nextFloat();
    }
    public void Xuat(){
        System.out.println("\nMa chuyen xe: "+maChuyenXe+"\nHo ten tai xe: "+hoTenTaiXe+ "\nSo xe: "+soXe+"\nKhoi luong hang hoa: "+khoiLuongHangHoa);
    }
    public float getDoanhThu() {
        return doanhThu;
    }
}

class ChuyenXeNoiThanh extends ChuyenXe{
    private int quangDuong = 0;
    public ChuyenXeNoiThanh(String maCX, String hoTenTX, int soxe, int klhh, int quangDuong, float doanhthu){
        super(maCX, hoTenTX, soxe, klhh, doanhthu);
        this.quangDuong = quangDuong;
    }
    public ChuyenXeNoiThanh() {
        maChuyenXe="";
        hoTenTaiXe="";
        soXe=0;
        khoiLuongHangHoa=0;
        doanhThu=0;
        quangDuong=0;
    }
    public void Nhap(){
        super.Nhap();
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap quang duong: ");
        quangDuong=sc.nextInt();
    }
    public void Xuat(){
        super.Xuat();
        System.out.println("Quang duong: "+quangDuong);
    }
}

class ChuyenXeNgoaiThanh extends ChuyenXe{
    private String noiDen = "";
    private int soNgayVanChuyen = 0;
    public ChuyenXeNgoaiThanh(String maCX, String hoTenTX, int soxe, int klhh, String noiden, int soNVC, float doanhthu){
        super(maCX, hoTenTX, soxe, klhh, doanhthu);
        this.noiDen = noiden;
        this.soNgayVanChuyen = soNVC;
    }
    public ChuyenXeNgoaiThanh() {
        maChuyenXe = "";
        hoTenTaiXe = "";
        soXe = 0;
        khoiLuongHangHoa = 0;
        doanhThu = 0;
        noiDen = "";
        soNgayVanChuyen = 0;
    }
    public void Nhap(){
        super.Nhap();
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap noi den: ");
        noiDen=sc.nextLine();
        System.out.println("Nhap so ngay van chuyen: ");
        soNgayVanChuyen=sc.nextInt();
    }
    public void Xuat(){
        super.Xuat();
        System.out.println("Noi den:  "+noiDen +"\nSo ngay van chuyen:"+soNgayVanChuyen);
    }
}

class QuanLyChuyenXe {
    private ArrayList<ChuyenXe> danhSachChuyenXe = new ArrayList<>();
    public void addChuyenXe(ChuyenXe cx){
        danhSachChuyenXe.add(cx);
    }
    public void nhapXuatDanhSachXe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong chuyen xe x < 20: ");
        int soLuongCX = 0;
        do {
            soLuongCX = scanner.nextInt();
            if (soLuongCX < 0 || soLuongCX > 20)
                System.out.println("So luong xe phai > 0 va < 20!");
        }
        while (soLuongCX < 0 || soLuongCX > 20);
        System.out.println("----------------------------------------------------------------");
        System.out.println("NHAP DANH SACH CHUYEN XE");
        for(int i = 0; i <  soLuongCX; i++) {
            System.out.println("Nhap chuyen xe muon them thong tin:\n1.Noi thanh\n2.Ngoai thanh");
            byte loai = scanner.nextByte();
            if(loai == 1){
                ChuyenXeNoiThanh cx = new ChuyenXeNoiThanh();
                cx.Nhap();
                addChuyenXe(cx);
            }
            else if(loai==2){
                ChuyenXeNgoaiThanh cx = new ChuyenXeNgoaiThanh();
                cx.Nhap();
                addChuyenXe(cx);
            }
        }
        scanner.close();
        System.out.println("----------------------------------------------------------------");
        System.out.println("\nDANH SACH THONG TIN CAC CHUYEN XE");
        for(int i=0; i<danhSachChuyenXe.size(); i++) {
            danhSachChuyenXe.get(i).Xuat();
        }  
    }
    public double tinhTongDoanhThuNoiThanh() {
        double tongDoanhThu = 0;
        for (ChuyenXe cx : danhSachChuyenXe) {
            if (cx instanceof ChuyenXeNoiThanh) {
                tongDoanhThu += cx.getDoanhThu();
            }
        }
        return tongDoanhThu;
    }

    public double tinhTongDoanhThuNgoaiThanh() {
        double tongDoanhThu = 0;
        for (ChuyenXe cx : danhSachChuyenXe) {
            if (cx instanceof ChuyenXeNgoaiThanh) {
                tongDoanhThu += cx.getDoanhThu();
            }
        }
        return tongDoanhThu;
    }

    public double tinhTongDoanhThu2Chuyen(){
        return tinhTongDoanhThuNgoaiThanh()+tinhTongDoanhThuNoiThanh();
    }

    // Phương thức in ra chuyến xe có doanh thu cao nhất
    public void inChuyenXeDoanhThuCaoNhat() {
        ChuyenXe xeNoiThanhMax = null;
        ChuyenXe xeNgoaiThanhMax = null;

        for (ChuyenXe cx : danhSachChuyenXe) {
            if (cx instanceof ChuyenXeNoiThanh && (xeNoiThanhMax == null || cx.getDoanhThu() > xeNoiThanhMax.getDoanhThu())) {
                xeNoiThanhMax = cx;
            } else if (cx instanceof ChuyenXeNgoaiThanh && (xeNgoaiThanhMax == null || cx.getDoanhThu() > xeNgoaiThanhMax.getDoanhThu())) {
                xeNgoaiThanhMax = cx;
            }
        }

        if (xeNoiThanhMax != null) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("\nCHUYEN NOI THANH CO DOANH THU CAO NHAT LA: ");
            xeNoiThanhMax.Xuat();
        }

        if (xeNgoaiThanhMax != null) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("\nCHUYEN NGOAI THANH CO DOANH THU CAO NHAT LA: ");
            xeNgoaiThanhMax.Xuat();
        }
    }
}
