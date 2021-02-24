package fronttest.model;

import lombok.Data;

/**
 * Model for Payment used in the purchase process.
 * 
 * @author Nicolas Pizarro
 *
 */
@Data
public class Payment {
	String name;
	String country;
	String city;
	String creditCard;
	String month;
	String year;
}
