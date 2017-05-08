package rahul.assingment1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import rahul.assingment1.data.IGuide;
import rahul.assingment1.model.Galaxy;
import rahul.assingment1.validators.IValidate;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void xtestRepition() {
		System.out.println("testing repitation");
		List<String> literals = new ArrayList<String>() {
			{
				add("DLV");
				add("MMMCCCXXXIII");
				add("MMMqMCCCqCXXXqXIII");
				add("DD");
				add("LL");
				add("VV");
				add("MqMqM");
				add("MMMqMDCCCD");
				add("MMMqMDCCCM");
			}
		};
		literals.forEach(x -> {
			System.out.println(x + " is " + IValidate.validateRepetation(x));
		});

	}

	public void xtestOrder() {
		System.out.println("testing order");
		List<String> literals = new ArrayList<String>() {
			{
				add("MDCLXVI");
				add("MMMDCCCCLXXXVIII");
				add("MMMCMCDCXCXLXXXIXIVI");
				add("VX");
				add("LC");
				add("DM");
				add("MMVI");
				add("MCMXLIV");
			}
		};
		literals.forEach(x -> {
			System.out.println(x + " is " + IValidate.validateOrdering(x));
		});
	}

	public void xtestWhole() {
		System.out.println("testing whole");
		List<String> literals = new ArrayList<String>() {
			{
				add("MMMCMDCCCLXXXIXVIII");
				add("MCMCMCDC");

			}
		};
		literals.forEach(x -> {
			System.out.println(x + " is " + IValidate.validate(x));
		});

	}

	public void xtestConvertion() {
		System.out.println("testing convertion");
		List<String> literals = new ArrayList<String>() {
			{
				add("MDCLXVI");
				add("MMMDCCCCLXXXVIII");
				add("MMMCMCDCXCXLXXXIXIVI");
				add("MCMCMCDC");
				add("LC");
				add("DM");
				add("MMVI");
				add("MMMCMDCCCLXXXIXVIII");
			}
		};
		literals.forEach(x -> {
			System.out.println(x + " is " + IGuide.convert(x));
		});
	}

	public void xtestCreation() {
		System.out.println("testing creation");
		List<Integer> literals = new ArrayList<Integer>() {
			{
				add(5555);
				add(2342);
				add(434);
				add(3456);
				add(4797);
			}
		};
		literals.forEach(x -> {
			System.out.println(x + " is " + IGuide.create(x));
		});
	}

	public void testInput() {
		System.out.println("testing inputs");
		List<String> inputs = new ArrayList<String>() {
			{
				add("glob is I");
				add("prok is V");
				add("pish is X");
				add("tegj is L");
				add("glob glob Silver is 34 Credits");
				add("glob prok Gold is 57800 Credits");
				add("pish pish Iron is 3910 Credits");
				add("how much is pish tegj glob glob ?");
				add("how many Credits is glob prok Silver ?");
				add("how many Credits is glob prok Gold ?");
				add("how many Credits is glob prok Iron ?");
				add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
			}
		};
		Galaxy g = new Galaxy(); 
		final Engine e1 = new Engine(g);
		inputs.forEach(x->System.out.println(e1.feedData(x)));
	}
}
