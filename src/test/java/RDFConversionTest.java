import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class RDFConversionTest {

    @Test
    public void testConversion(){
        String data = getFile("person.ttl");
        RDFConversion rdfConversion = new RDFConversion();
        String results = rdfConversion.convert(data, "TTL", "JSON-LD");
        System.out.print(results);
    }

    private String getFile(String fileName){
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try
        {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName), Charset.defaultCharset());
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
