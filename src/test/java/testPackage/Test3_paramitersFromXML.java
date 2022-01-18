package testPackage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3_paramitersFromXML {
    @Parameters({"userName"}) // pull from xml 'suite_grupTests'
    @Test()
    public void sayHello(String param){
        System.out.println("Cześć " + param);
    }

    @AfterSuite
    public void sayHelloAfterSuit(){
        System.out.println("After suit in testPackage.Test3 class");
    }
}
