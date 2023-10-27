package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    public static Properties properties;
    static {
        String path="configuration.properties";

        try {
            FileInputStream fileInputStream =new FileInputStream(path);//Belirtilen dosya yolundan FileInputStream oluşturulur.
            properties=new Properties();
            properties.load(fileInputStream);//FileInputStream üzerinden yapılandırma dosyasındaki veriler Properties nesnesine yüklenir.
        }catch (IOException e){
            e.printStackTrace();
            /*
            Özetlemek gerekirse, e.printStackTrace() metodunun amacı,
            bir hata durumunda programın hangi satırda ve hangi metotda hata aldığını belirlemek ve
            bu bilgileri konsola yazdırmaktır. Bu, hata ayıklama sürecini kolaylaştırır.
             */
        }

    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
