/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ASUS
 */
public class Partage {
     public void Partager(String nom, String image){
    

        
          String domain="https://localhost/";
          //domain="https://google.fr/";
         String appId="358579361653281";
         String appSecret="92acf0d4fe304e97e3ebd39dc11a72f0";
        
         
         String authURL=" https://www.facebook.com/dialog/share?app_id="+appId+"&display=popup&link=http://localhost/index&redirect_uri="+domain;
         
         System.setProperty("webdriver.chrome.driver", "C:/Users/ASUS/Desktop/chromedriver.exe");
         WebDriver driver= new ChromeDriver();
         driver.get(authURL);
         String accessToken="358579361653281|JgeMa2BoGm1Mv-D5FLSPa1HMjVo" ;
         
    
         boolean ok=true;
         while(ok)
         {
//             if ( (! driver.getCurrentUrl().contains("facebook.com")) && (driver.getCurrentUrl()!=authURL) )
//             {
//                 String url =driver.getCurrentUrl();
//             //    accessToken =url.replaceAll(".*#access_token=(.+)&.*", "$1");
//                 System.out.println(accessToken);
//                
//                 ok=false;
//              }
             
         }
         
         System.out.println("act:"+accessToken);
         driver.quit();
         FacebookClient fbClient = new DefaultFacebookClient(accessToken);
              User me = fbClient.fetchObject("me", User.class);
              System.out.println(me.getUsername());
              FacebookType publishPhotoResponse = fbClient.publish("me/photos", FacebookType.class,
  BinaryAttachment.with(image, getClass().getResourceAsStream("C://wamp64/www/Images/"+image)),
  Parameter.with("message", "Evenement"+" "+ nom+" "));
//            
//              FacebookType publishMessageResponse =
//            fbClient.publish("me/feed", FacebookType.class,
//                    com.restfb.Parameter.with("message","Evenement"));
//          
//
//              System.out.println("Published message ID: " + publishMessageResponse.getId());

    /**
     *
     */
    
        
    
            
    }

  
    
}
