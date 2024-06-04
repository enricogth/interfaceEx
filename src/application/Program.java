package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter the contract data: ");
		System.out.print("Number: ");
		int number = input.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(input.next(), fmt);
		System.out.print("Contract value: ");
		double totalValue = input.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter the number of installments: ");
		int n = input.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
			
		contractService.processContract(contract, n);
		
		System.out.println("Installments: ");
		for (Installment installment: contract.getInstallments()) {
			System.out.println(installment);
		}
		
		
		input.close();
	}

}
