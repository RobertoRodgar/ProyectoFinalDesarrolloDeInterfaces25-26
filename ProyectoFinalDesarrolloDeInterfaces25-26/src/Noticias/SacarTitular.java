package Noticias;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SacarTitular {
	public String sacarTitular(String web, String aBuscar) throws IOException {

		Document document = Jsoup.connect(web).get();
		Element titular = document.select(aBuscar).first();
		String resultado=titular.text();
		
		return resultado;
	}
}
