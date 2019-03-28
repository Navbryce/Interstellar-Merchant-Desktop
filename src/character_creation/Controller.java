package character_creation;

import character_summary.SummaryController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.player.Player;
import model.player.Player.SkillBean;
import model.player.game_config.Difficulty;
import model.player.game_config.GameConfig;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField name_input;
    @FXML
    private TextField pilot_input;
    @FXML
    private TextField fighter_input;
    @FXML
    private TextField trader_input;
    @FXML
    private TextField engineer_input;
    @FXML
    private ComboBox<Difficulty> difficulty_selector = new ComboBox<>();

    @FXML
    private Button character_button = new Button();

    private Scene scene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.difficulty_selector.setItems(FXCollections.observableArrayList(Difficulty.values()));
        this.difficulty_selector.getSelectionModel().selectFirst();

        character_button.setOnAction(this::characterButtonListener);
    }

    private void characterButtonListener(ActionEvent event) {

        try {
            SkillBean skills = parseSkillsFromInputs();
            String name = name_input.getText();
            Difficulty difficulty = difficulty_selector.getValue();
            createPlayer(skills, name, difficulty);
        } catch (NumberFormatException exception) {
            characterCreationError("All the inputs must have numeric entries");
        }
    }

    private void createPlayer(SkillBean skills, String name,
                              Difficulty difficulty) {
        try {
            Player player = new Player(skills, name, new GameConfig(difficulty));
            moveScreens(player);
        } catch (IllegalArgumentException exception) {
            characterCreationError(exception.getMessage());
        }
    }

    private void moveScreens(Player player) {
        this.scene = character_button.getScene();

        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../character_summary/character-summary.fxml"));
            root = (Parent)loader.load();

            // get controller
            SummaryController controller =
                    loader.getController();
            controller.setPlayer(player);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        this.scene.setRoot(root);
    }

    private SkillBean parseSkillsFromInputs() throws NumberFormatException {
        int engineer = Integer.parseInt(engineer_input.getText());
        int trader = Integer.parseInt(trader_input.getText());
        int fighter = Integer.parseInt(fighter_input.getText());
        int pilot = Integer.parseInt(pilot_input.getText());
        return new SkillBean(pilot, fighter, trader, engineer);
    }

    private void characterCreationError(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Character Creation Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
