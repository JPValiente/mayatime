
import Models.CuentaLarga;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anclenius
 */
public class main {
    
    public static void main(String[] args) throws ParseException {
        for (Integer i : CuentaLarga.getCuentaLarga()) {
            System.out.print(i+".");
        }
    }
}
