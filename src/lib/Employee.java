package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private PersonalInfo personalInfo;
        private EmploymentInfo employmentInfo;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;

        public Employee(String employeeId, PersonalInfo personalInfo, EmploymentInfo employmentInfo, int monthWorkingInYear, boolean isForeigner, boolean gender, int monthlySalary, int otherMonthlyIncome, int annualDeductible, String spouseName, String spouseIdNumber) {
            this.employeeId = employeeId;
            this.personalInfo = personalInfo;
            this.employmentInfo = employmentInfo;
            this.monthWorkingInYear = monthWorkingInYear;
            this.isForeigner = isForeigner;
            this.gender = gender;
            this.monthlySalary = monthlySalary;
            this.otherMonthlyIncome = otherMonthlyIncome;
            this.annualDeductible = annualDeductible;
            this.spouseName = spouseName;
            this.spouseIdNumber = spouseIdNumber;
            childNames = new LinkedList<String>();
            childIdNumbers = new LinkedList<String>();
        }
	
	
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	private int calculateForeignerBonus(int baseSalary) {
            return isForeigner ? (int)(baseSalary * 1.5) : baseSalary;
        }

	public void setMonthlySalary(int grade) {	
		if (grade == 1) {
			monthlySalary = calculateForeignerBonus(3000000);
		}else if (grade == 2) {
			monthlySalary = calculateForeignerBonus(5000000);
		}else if (grade == 3) {
			monthlySalary = calculateForeignerBonus(7000000);
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
