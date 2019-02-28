import java.time.LocalDate;

/**
 * This class is developed by Ivanov Alexey (mrSlilex@gmail.com) on 28.02.2019
 */

public class ValidatoinDate {


   public static boolean validateFromToDates(LocalDate fromDate , LocalDate toDate) throws ValidateFromToDatesException {
       if(fromDate.isAfter(toDate)) throw new ValidateFromToDatesException("validation error");
       if(fromDate.isAfter(LocalDate.now()) && fromDate.isEqual(toDate))  throw new ValidateFromToDatesException("future dates are the same");
   return true;
   }
}
