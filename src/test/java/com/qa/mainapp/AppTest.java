package com.qa.mainapp;

import static org.junit.Assert.assertTrue;

import com.qa.App;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private App app;

    @Test
    public void mainAppTest()
    {
        app = new App();
        app.main(new String[]{});
        assertTrue( true );
    }

}
