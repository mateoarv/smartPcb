package smartpcb;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Utils
{
    private static DateFormat df;
    private static Date dateobj;
    private static long t1;
    public static String getDate()
    {
        if(df == null || dateobj == null)
        {
            df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            dateobj = new Date();
        }
        return df.format(dateobj);
    }
    public static String loadStringFile(File file)
    {
        StringBuilder tempBuilder = null;
        try 
        {
            tempBuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) 
            {
                tempBuilder.append(line);
                tempBuilder.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            return tempBuilder.toString();
        } 
        catch (IOException ex) 
        { 
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void saveStringToFile(File file,String string)
    {
        try
        {
            PrintWriter out = new PrintWriter(file);
            out.print(string);
            out.close();
        } 
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void startTimer()
    {
        t1 = System.currentTimeMillis();
    }
    public static void stopTimer()
    {
        long t = System.currentTimeMillis()-t1;
        System.out.println("Elapsed time: " + t + " milliseconds.");
    }
    public static float fitInterval(float num,float min,float max)
    {
        if(num<min)
            num=min;
        else if(num>max)
            num=max;
        return num;
    }
}

