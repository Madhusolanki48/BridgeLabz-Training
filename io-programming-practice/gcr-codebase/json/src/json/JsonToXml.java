package json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Maxwell\",\"age\":23}";
        //JSON to XML
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(json, Object.class);

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(obj);

        // print XML
        System.out.println(xml);
    }
}
