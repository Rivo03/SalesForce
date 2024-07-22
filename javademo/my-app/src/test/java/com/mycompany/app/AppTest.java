package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import java.beans.Transient;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.mycompany.app.App;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void shouldAnswerWithFalse()
    {
        assertFalse( false );
    }
    @Test
    public void test(){
        App.main(null);
    }
    @Test
    public void test_instanza(){
        new App();
    }
}
