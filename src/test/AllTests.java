package src.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class) // Running All Tests With Test Suite
@SuiteClasses({ IsBusTypeValidTest.class, IsDurationValidTest.class, IsFromValidTest.class,
		IsNumberOfSeatsValidTest.class, IsPriceValidTest.class, IsToValidTest.class, 
		IsVoyageNoValidTest.class, IsUsernameValidTest.class, IsPasswordValidTest.class, 
		IsHesCodeValidTest.class, IsColumnBusTypeValidTest.class, IsColumnDurationValidTest.class,
		IsColumnFirstNameValidTest.class, IsColumnFromValidTest.class, IsColumnHesCodeValidTest.class,
		IsColumnIsAdminValidTest.class, IsColumnLastNameValidTest.class, IsColumnNumberOfSeatsValidTest.class,
		IsColumnPasswordValidTest.class, IsColumnPriceValidTest.class, IsColumnToValidTest.class,
		IsColumnUsernameValidTest.class, IsColumnVoyageNoValidTest.class, IsColumnVoyagePointsValidTest.class,
		IsConnectionValidTest.class, IsColumnSeatNoValidTest.class, IsAdminValidTest.class,
		IsSeatEmptyValidTest.class, IsColumnStatusValidTest.class, IsSeatNoValidTest.class})
public class AllTests {

}
