import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

public class RDFConversion {
    public String convert(String rdf, String originalFormat, String formatRequested){
        Model rdfModel = ModelFactory.createDefaultModel();
        rdfModel.read(new ByteArrayInputStream(rdf.getBytes()), null, originalFormat);
        StringWriter stringWriter = new StringWriter();
        RDFDataMgr.write(stringWriter, rdfModel, RDFFormat.JSONLD);
        return stringWriter.toString();
    }
}
