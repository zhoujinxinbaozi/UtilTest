package properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        // appindexgul=867359041607906,862989035403550,869714035704028,45c8ecf83e9cd667f1bdb75f8ef50b2e191436d7,59bb3d333c79e9af8374c946ad82b1671dcb8cbc,353014080548146,867527032941365,860445045309800,860445045586118,860445044763858,860445044887897,8276c1755e70e8a047e2c7dabc1292764956326f,1cfe091327ffa46b63814424899b22839190e7ce,4b497b07b57b40e4f7c67475f99b2da3e25c34e1,f560d29fbad36b69aa48b5f14b39d4cca5aedf12,ceb62f86f3d29c223afc484d027e2b68a144fd7b
        String configPath = "D:\\others\\whitelist.txt";
        Properties prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);
        input.close();

        if(null != prop) {
            for (String key : prop.stringPropertyNames()) {
                String val = prop.getProperty(key);
                List<String> wl = new ArrayList<String>();
                if (null == val || val.equals("")) {
                    continue;
                }
                String[] tmp = val.split(",");
                for (int i = 0; i < tmp.length; i++) {
                    if (!tmp[i].equals("")) {
                        wl.add(tmp[i]);
                    }
                }
                System.out.println("key = " + key + "  list = " + wl.toString());
            }
        }
    }
}
