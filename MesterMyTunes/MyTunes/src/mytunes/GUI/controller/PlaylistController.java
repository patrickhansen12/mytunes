/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mytunes.be.MyTunes;

/**
 * FXML Controller class
 *
 * @author FrederikD
 */
public class PlaylistController implements Initializable {

    @FXML
    private TextField playlistName;
    @FXML
    private Button playlistCancel;
    @FXML
    private Button playlistSave;
    
    private MyTunes currentPlaylist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setMytunes(MyTunes newPlaylist) {
     currentPlaylist = newPlaylist;
    }

    @FXML
    private void playlistCancel(ActionEvent event) {
     // get a handle to the stage
    Stage stage = (Stage) playlistCancel.getScene().getWindow();
    // do what you have to do
    stage.close();
}
    
    
}
