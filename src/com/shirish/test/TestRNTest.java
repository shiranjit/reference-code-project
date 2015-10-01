/**
 * 
 */
package com.shirish.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 
 *
 */
public class TestRNTest
{

    private TestRN trn;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        trn = new TestRN();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
        trn = null;
    }

   
    @Test
    public void testGenerateRN()
    {
        try
        {
            for (int i =350; i < 910; i++)
            {

                String romanNum = trn.generateRN(i);
                System.out.println(" for number -- " + i + " roman numbers:--- " + romanNum);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("error -- " + e.getMessage());
        }

    }

}
