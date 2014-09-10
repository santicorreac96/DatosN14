package mundo;

import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Buscador extends Region 
{
	public Buscador(HBox nueva)
	{
		WebView vistaWeb = new WebView();
		WebEngine buscador = vistaWeb.getEngine();
		final URL arch;
		try {
			 arch = new File("./datos/mapaFinal.html").toURL();
			buscador.load(arch.toExternalForm());
			buscador.setJavaScriptEnabled(true);
			nueva.getChildren().add(vistaWeb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
