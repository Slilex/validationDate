import java.time.LocalDate;

/**
 * This class is developed by Ivanov Alexey (mrSlilex@gmail.com) on 01.03.2019
 */

public class ValidationDate {

    /**
     * date validation method
     * @param fromDate - date type LocalDate
     * @param toDate -  date, such as localdate, which is later or equal fromDate
     * @return true or @exception ValidateFromToDatesException
     */
   public static boolean validateFromToDates(LocalDate fromDate , LocalDate toDate) throws ValidateFromToDatesException {
       if(fromDate == null || toDate == null) throw new ValidateFromToDatesException("one of the dates is null");
       if(fromDate.isAfter(toDate)) throw new ValidateFromToDatesException("FromDate after toDate");
       if(fromDate.isAfter(LocalDate.now()) && fromDate.isEqual(toDate))  throw new ValidateFromToDatesException("future dates are the same");
   return true;
   }
}
