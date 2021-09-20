/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

/**
 *
 * @author Nitin
 */

import java.io.IOException;

public class Extras
{
    public static void clear()
    {     
       try 
       {
           new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
       } catch (IOException | InterruptedException ex) {}
    }
}
