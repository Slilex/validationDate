import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * This class is developed by Ivanov Alexey (mrSlilex@gmail.com) on 28.02.2019
 */

public class ValidatoinDateTest {

    @Before
    public void setUp(){


    }

    @Test
    public void fromEarlierToDateOrTheSame() throws Exception {
        LocalDate fromDateEarlierToDate = LocalDate.of(2017,12,5);
        LocalDate toDateAfterFrom = LocalDate.of(2018,5,5);
        LocalDate fromDate = LocalDate.of(2018,5,5);
        LocalDate toDate = LocalDate.of(2018,5,5);

        boolean fromEarlierToDate =  ValidatoinDate.validateFromToDates(fromDateEarlierToDate,toDateAfterFrom);
        boolean identicalDates =  ValidatoinDate.validateFromToDates(fromDate,toDate);
        assertTrue(fromEarlierToDate);
        assertTrue(identicalDates);

    }

    @Test(expected = ValidateFromToDatesException.class)
    public void expectAnExceptionIfToDateBeforeFromDate() throws ValidateFromToDatesException {
        LocalDate fromDate = LocalDate.of(2053, 5, 5);
        LocalDate toDate = LocalDate.of(1999, 5, 5);
        ValidatoinDate.validateFromToDates(fromDate,toDate);

    }

    @Test(expected = ValidateFromToDatesException.class)
    public void bothDatesMustBeInTheFutureMayNOTDenoteTheSameDay() throws ValidateFromToDatesException {
       // LocalDate fromDateEarlierToDate = LocalDate.of(2025,12,5);
      //  LocalDate toDateAfterFrom = LocalDate.of(2025,5,6);
        LocalDate fromDate = LocalDate.of(2065,5,5);
        LocalDate toDate = LocalDate.of(2065,5,5);
        ValidatoinDate.validateFromToDates(fromDate,toDate);
    }



    @Test
    public void fromDateMayBeInThePastToDateMustBeInTheFuture() throws ValidateFromToDatesException {
        LocalDate fromDate = LocalDate.of(1500, 5, 5);
        LocalDate toDate = LocalDate.of(2555, 5, 5);

        assertTrue(ValidatoinDate.validateFromToDates(fromDate,toDate));

    }


}