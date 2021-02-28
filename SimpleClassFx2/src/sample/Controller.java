package sample;

import library.date.Date;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    Button plusday;
    @FXML
    Button minusday;
    @FXML
    Button plusmnt;
    @FXML
    Button minusmnt;
    @FXML
    Button plusyear;
    @FXML
    Button minusyear;
    @FXML
    Button plusday1;
    @FXML
    Button minusday1;
    @FXML
    Button plusmnt1;
    @FXML
    Button minusmnt1;
    @FXML
    Button plusyear1;
    @FXML
    Button minusyear1;
    @FXML
    Button dts;
    @FXML
    Button dts1;
    @FXML
    Button sumbtn;
    @FXML
    Button diffbtn;

    @FXML
    TextField dayedit;
    @FXML
    TextField mntedit;
    @FXML
    TextField yearedit;
    @FXML
    TextField dayedit1;
    @FXML
    TextField mntedit1;
    @FXML
    TextField yearedit1;
    @FXML
    TextField StrEdit;
    @FXML
    TextField StrEdit1;
    @FXML
    TextField SDEdit;

    @FXML
    public void initialize() {

        //Далее идут обработчики ввода данных в текстовые поля, чтобы пользователь не мог ввести 321 день 54 месяца -123 года
        dayedit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int m = Integer.parseInt(mntedit.getText());
                int d = Integer.parseInt(newValue);
                int y = Integer.parseInt(yearedit.getText());
                if(d<1)
                {
                    dayedit.setText("1");
                }
                if ((m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) && d>31) {
                    dayedit.setText("31");
                }
                if(m==2 && y%4!=0 && d>28) {//Високосность проверяем через остаток от деления года на 4
                    dayedit.setText("28");
                }
                if(m==2 && y%4==0 && d>29) {
                    dayedit.setText("29");
                }
                if((m==4 || m==6 || m==9 || m==11) && d>30) {
                    dayedit.setText("30");
                }
            }
        });

        mntedit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int m = Integer.parseInt(mntedit.getText());
                if(m<1)
                {
                    mntedit.setText("1");
                }
                if(m>12)
                {
                    mntedit.setText("12");
                }
            }
        });

        yearedit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int y = Integer.parseInt(yearedit.getText());
                if(y<1)
                {
                    yearedit.setText("1");
                }
            }
        });

        dayedit1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int m = Integer.parseInt(mntedit1.getText());
                int d = Integer.parseInt(newValue);
                int y = Integer.parseInt(yearedit1.getText());
                if(d<1)
                {
                    dayedit1.setText("1");
                }
                if ((m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) && d>31) {
                    dayedit1.setText("31");
                }
                if(m==2 && y%4!=0 && d>28) {//Високосность проверяем через остаток от деления года на 4
                    dayedit1.setText("28");
                }
                if(m==2 && y%4==0 && d>29) {
                    dayedit1.setText("29");
                }
                if((m==4 || m==6 || m==9 || m==11) && d>30) {
                    dayedit1.setText("30");
                }
            }
        });

        mntedit1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int m = Integer.parseInt(mntedit1.getText());
                if(m<1)
                {
                    mntedit1.setText("1");
                }
                if(m>12)
                {
                    mntedit1.setText("12");
                }
            }
        });

        yearedit1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                int y = Integer.parseInt(yearedit1.getText());
                if(y<1)
                {
                    yearedit1.setText("1");
                }
            }
        });

        //Далее идут обработчики событий для кнопок + и -

        plusday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date(); //Так как дни могут влиять на кол-во месяцев и лет, то в данном обработчике мы будем получать все данные и перезаносить
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat.DayAdd(1);
                    dayedit.setText(String.valueOf(dat.getDay()));
                    mntedit.setText(String.valueOf(dat.getMnt()));
                    yearedit.setText(String.valueOf(dat.getYear()));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        });

        plusmnt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();//Так как от месяца максимальное кол-во дней может быть разным, а год увеличится после 12 месяца, то тут тоже получаем все поля
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat.MonthAdd(1);
                    dayedit.setText(String.valueOf(dat.getDay()));
                    mntedit.setText(String.valueOf(dat.getMnt()));
                    yearedit.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        plusyear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat.YearAdd(1);
                    yearedit.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        minusday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date();
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat.DayRemove(1);
                    dayedit.setText(String.valueOf(dat.getDay()));
                    mntedit.setText(String.valueOf(dat.getMnt()));
                    yearedit.setText(String.valueOf(dat.getYear()));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        });

        minusmnt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat.MonthRemove(1);
                    dayedit.setText(String.valueOf(dat.getDay()));
                    mntedit.setText(String.valueOf(dat.getMnt()));
                    yearedit.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        minusyear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat.YearRemove(1);
                    yearedit.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        plusday1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date(); //Так как дни могут влиять на кол-во месяцев и лет, то в данном обработчике мы будем получать все данные и перезаносить
                    dat.setDay(Integer.parseInt(dayedit1.getText()));
                    dat.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    dat.DayAdd(1);
                    dayedit1.setText(String.valueOf(dat.getDay()));
                    mntedit1.setText(String.valueOf(dat.getMnt()));
                    yearedit1.setText(String.valueOf(dat.getYear()));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        });

        plusmnt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();//Так как от месяца максимальное кол-во дней может быть разным, а год увеличится после 12 месяца, то тут тоже получаем все поля
                    dat.setDay(Integer.parseInt(dayedit1.getText()));
                    dat.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    dat.MonthAdd(1);
                    dayedit1.setText(String.valueOf(dat.getDay()));
                    mntedit1.setText(String.valueOf(dat.getMnt()));
                    yearedit1.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        plusyear1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    dat.YearAdd(1);
                    yearedit1.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        minusday1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date();
                    dat.setDay(Integer.parseInt(dayedit1.getText()));
                    dat.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    dat.DayRemove(1);
                    dayedit1.setText(String.valueOf(dat.getDay()));
                    mntedit1.setText(String.valueOf(dat.getMnt()));
                    yearedit1.setText(String.valueOf(dat.getYear()));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        });

        minusmnt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();
                    dat.setDay(Integer.parseInt(dayedit1.getText()));
                    dat.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    dat.MonthRemove(1);
                    dayedit1.setText(String.valueOf(dat.getDay()));
                    mntedit1.setText(String.valueOf(dat.getMnt()));
                    yearedit1.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        minusyear1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    library.date.Date dat = new Date();
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    dat.YearRemove(1);
                    yearedit1.setText(String.valueOf(dat.getYear()));
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        });

        dts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date();
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    StrEdit.setText(dat.DateToString());
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });

        dts1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date();
                    dat.setDay(Integer.parseInt(dayedit1.getText()));
                    dat.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat.setYear(Integer.parseInt(yearedit1.getText()));
                    StrEdit1.setText(dat.DateToString());
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });

        sumbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date(), dat1 = new Date();
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat1.setDay(Integer.parseInt(dayedit1.getText()));
                    dat1.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat1.setYear(Integer.parseInt(yearedit1.getText()));
                    SDEdit.setText(dat.sum(dat1).DateToString());
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });

        diffbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    library.date.Date dat = new Date(), dat1 = new Date();
                    dat.setDay(Integer.parseInt(dayedit.getText()));
                    dat.setMnt(Integer.parseInt(mntedit.getText()));
                    dat.setYear(Integer.parseInt(yearedit.getText()));
                    dat1.setDay(Integer.parseInt(dayedit1.getText()));
                    dat1.setMnt(Integer.parseInt(mntedit1.getText()));
                    dat1.setYear(Integer.parseInt(yearedit1.getText()));
                    SDEdit.setText(dat.diff(dat1).DateToString());
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        });

    }

}
