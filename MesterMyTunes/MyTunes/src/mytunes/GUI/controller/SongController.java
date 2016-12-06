/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import mytunes.GUI.model.MyTunesModel;
import mytunes.be.MyTunes;

/**
 * FXML Controller class
 *
 * @author FrederikD
 */
public class SongController implements Initializable {

    @FXML
    private TextField songTitle;
    @FXML
    private TextField songArtist;
    @FXML
    private TextField songTime;
    @FXML
    private TextField songFile;
    @FXML
    private ChoiceBox<?> songCategory;
    @FXML
    private Button songCancel;
    @FXML
    private Button songMore;
    @FXML
    private Button songChoose;
    @FXML
    private Button songSave;
    
    private MyTunesModel myTunesModel;
    private MyTunes currentSong;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chooseSongFile(ActionEvent event) throws IOException, ClassNotFoundException {
        FileChooser fileChooser = new FileChooser();
        Window win = songChoose.getScene().getWindow();
        File file = fileChooser.showOpenDialog(win);
        myTunesModel.LoadSongsToFile(file);
    }

    void setMytunes(MyTunes newSong) {
        currentSong = newSong;
    }

    @FXML
    private void songCancel(ActionEvent event) {
           // get a handle to the stage
    Stage stage = (Stage) songCancel.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
    
}
