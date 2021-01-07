package storge;

import java.io.*;

public class ReadAndWrite {
    public static void writeFile(Object obj, String filePath){
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Object ReadFile(String filePath){
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return obj;
    }
}
