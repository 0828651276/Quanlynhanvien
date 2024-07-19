import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLyNhanVien {
    private final List<NhanVien> listNhanVien = new ArrayList<>();

    public void themNhanVien(NhanVien nhanVien) {
        listNhanVien.add(nhanVien);
    }

    public double tinhLuongTrungBinh() {
        double sum = 0;
        for (NhanVien nv : listNhanVien) {
            sum += nv.Payroll();
        }
        return listNhanVien.isEmpty() ? 0 : sum / listNhanVien.size();
    }

    public List<NhanVienFulltime> lietKeNhanVienFulltimeLuongThapHonTrungBinh() {
        List<NhanVienFulltime> ketQua = new ArrayList<>();
        double luongTrungBinh = tinhLuongTrungBinh();
        for (NhanVien nv : listNhanVien) {
            if (nv instanceof NhanVienFulltime && nv.Payroll() < luongTrungBinh) {
                ketQua.add((NhanVienFulltime) nv);
            }
        }
        return ketQua;
    }

    public double tinhTongLuongParttime() {
        double sumpt = 0;
        for (NhanVien nv : listNhanVien) {
            if (nv instanceof NhanVienParttime) {
                sumpt += nv.Payroll();
            }
        }
        return sumpt;
    }

    public List<NhanVienFulltime> sapXepNhanVienFulltimeTheoLuong() {
        List<NhanVienFulltime> fulltimeList = new ArrayList<>();
        for (NhanVien nv : listNhanVien) {
            if (nv instanceof NhanVienFulltime) {
                fulltimeList.add((NhanVienFulltime) nv);
            }
        }
        fulltimeList.sort(Comparator.comparingDouble(NhanVienFulltime::Payroll));
        return fulltimeList;
    }

    public static void main(String[] args) {
        QuanLyNhanVien quanLy = new QuanLyNhanVien();

        NhanVienFulltime nv1 = new NhanVienFulltime("NV01", "Nguyen Van A", 30, "0123456789", "a@gmail.com", 2000000, 500000, 10000000);
        NhanVienFulltime nv2 = new NhanVienFulltime("NV02", "Tran Van B", 28, "0123456790", "b@gmail.com", 1500000, 300000, 9000000);
        NhanVienFulltime nv3 = new NhanVienFulltime("NV03", "Tran Van D", 28, "0123456760", "e@gmail.com", 1200000, 320000, 12000000);
        NhanVienParttime nv4 = new NhanVienParttime("NV04", "Le Thi C", 22, "0123456791", "c@gmail.com", 120);
        NhanVienParttime nv5 = new NhanVienParttime("NV05", "Le Thi D", 22, "0123426791", "f@gmail.com", 130);

        quanLy.themNhanVien(nv1);
        quanLy.themNhanVien(nv2);
        quanLy.themNhanVien(nv3);
        quanLy.themNhanVien(nv4);
        quanLy.themNhanVien(nv5);

        System.out.println("Luong trung binh: " + quanLy.tinhLuongTrungBinh());

        System.out.println("Nhan vien fulltime luong thap hon trung binh:");
        for (NhanVienFulltime nv : quanLy.lietKeNhanVienFulltimeLuongThapHonTrungBinh()) {
            System.out.println(nv);
        }

        System.out.println("Tong luong parttime: " + quanLy.tinhTongLuongParttime());

        System.out.println("Danh sach nhan vien fulltime theo luong tang dan:");
        for (NhanVienFulltime nv : quanLy.sapXepNhanVienFulltimeTheoLuong()) {
            System.out.println(nv);
        }
    }
}

