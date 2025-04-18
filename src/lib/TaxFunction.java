package lib;

public class TaxFunction {
    private static final int BASE_NON_TAXABLE_INCOME = 54000000;
    private static final int SPOUSE_DEDUCTION = 4500000;
    private static final int PER_CHILD_DEDUCTION = 1500000;
    private static final int MAX_DEDUCTIBLE_CHILDREN = 3;
    private static final double TAX_RATE = 0.05;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome,
                                 int numberOfMonthWorking, int deductible,
                                 boolean isMarried, int numberOfChildren) {
        
        validateInput(numberOfMonthWorking, numberOfChildren);
        
        int taxFreeIncome = calculateTaxFreeIncome(isMarried, numberOfChildren);
        int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome,
                                                 numberOfMonthWorking, deductible,
                                                 taxFreeIncome);
        
        return calculateFinalTax(taxableIncome);
    }

    private static void validateInput(int numberOfMonthWorking, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            throw new IllegalArgumentException("Months worked cannot exceed 12");
        }
        if (numberOfChildren < 0) {
            throw new IllegalArgumentException("Number of children cannot be negative");
        }
    }

    private static int calculateTaxFreeIncome(boolean isMarried, int numberOfChildren) {
        int taxFreeIncome = BASE_NON_TAXABLE_INCOME;
        
        if (isMarried) {
            taxFreeIncome += SPOUSE_DEDUCTION;
        }
        
        taxFreeIncome += Math.min(numberOfChildren, MAX_DEDUCTIBLE_CHILDREN) * PER_CHILD_DEDUCTION;
        
        return taxFreeIncome;
    }

    private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome,
                                           int numberOfMonthWorking, int deductible,
                                           int taxFreeIncome) {
        return ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - taxFreeIncome;
    }

    private static int calculateFinalTax(int taxableIncome) {
        return Math.max((int) Math.round(TAX_RATE * taxableIncome), 0);
    }
}