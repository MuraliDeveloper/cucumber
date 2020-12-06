package Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.json.simple.JSONObject;

import main.ConstantData;

/**
 * 
 * @author Pooja Khanna
 * @version 1.0
 * @since 15/02/2019 /* Change History
 *        *********************************************************************************
 *        Version Date Defect/Task ID changed by Description
 ***********************************************************************************
 * 
 ***********************************************************************************
 */
@SuppressWarnings("unused")
public class GeneralUtilities {

		
	
    static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

    public String random()
    {
    	int n = 20; 
    	  
        // Get and display the alphanumeric string 
        System.out.println(GeneralUtilities.getAlphaNumericString(n));
		return getAlphaNumericString(n); 

    }
    
    static String getAlphaNumeric2digit(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

    public String random2digit()
    {
    	int n = 2; 
    	  
        // Get and display the alphanumeric string 
        System.out.println(GeneralUtilities.getAlphaNumeric2digit(n));
		return getAlphaNumeric2digit(n); 

    }
    
    static String getAlphaNumeric3digit(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"; 
                                  
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

    public String random3digit()
    {
    	int n = 3; 
    	  
        // Get and display the alphanumeric string 
        System.out.println(GeneralUtilities.getAlphaNumeric3digit(n));
		return getAlphaNumeric3digit(n); 

    }
    
    
    static String getAlphaNumeric4digit(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

    public String random4digit()
    {
    	int n = 2; 
    	  
        // Get and display the alphanumeric string 
        System.out.println(GeneralUtilities.getAlphaNumeric4digit(n));
		return getAlphaNumeric4digit(n); 

    }
    
    static String getAlphaNumeric5digit(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"; 
                                  
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 

    public String random5digit()
    {
    	int n = 5; 
    	  
        // Get and display the alphanumeric string 
        System.out.println(GeneralUtilities.getAlphaNumeric5digit(n));
		return getAlphaNumeric5digit(n); 

    }
}

