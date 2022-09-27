
package Vistas;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import  javafx.scene.text.Text;

public class PruebaHotelFX extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage miEscenario){
       Text miTexto = new Text("Bienvenido a JavaFX");
       VBox contenedor = new VBox();
       contenedor.getChildren().add(miTexto);
       contenedor.setMinSize(350, 250);
       Scene miEscena = new Scene(contenedor);
       miEscenario.setTitle("Mi primera app JavaFX");
       miEscenario.setMaxHeight(500);
       miEscenario.setMaxWidth(500);
       miEscenario.setScene(miEscena);
       miEscenario.show();
    }    
    
}
