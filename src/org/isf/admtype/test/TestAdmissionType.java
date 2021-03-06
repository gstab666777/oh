package org.isf.admtype.test;


import org.isf.utils.exception.OHException;
import org.isf.admtype.model.AdmissionType;

import static org.junit.Assert.assertEquals;

public class TestAdmissionType 
{	
    private String code = "ZZ";
    private String description = "TestDescription";
    
			
	public AdmissionType setup(
			boolean usingSet) throws OHException 
	{
		AdmissionType admissionType;
	
				
		if (usingSet == true)
		{
			admissionType = new AdmissionType();
			_setParameters(admissionType);
		}
		else
		{
			// Create AdmissionType with all parameters 
			admissionType = new AdmissionType(code, description);
		}
				    	
		return admissionType;
	}
	
	public void _setParameters(
			AdmissionType admissionType) 
	{	
		admissionType.setCode(code);
		admissionType.setDescription(description);
		
		return;
	}
	
	public void check(
			AdmissionType admissionType) 
	{		
    	System.out.println("Check AdmissionType: " + admissionType.getCode());
    	assertEquals(code, admissionType.getCode());
    	assertEquals(description, admissionType.getDescription());
		
		return;
	}
}
