package org.isf.vaccine.test;


import org.isf.utils.exception.OHException;
import org.isf.vaccine.model.Vaccine;
import org.isf.vactype.model.VaccineType;

import static org.junit.Assert.assertEquals;

public class TestVaccine 
{	
    private String code = "Z";
    private String description = "TestDescription";
    private Integer lock = 0;
    
			
	public Vaccine setup(
			VaccineType vaccineType,
			boolean usingSet) throws OHException 
	{
		Vaccine vaccine;
	
				
		if (usingSet == true)
		{
			vaccine = new Vaccine();
			_setParameters(vaccineType, vaccine);
		}
		else
		{
			// Create Vaccine with all parameters 
			vaccine = new Vaccine(code, description, vaccineType, lock);
		}
				    	
		return vaccine;
	}
	
	public void _setParameters(
			VaccineType vaccineType,
			Vaccine vaccine) 
	{	
		vaccine.setCode(code);
		vaccine.setDescription(description);
		vaccine.setVaccineType(vaccineType);
		vaccine.setLock(lock);
		
		return;
	}
	
	public void check(
			Vaccine vaccine) 
	{		
    	System.out.println("Check Vaccine: " + vaccine.getCode());
    	assertEquals(code, vaccine.getCode());
    	assertEquals(description, vaccine.getDescription());
    	assertEquals(lock, vaccine.getLock());
		
		return;
	}
}
