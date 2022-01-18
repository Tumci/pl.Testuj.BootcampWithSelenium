package testPackage;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.internal.collections.ArrayIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class Test4_paramitersFromDataProvider {
    @AfterSuite
    public void aS(){
        System.out.println("After suit test");
    }

    @Test()
    public void bigSmile(){
        System.out.println("Big smile :)");
    }
    @Test()
    public void mediumSmile(){
        System.out.println("Medium smile :)");
    }
    @Test()
    public void littleSmile(){
        System.out.println("Little smile :)");
    }

    //
//    @DataProvider(name = "test1")
//    public Object[][] createData1() {
//        return new Object[][] {
//                { "Cedric", new Integer(36) },
//                { "Anne", new Integer(37)},
//        };
//    }

    @DataProvider(name = "create")
    public static Object[][] createData() {
        return new Object[][] {
                new Object[] { true },
                new Object[] { false }
        };
    }

    @Test(dataProvider = "create")
    public void someSmile(boolean name){
        System.out.println("Smile will be on -> " + name);
        Assert.assertTrue(name, "Yes I did it");
    }
    //@AfterMethod
    public void afterMethod(){
        System.out.println("After method ----->");
    }
}
