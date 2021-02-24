package fronttest.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;

import fronttest.model.Payment;

public class PaymentDataProvider {
	
	/**
	 * Generates a payment object from a given JSON file.
	 * 
	 * @return payment object.
	 */
	@DataProvider
	public Object[][] fromJson() {
		ObjectMapper objectMapper = new ObjectMapper();
		Payment payment;

		try {
			payment = objectMapper.readValue(new File("src/test/resources/data/payment.json"), Payment.class);
			return new Object[][] { { payment } };
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
