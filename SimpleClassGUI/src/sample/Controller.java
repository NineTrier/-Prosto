//Михалева Елизавета ИВТ-19
package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.io.IOException;

public class Controller {

    @FXML
    TextField EditX;
    @FXML
    TextField EditY;
    @FXML
    TextField EditX1;
    @FXML
    TextField EditY1;
    @FXML
    TextField EditX2;
    @FXML
    TextField EditY2;
    @FXML
    TextField EditResult;
    @FXML
    Button BtnArea;
    @FXML
    Button BtnPerimeter;

    @FXML
    public void initialize(){
        BtnArea.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sample.Square sqr = new Square();
                double x,y,x1,y1,x2,y2;
                x=Integer.parseInt(EditX.getText());
                y=Integer.parseInt(EditY.getText());
                x1=Integer.parseInt(EditX1.getText());
                y1=Integer.parseInt(EditY1.getText());
                x2=Integer.parseInt(EditX2.getText());
                y2=Integer.parseInt(EditY2.getText());
                try {
                    sqr.setAll(x, y, x1, y1, x2, y2);
                    EditResult.setText(String.valueOf(sqr.area()));
                }
                catch(IOException e){
                    EditResult.setText(e.getMessage());
                }
            }
        });
        BtnPerimeter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sample.Square sqr = new Square();
                double x,y,x1,y1,x2,y2;
                x=Integer.parseInt(EditX.getText());
                y=Integer.parseInt(EditY.getText());
                x1=Integer.parseInt(EditX1.getText());
                y1=Integer.parseInt(EditY1.getText());
                x2=Integer.parseInt(EditX2.getText());
                y2=Integer.parseInt(EditY2.getText());
                try {
                    sqr.setAll(x, y, x1, y1, x2, y2);
                    EditResult.setText(String.valueOf(sqr.perimeter()));
                }
                catch(IOException e){
                    EditResult.setText(e.getMessage());
                }
            }
        });
    }

}
