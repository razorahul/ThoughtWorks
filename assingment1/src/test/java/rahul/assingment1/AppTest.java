package rahul.assingment1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import rahul.assingment1.validators.IValidate;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	assertTrue( true );
    }
    
    public void zstestRepition(){
    	List<String> literals = new ArrayList<String>(){{
    		add("DLV");
    		add("MMMCCCXXXIII");
    		add("MMMqMCCCqCXXXqXIII");
    		add("DD");
    		add("LL");
    		add("VV");
    		add("MqMqM");
    		add("MMMqMDCCCD");
    		add("MMMqMDCCCM");
    	}};
    	literals.forEach(x->{
    		System.out.println(x + " is " +IValidate.validateRepetation(x));
    	});
    	
    }
    
    public void testOrder(){
    	List<String> literals = new ArrayList<String>(){{
    		add("MDCLXVI");
    		add("MMMDCCCCLXXXVIII");
    		add("MMMCMCDCXCXLXXXIXIVI");
    		add("VX");
    		add("LC");
    		add("DM");
    		add("MMVI");
    		add("MCMXLIV");
    	}};
    	literals.forEach(x->{
    		System.out.println(x + " is " +IValidate.validateOrdering(x));
    	});
    }
}
