import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class LoggerTest {

    public static void main(String[] args)
    {
        List<String> listStrings = new ArrayList<String>();
        listStrings.add("One");
        listStrings.add("Two");
        listStrings.add("Three");
        listStrings.add("Four");
        System.out.println(listStrings.toString());

        List<String> listStrings2 = new LinkedList<String>();
        listStrings2.add("Five");
        listStrings2.add("Six");
        listStrings2.add("Seven");
        listStrings2.add("Eight");
        System.out.println(listStrings2.toString());
    }


}
