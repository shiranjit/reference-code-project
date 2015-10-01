/**
 * 
 */
package com.shirish.test;

/**
 * @author
 *
 */
public class TestRN
{

    /**
     * 
     */
    public TestRN()
    {

    }
    
    public String generateRN(int nit){
        String romanN = "";
        int nc = nit;
        //500th poisition
        while(nc>=500){
            romanN +="D";
            nc -=500;
        }
        
        while(nc>=400){
            romanN +="XD";
            nc -=400;
        }
        
        //100th position case
        while(nc>=100){
            romanN +="C";
            nc -=100;
        }
        
        //10th position
        //fix 90 position
        while(nc>=90){
            romanN +="XC";
            nc -=90;
        }
        
        //take 50 case
        if(nc>=50){
            romanN +="L";
            nc -=50;            
        }
        
        //lets take 40 case
        if(nc>=40){
            romanN +="XL";
            nc -=40;
        }
       
        //lets take 10-30 cases
        while(nc>=10){
            romanN +="X";
            nc -=10;
        }
        
        //1s position
        //9th position
        if(nc==9){
            romanN +="IX";
            //done
            return romanN;
        }
        
        if(nc==4){
            romanN +="IV";
            return romanN;
        }
        
        if(nc>=5){
            romanN +="V";
            nc -=5;
        }
        //this is 1 -3 and 6 - 8 cases -- in both cases 
        // we will have 1 -3 as we substracted 5
        while(nc>0){
            romanN +="I";
            nc -=1;
            
        }
        
        return romanN;
    }

}
