package com.test;
import com.service.TaxService;
import org.junit.Before;
import org.junit.Test;


import org.junit.After;
import org.junit.Assert;

import com.dto.TaxDto;

public class TaxServiceTest {
	TaxService taxService;
    
    @Before
    public void beforeTest() {
        taxService = new TaxService();
    }
    
    // Test case 1:  Under normal condition
    @Test
    public void testCalculateTaxPercent_PositiveValues() {
        TaxDto taxDto = new TaxDto(1, 50000.0, 5000, 2024);
        double expectedTaxPercent = 10.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
        Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }
    // Test case 2: Zero tax amount
    @Test
    public void testCalculateTaxPercent_ZeroTaxAmount() {
        TaxDto taxDto = new TaxDto(2, 60000.0, 0, 2024);
        double expectedTaxPercent = 0.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
        Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }
    
    
    // Test case 3: Negative net salary
    @Test
    public void testCalculateTaxPercent_NegativeNetSalary() {
        TaxDto taxDto = new TaxDto(4, -10000.0, 2000, 2023);
        double expectedTaxPercent = -20.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
        Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    

    }
    
    
 // Test case 4: Large values for net salary and tax amount
    @Test
    public void testCalculateTaxPercent_LargeValues() {
        TaxDto taxDto = new TaxDto(5, 1000000.0, 200000, 2023);
        double expectedTaxPercent = 20.0;
        double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
       Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }


    //Test case 5: Negative tax amount
    @Test
    public void testCalculateTaxPercent_NegativeTaxAmount() {
    TaxDto taxDto = new TaxDto(7, 60000.0, -3000, 2023);
    double expectedTaxPercent = -5.0;
    double actualTaxPercent = taxService.calculateTaxPercent(taxDto);
    Assert.assertEquals(expectedTaxPercent, actualTaxPercent, 0.0);
    }
    
    @After
    public void afterTest() {
        taxService = null;  
    }

}
