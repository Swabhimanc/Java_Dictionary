package com.example.google_dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.EventListener;

public class DictionaryPageController
{
    @FXML
    TextField textBox;

    @FXML
    TextArea textArea;

    @FXML
    Button searchButton;


    public void searchButton(ActionEvent event)
    {
        String word=textBox.getText();
        InternetConnection ic=new InternetConnection();
        String meaning=ic.getOnlineData(word);


        textArea.setText(meaning);
    }

}
