package com.prodex.stationaryinventory.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prodex.stationaryinventory.common.PathConstants;
import com.prodex.stationaryinventory.common.enums.DepartementType;
import com.prodex.stationaryinventory.config.Router;
import com.prodex.stationaryinventory.models.RegistRequest;
import com.prodex.stationaryinventory.models.RegistRequest.RegistRequestBuilder;
import com.prodex.stationaryinventory.services.impl.LoginRegistServiceImpl;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView(PathConstants.SIGN_UP)
public class SignUpController implements Initializable {

    @Autowired LoginRegistServiceImpl loginRegistServiceImpl;
    @Autowired Router router;

    @FXML
    private TextField idEmployee;

    @FXML
    private ComboBox<DepartementType> idDepartement;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField fullName;

    @FXML
    private TextField noWhatsApp;

    @FXML
    private Label labelInfo;

    @FXML
    private TextField password;

    @FXML
    private TextField rePassword;

    @FXML
    private void signUpOnClick(ActionEvent event) throws SQLException {

        labelInfo.setText(" ");

        if(validationDataRegistration()){

            RegistRequestBuilder registReq = RegistRequest.builder()
                .idEmployee(Long.valueOf(idEmployee.getText()))
                .idDepartement(idDepartement.getId())
                .username(firstName.getText() + idEmployee.getText())
                .password(password.getText())
                .telNo(noWhatsApp.getText())
                .firstName(firstName.getText())
                .lastName(lastName.getText())
                .fullName(fullName.getText())
                ;

                loginRegistServiceImpl.regist(registReq.build());
        }

    }

    private boolean validationDataRegistration() {
        // validation id Employee
        if (!(idEmployee.getText().matches("\\d+"))) {
            labelInfo.setText("Id Employee cannot empty and just number !");
            return false;
        }

        // validation whatsApp Number
        if (!noWhatsApp.getText().equals("") || !(noWhatsApp.getText().matches("\\d+"))) {
            labelInfo.setText("No WhatsApp Cannot Empty and just number!");
            return false;
        }

        // validation password
        if (!password.getText().equals(rePassword.getText())) {
            labelInfo.setText("Password and Re-password not Same!");
            return false;
        }

        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        idDepartement.getItems().addAll(DepartementType.values());

    }

}
