import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.universe.SolarSystem;
import model.universe.Universe;
import model.universe.planet.Planet;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./character_creation/character-creation.fxml"));
        primaryStage.setTitle("Insterstellar Merchant");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
