package services;

public class PaypalService implements OnlinePaymentService{

	private static double FEE_PERCENTAGE = 0.02;
	private static double MONTHLY_INTEREST = 0.01;
	
	
	@Override
	public double paymentFee(Double amount) {
		return amount * FEE_PERCENTAGE;
	}
	@Override
	public double interest(Double amount, int months) {
		return amount * MONTHLY_INTEREST * months;
	}
	
	
	
	
}
