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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mytunes.be.MyTunes;

/**
 *
 * @author Patrick
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button newPlaylist;
    @FXML
    private Button editPlaylist;
    @FXML
    private Button deletePlaylist;
    @FXML
    private Button moveSongUp;
    @FXML
    private Button moveSongDown;
    @FXML
    private Label label1;
    @FXML
    private Button deleteSongs;
    @FXML
    private Button editSongs;
    @FXML
    private Button newSong;
    @FXML
    private Button moveSong;
    @FXML
    private Slider slider;
    @FXML
    private Button deletePlaylistSong;
    
    private MyTunes currentSong;
    @FXML
    private Font x1;
    @FXML
    private TableColumn<MyTunes, String> columnSong;
    @FXML
    private TableColumn<MyTunes, String> columnArtist;
    @FXML
    private TableColumn<MyTunes, Integer> columnTime;
    @FXML
    private TableColumn<MyTunes, String> columnTitle;
    @FXML
    private TableColumn<MyTunes, String> columnArtist2;
    @FXML
    private TableColumn<MyTunes, String> columnCategory;
    @FXML
    private TableColumn<MyTunes, Integer> columnTime2;
    
    MediaPlayer mediaPlayer = null;
    @FXML
    private TableView<MyTunes> tablePlaylist;
    @FXML
    private TableView<MyTunes> tableSong;
    @FXML
    private Button closeApp;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    public void setSong(MyTunes song)
    {
        currentSong = song;
    }
    @FXML
    private void stopSong(ActionEvent event) {
        if(mediaPlayer != null)
        {
             mediaPlayer.stop();
        } 
    }    

    @FXML
    private void pauseSong(ActionEvent event) 
    {
        if(mediaPlayer == null)
        {
        String path = "C:/Users/FrederikD/Music/Music/Radiogaga.mp3";
        File file = new File(path);
        Media hit = new Media(file.toURI().toString());
        if(mediaPlayer != null)
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        }
        if(mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING)
        {
            mediaPlayer.pause();
        }
        else
        {
            mediaPlayer.play();
        }
    }

        private void loadMyTunesPlaylistView(MyTunes newPlaylist) throws IOException
          {
        // Fetches primary stage and gets loader and loads FXML file to Parent
        Stage primStage = (Stage)tablePlaylist.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/GUI/view/Playlist.fxml"));
        Parent root = loader.load();
        
        // Fetches controller from patient view
        PlaylistController playlistController = loader.getController();
        
        playlistController.setMytunes(newPlaylist);
        
        // Sets new stage as modal window
        Stage stagePlaylist = new Stage();
        stagePlaylist.setScene(new Scene(root));
        
        stagePlaylist.initModality(Modality.WINDOW_MODAL);
        stagePlaylist.initOwner(primStage);
        
        stagePlaylist.show();
    }

    @FXML
    private void NewPlaylistAction(ActionEvent event) throws IOException 
    {
            MyTunes selectedPlaylist = tablePlaylist.getSelectionModel().getSelectedItem();
            loadMyTunesPlaylistView(selectedPlaylist);

    }
    
    private void loadMyTunesSongView(MyTunes newSong) throws IOException
    {
        // Fetches primary stage and gets loader and loads FXML file to Parent
        Stage primStage = (Stage)tableSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunes/GUI/view/Song.fxml"));
        Parent root = loader.load();
        
        // Fetches controller from patient view
        SongController songController = loader.getController();
        
        songController.setMytunes(newSong);
        
        // Sets new stage as modal window
        Stage stageSong = new Stage();
        stageSong.setScene(new Scene(root));
        
        stageSong.initModality(Modality.WINDOW_MODAL);
        stageSong.initOwner(primStage);
        
        stageSong.show();
    }

    @FXML
    private void NewSongAction(ActionEvent event) throws IOException 
    {
            MyTunes selectedSong = tableSong.getSelectionModel().getSelectedItem();
            loadMyTunesSongView(selectedSong);

    }

    @FXML
    private void closeApp(ActionEvent event) {

     // get a handle to the stage
    Stage stage = (Stage) closeApp.getScene().getWindow();
    // do what you have to do
    stage.close();
}
}

