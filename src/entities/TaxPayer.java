package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	
	public TaxPayer() {
	}
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}
	
	public Double salaryTax() {
		double salary = salaryIncome / 12;
		
		if (salary < 3000) {
			return salaryIncome * 0.0;
		}
		else if (salaryIncome / 12 < 5000) {
			return salaryIncome * 0.10;
		}
		else {
			return salaryIncome * 0.20;
		}
	}
	
	public Double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public Double capitalTax() {
		return capitalIncome * 0.20;
	}
	
	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public Double taxRebate() {
		
		double totalSpending = healthSpending + educationSpending;
		if (totalSpending < grossTax() * 0.30) {
			return totalSpending;
		}
		else {
			return grossTax() * 0.30;
		}
	}
	
	public Double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return String.format("Imposto bruto total %.2f%n", grossTax()) 
				+ String.format("Abatimento: %.2f%n", taxRebate())
				+ String.format("Imposto devido: %.2f%n", netTax());
	}
	
}
