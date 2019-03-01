import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * This class is developed by Ivanov Alexey (mrSlilex@gmail.com) on 01.03.2019
 */

public class ValidatoinDateTest {
    private LocalDate fromDate;
    private LocalDate toDate;


    @Test(expected = ValidateFromToDatesException.class)
    public void ifOneOfTheDatesIsNullWeGetAnException() throws Exception {
         LocalDate fromDate =null;
         LocalDate toDate = null;

        ValidationDate.validateFromToDates(fromDate,toDate);

        fromDate = LocalDate.now();
        ValidationDate.validateFromToDates(fromDate,toDate);

        toDate = fromDate;
        fromDate = null;

        ValidationDate.validateFromToDates(fromDate,toDate);
    }

    @Test
    public void fromEarlierToDateOrTheSame() throws Exception {
        fromDate = LocalDate.of(2017,12,5);
        toDate = LocalDate.of(2018,5,5);

        boolean fromEarlierToDate =  ValidationDate.validateFromToDates(fromDate,toDate);
         fromDate = LocalDate.of(2018,5,5);
         toDate = LocalDate.of(2018,5,5);

        boolean identicalDates =  ValidationDate.validateFromToDates(fromDate,toDate);
        assertTrue(fromEarlierToDate);
        assertTrue(identicalDates);

    }

    @Test(expected = ValidateFromToDatesException.class)
    public void expectAnExceptionIfToDateBeforeFromDate() throws ValidateFromToDatesException {
         fromDate = LocalDate.of(2053, 5, 5);
         toDate = LocalDate.of(1999, 5, 5);
         ValidationDate.validateFromToDates(fromDate,toDate);

    }

    @Test(expected = ValidateFromToDatesException.class)
    public void bothDatesMustBeInTheFutureMayNOTDenoteTheSameDay() throws ValidateFromToDatesException {
        fromDate = LocalDate.of(2065,5,5);
        toDate = LocalDate.of(2065,5,5);
        ValidationDate.validateFromToDates(fromDate,toDate);
    }

    @Test
    public void fromDateMayBeInThePastToDateMustBeInTheFuture() throws ValidateFromToDatesException {
        fromDate = LocalDate.of(1500, 5, 5);
        toDate = LocalDate.of(2555, 5, 5);

        assertTrue(ValidationDate.validateFromToDates(fromDate,toDate));

    }



}