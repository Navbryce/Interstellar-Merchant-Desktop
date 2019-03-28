package character_summary;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import model.player.Player;
import model.universe.SolarSystem;
import model.universe.Universe;
import model.universe.planet.Planet;

import java.net.URL;
import java.util.ResourceBundle;

public class SummaryController implements Initializable {
    @FXML
    private Text name;
    @FXML
    private Text pilot;
    @FXML
    private Text fighter;
    @FXML
    private Text trader;
    @FXML
    private Text engineer;
    @FXML
    private Text credits;
    @FXML
    private Text difficulty;
    @FXML
    private Text spaceship;

    private Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(new Universe(SolarSystem.
                Companion.generateSolarSystems(Planet.Companion.getPlanets())));
    }

    public void setPlayer(Player player) {
        this.player = player;
        setValuesBasedOnPlayer(player);
    }

    private void setValuesBasedOnPlayer(Player player) {
        this.name.setText(player.getName());
        this.pilot.setText(player.getSkillPoints()[0] + "");
        this.fighter.setText(player.getSkillPoints()[1] + "");
        this.trader.setText(player.getSkillPoints()[3] + "");
        this.engineer.setText(player.getSkillPoints()[2] + "");
        this.credits.setText(player.getCredits() + "");
        this.difficulty.setText(player.getDifficulty().toString());
        this.spaceship.setText(player.getShip().getType().toString());
    }
}
