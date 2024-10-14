package fronttest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Model for Payment used in the purchase process.
 *
 * @author Nicolas Pizarro
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {
    String name;
    String country;
    String city;
    String creditCard;
    String month;
    String year;
}
