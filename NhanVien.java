
class NhanVien {
    private final String Id;
    private final String Name;
    private final int Age;
    private final String Phones;
    private final String Email;

    public NhanVien(String Id, String Name, int Age, String Phones, String Email) {
        this.Id = Id;
        this.Name = Name;
        this.Age = Age;
        this.Phones = Phones;
        this.Email = Email;
    }

    // Các phương thức getter và setter
    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getPhones() {
        return Phones;
    }

    public String getEmail() {
        return Email;
    }

    public double Payroll() {
        return 0;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + Id + '\'' +
                ", hoTen='" + Name + '\'' +
                ", tuoi=" + Age +
                ", soDienThoai='" + Phones + '\'' +
                ", email='" + Email + '\'' +
                '}';
    }
}


class NhanVienFulltime extends NhanVien {
    private final double Bonus;
    private final double Fine;
    private final double HardSalary;

    public NhanVienFulltime(String Id, String Name, int Age, String Phones, String Email,
                            double Bonus, double Fine, double HardSalary) {
        super(Id, Name, Age, Phones, Email);
        this.Bonus = Bonus;
        this.Fine = Fine;
        this.HardSalary = HardSalary;
    }

    @Override
    public double Payroll() {
        return HardSalary + (Bonus - Fine);
    }

    public double getPayroll() {
        return HardSalary;
    }
}


class NhanVienParttime extends NhanVien {
    private final int HoursWorking;

    public NhanVienParttime(String Id, String Name, int Age, String Phones, String Email, int HoursWorking) {
        super(Id, Name, Age, Phones, Email);
        this.HoursWorking = HoursWorking;
    }

    @Override
    public double Payroll() {
        return HoursWorking * 100000;
    }
}




