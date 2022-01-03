import java.io.*;
import java.net.*;
public class MySocketTest {
    public static void main(String[] args)
    {
        try {
            
            for(int i = 0; i < 5000; i++)
            {
                // initializing Socket
                Socket soc = new Socket("localhost", 9000);
                System.out.println(i);
                DataOutputStream d = new DataOutputStream(
                    soc.getOutputStream());
                
                // message to display
                d.writeUTF("Hello GFG Readers!");         
            
                d.flush();
                
                // // closing DataOutputStream
                // d.close();
                
                // // closing socket
                // soc.close();
            }
        }
        
        // to initialize Exception in run time
        catch (Exception e) {
            System.out.println(e);
        }
    }
}