package de.unibonn.eis.lab.test;

import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.log4j.Logger;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.engine.http.QueryExceptionHTTP;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.RDF;

public class Main {
	public static void main(String[] args) {
		String service = "http://dbpedia.org/sparql";
		String query = "SELECT" + "*" + "WHERE" + "{"
				+ "<http://dbpedia.org/resource/David_Beckham>" + "?p" + "?o"
				+ "}";
		QueryExecution qe = QueryExecutionFactory.sparqlService(service, query);
		try {
			ResultSet rs = qe.execSelect();
			while (rs.hasNext()) {
				System.out.println(rs.next());
			}
		} catch (QueryExceptionHTTP e) {
			System.out.println(service + " is DOWN");
		} finally {
			qe.close();
		} // end try/catch/finally
	} // end method
} // end class

