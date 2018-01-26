

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class StudentUtil {
	public int getGradeOnGivenDate(String highSchoolGradDate, String
			givenDate) throws Exception {
		
		int grade = 12;
		if(highSchoolGradDate == null)
			throw new NullHighSchoolGradDateException("High School Graduation Date cannot be null");
		if(givenDate == null)
			givenDate = LocalDate.now().toString();
		
		try {
			LocalDate localdate1 = LocalDate.parse(highSchoolGradDate);
			
		} catch(DateTimeParseException dtpe) {
			
			throw dtpe;
		}
		
		try {
			LocalDate localdate2 = LocalDate.parse(givenDate);
			
		} catch(DateTimeParseException dtpe) {
			throw dtpe;
		}
		
			
		Period period = Period.between(LocalDate.parse(highSchoolGradDate), LocalDate.parse(givenDate));
		grade += period.getYears();

		if(grade < 0)
			grade = -1;
		
		if(period.getYears()>0 || (period.getYears()==0 && period.getMonths()>0) || (period.getYears()==0 && period.getMonths()==0 && period.getDays()>0))
			grade = 99;

		return grade;
	}
	
	static public void main(String...strings) throws Exception {
		try {
		System.out.println(new StudentUtil().getGradeOnGivenDate(strings[0], strings[1]));
		}
		catch(ArrayIndexOutOfBoundsException aiobe) {
			System.out.println(new StudentUtil().getGradeOnGivenDate(null, null));
		}
	}

}

/*

requirement questions;
Not sure need to check that both dates should not be in future.

for implementing the solution, From the examples,  Assuming the graduation date of all classes are same as the high school graduation date, because not sure how to use the constraint
"Academic year starts SEP-01 and ends JUN-30, inclusive"
say if high school graduation date is on Aug 15, give date is Aug 20, the result should be grade as 12 as per examples
say if high school graduation date is on Aug 15, give date is Aug 20, the result should be grade as 11 as per above given constraint because academic year starts only on Sep 01.
*/