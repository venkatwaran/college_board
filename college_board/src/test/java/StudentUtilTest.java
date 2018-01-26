
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class StudentUtilTest {

	@Test
	public void getGradeOnGivenDate() throws Exception {
		StudentUtil studentUtil = new StudentUtil();

		Assert.assertEquals(99, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-03"));
		Assert.assertEquals(99, studentUtil.getGradeOnGivenDate("2016-06-02", "2017-06-02"));
		Assert.assertEquals(99, studentUtil.getGradeOnGivenDate("2016-06-02", "2017-06-03"));
		Assert.assertEquals(99, studentUtil.getGradeOnGivenDate("2016-06-02", "9999-12-31"));

		Assert.assertEquals(12, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-02"));
		Assert.assertEquals(12, studentUtil.getGradeOnGivenDate("2016-06-02", "2016-06-01"));
		Assert.assertEquals(12, studentUtil.getGradeOnGivenDate("2016-06-02", "2015-06-03"));

		Assert.assertEquals(11, studentUtil.getGradeOnGivenDate("2016-06-02", "2015-06-02"));
		Assert.assertEquals(11, studentUtil.getGradeOnGivenDate("2016-06-02", "2015-06-01"));
		Assert.assertEquals(11, studentUtil.getGradeOnGivenDate("2016-06-02", "2014-06-03"));

		Assert.assertEquals(10, studentUtil.getGradeOnGivenDate("2016-06-02", "2014-06-02"));
		Assert.assertEquals(10, studentUtil.getGradeOnGivenDate("2016-06-02", "2014-06-01"));
		Assert.assertEquals(10, studentUtil.getGradeOnGivenDate("2016-06-02", "2013-06-03"));

		Assert.assertEquals(9, studentUtil.getGradeOnGivenDate("2016-06-02", "2013-06-02"));
		Assert.assertEquals(9, studentUtil.getGradeOnGivenDate("2016-06-02", "2013-06-01"));
		Assert.assertEquals(9, studentUtil.getGradeOnGivenDate("2016-06-02", "2012-06-03"));

		Assert.assertEquals(8, studentUtil.getGradeOnGivenDate("2016-06-02", "2012-06-02"));
		Assert.assertEquals(8, studentUtil.getGradeOnGivenDate("2016-06-02", "2012-06-01"));
		Assert.assertEquals(8, studentUtil.getGradeOnGivenDate("2016-06-02", "2011-06-03"));

		Assert.assertEquals(7, studentUtil.getGradeOnGivenDate("2016-06-02", "2011-06-02"));
		Assert.assertEquals(7, studentUtil.getGradeOnGivenDate("2016-06-02", "2011-06-01"));
		Assert.assertEquals(7, studentUtil.getGradeOnGivenDate("2016-06-02", "2010-06-03"));

		Assert.assertEquals(6, studentUtil.getGradeOnGivenDate("2016-06-02", "2010-06-02"));
		Assert.assertEquals(6, studentUtil.getGradeOnGivenDate("2016-06-02", "2010-06-01"));
		Assert.assertEquals(6, studentUtil.getGradeOnGivenDate("2016-06-02", "2009-06-03"));

		Assert.assertEquals(5, studentUtil.getGradeOnGivenDate("2016-06-02", "2009-06-02"));
		Assert.assertEquals(5, studentUtil.getGradeOnGivenDate("2016-06-02", "2009-06-01"));
		Assert.assertEquals(5, studentUtil.getGradeOnGivenDate("2016-06-02", "2008-06-03"));

		Assert.assertEquals(4, studentUtil.getGradeOnGivenDate("2016-06-02", "2008-06-02"));
		Assert.assertEquals(4, studentUtil.getGradeOnGivenDate("2016-06-02", "2008-06-01"));
		Assert.assertEquals(4, studentUtil.getGradeOnGivenDate("2016-06-02", "2007-06-03"));

		Assert.assertEquals(3, studentUtil.getGradeOnGivenDate("2016-06-02", "2007-06-02"));
		Assert.assertEquals(3, studentUtil.getGradeOnGivenDate("2016-06-02", "2007-06-01"));
		Assert.assertEquals(3, studentUtil.getGradeOnGivenDate("2016-06-02", "2006-06-03"));

		Assert.assertEquals(2, studentUtil.getGradeOnGivenDate("2016-06-02", "2006-06-02"));
		Assert.assertEquals(2, studentUtil.getGradeOnGivenDate("2016-06-02", "2006-06-01"));
		Assert.assertEquals(2, studentUtil.getGradeOnGivenDate("2016-06-02", "2005-06-03"));

		Assert.assertEquals(1, studentUtil.getGradeOnGivenDate("2016-06-02", "2005-06-02"));
		Assert.assertEquals(1, studentUtil.getGradeOnGivenDate("2016-06-02", "2005-06-01"));
		Assert.assertEquals(1, studentUtil.getGradeOnGivenDate("2016-06-02", "2004-06-03"));

		Assert.assertEquals(0, studentUtil.getGradeOnGivenDate("2016-06-02", "2004-06-02"));
		Assert.assertEquals(0, studentUtil.getGradeOnGivenDate("2016-06-02", "2004-06-01"));
		Assert.assertEquals(0, studentUtil.getGradeOnGivenDate("2016-06-02", "2003-06-03"));

		Assert.assertEquals(-1, studentUtil.getGradeOnGivenDate("2016-06-02", "2003-06-02"));
		Assert.assertEquals(-1, studentUtil.getGradeOnGivenDate("2016-06-02", "2003-06-01"));
		Assert.assertEquals(-1, studentUtil.getGradeOnGivenDate("2016-06-02", "2002-06-03"));
		try {
			studentUtil.getGradeOnGivenDate("2016-06-02", "0000-00-00");

		} catch (Exception e) {
			assertThat(e.getMessage(), is(
					"Text '0000-00-00' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 0"));
		}

		try {
			studentUtil.getGradeOnGivenDate("0000-00-00", "0000-00-00");

		} catch (Exception e) {
			assertThat(e.getMessage(), is(
					"Text '0000-00-00' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 0"));
		}

		try {
			studentUtil.getGradeOnGivenDate("0000-06-00", "0000-07-00");

		} catch (Exception e) {
			assertThat(e.getMessage(), is(
					"Text '0000-06-00' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): 0"));
		}

		// leap year test case
		try {
			studentUtil.getGradeOnGivenDate("0001-02-29", "0000-07-04");

		} catch (Exception e) {
			assertThat(e.getMessage(),
					is("Text '0001-02-29' could not be parsed: Invalid date 'February 29' as '1' is not a leap year"));
		}

		// leap year test case
		try {
			studentUtil.getGradeOnGivenDate("2016-02-29", "2015-02-29");

		} catch (Exception e) {
			assertThat(e.getMessage(),
					is("Text '2015-02-29' could not be parsed: Invalid date 'February 29' as '2015' is not a leap year"));
		}

		try {
			studentUtil.getGradeOnGivenDate(null, null);

		} catch (Exception e) {
			assertThat(e.getMessage(), is("High School Graduation Date cannot be null"));
		}

	}
}
