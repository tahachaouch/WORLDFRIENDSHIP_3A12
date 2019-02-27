/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.creater;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Question;
import service.QuestionService;
import service.UtiliseObjetService;


public class GeneratePDF {

	public static void main(String[] args) {
         
            
            
		try {
               UtiliseObjetService obs=new UtiliseObjetService();
                QuestionService qs = new QuestionService();
                ArrayList<Question> questions;   
                questions = (ArrayList<Question>) qs.afficherQuestionPDF(obs.getiduserdb().get(0).getId_userdb());
        //        String S=questions.get(0);
                String s=questions.toString();
             //   System.out.println(s);
              
              
              
              System.out.println();
                    
                    try {
                        OutputStream file = new FileOutputStream(new File("G:\\Test.pdf"));
                        
                        Document document = new Document();
                        PdfWriter.getInstance(document, file);
                        
                        document.open();
                        
                        document.add(new Paragraph(s));
                        document.add(new Paragraph(new Date().toString()));
                        
                        document.close();
                        file.close();
                        
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                    }
                } catch (SQLException ex) {

			Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
