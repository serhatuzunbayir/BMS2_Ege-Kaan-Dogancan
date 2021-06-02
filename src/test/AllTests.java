package src.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IsBusTypeValidTest.class, IsDurationValidTest.class, IsFromValidTest.class,
		IsNumberOfSeatsValidTest.class, IsPriceValidTest.class, IsToValidTest.class, IsVoyageNoValidTest.class })
public class AllTests {

}
