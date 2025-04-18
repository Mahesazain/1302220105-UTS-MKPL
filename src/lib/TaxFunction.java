package lib;

public class TaxFunction {

  /**
   * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
   * 
   * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
   * 
   * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
   * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
   * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
   * 
   */
  private static final int BASE_NON_TAXABLE_INCOME = 54000000;
  private static final int SPOUSE_DEDUCTION = 4500000;
  private static final int PER_CHILD_DEDUCTION = 1500000;
  private static final int MAX_DEDUCTIBLE_CHILDREN = 3;
  private static final double TAX_RATE = 0.05;

  public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

    int tax = 0;

    if (numberOfMonthWorking > 12) {
        throw new IllegalArgumentException("Months worked cannot exceed 12");
    }

    // Step 2: Replace magic numbers with constants
    int childDeduction = Math.min(numberOfChildren, MAX_DEDUCTIBLE_CHILDREN) * PER_CHILD_DEDUCTION;

    if (isMarried) {
      tax = (int) Math.round(TAX_RATE *
        (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) -
          deductible -
          (BASE_NON_TAXABLE_INCOME + SPOUSE_DEDUCTION + childDeduction)));
    } else {
      tax = (int) Math.round(TAX_RATE *
        (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) -
          deductible - BASE_NON_TAXABLE_INCOME));
    }

    return Math.max(tax, 0);
  }

}