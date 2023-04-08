package com.prodex.stationaryinventory.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.prodex.stationaryinventory.common.PathConstants;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView(PathConstants.AUTHENTICATION)
public class AuthenticationController implements Initializable {

    @FXML
    private VBox vbox;    
    private Parent fxml;

    @FXML
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TranslateTransition trans = new TranslateTransition(Duration.seconds(2), vbox);
        trans.setToX(vbox.getLayoutX()*20);
        trans.play();
        trans.setOnFinished((e) ->{
            try {
                fxml = FXMLLoader.load(getClass().getResource(PathConstants.SIGN_IN));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    @FXML
    private void openSignIn(ActionEvent actEvent){
        TranslateTransition trans = new TranslateTransition(Duration.seconds(2), vbox);
        trans.setToX(vbox.getLayoutX()*20);
        trans.play();
        trans.setOnFinished((e) ->{
            try {
                fxml = FXMLLoader.load(getClass().getResource(PathConstants.SIGN_IN));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }
    
    @FXML
    private void openSignUp(ActionEvent actEvent){
        TranslateTransition trans = new TranslateTransition(Duration.seconds(2), vbox);
        trans.setToX(0);
        trans.play();
        trans.setOnFinished((e) ->{
            try {
                fxml = FXMLLoader.load(getClass().getResource(PathConstants.SIGN_UP));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }


}