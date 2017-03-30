package com.codebind;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ChefsListTest extends TestCase {
    private final ChefsList ChefTest = new ChefsList("Ham","No Cheese",3,"Hana");
    private final ChefsList ChefTestLowercase = new ChefsList("ham","no cheese",3,"hana");
    private final ChefsList ChefTestBlank = new ChefsList("","",0,"");


    public void testGetOrder() throws Exception {
        assertEquals(ChefTest.getOrder(), "Ham");
        assertEquals(ChefTestLowercase.getOrder(),"ham");
        assertEquals(ChefTestBlank.getOrder(),"");
    }

    public void testGetNotes() throws Exception {
        assertEquals(ChefTest.getNotes(), "No Cheese");
        assertEquals(ChefTestLowercase.getNotes(), "no cheese");
        assertEquals(ChefTestBlank.getNotes(),"");


    }

    public void testGetTableNo() throws Exception {
        assertEquals(ChefTest.getTableNo(),3);
        assertEquals(ChefTestLowercase.getTableNo(),3);
        assertEquals(ChefTestBlank.getTableNo(),0);
    }

    public void testGetServer() throws Exception {
        assertEquals(ChefTest.getServer(),"Hana");
        assertEquals(ChefTestLowercase.getServer(),"hana");
        assertEquals(ChefTestBlank.getServer(),"");
    }
}