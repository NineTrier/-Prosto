//Михалева Елизавета ИВТ-19
//Класс - квадрат
package sample;

import java.io.IOException;

public class Square {
    double x,y,x1,y1,x2,y2,x3,y3;//Всего три точки, по ним находится 3-ья, также и будет проверяться квадрат на существование

    public Square(){//Конструктор без параметра
        x=0;
        y=0;
        x1=0;
        y1=0;
        x2=0;
        y2=0;
        x3=0;
        y3=0;
    }

    public Square(double _x,double _y,double _x1, double _y1,double _x2,double _y2)throws IOException{//Конструктор с параметрами
        setAll(_x,_y,_x1,_y1,_x2,_y2);
    }

    public void setAll(double _x, double _y,double _x1, double _y1, double _x2, double _y2) throws IOException {//Сеттер всех точек сразу. Вызывает исключение InputOutput если не выполнится условие существованияя квадрата.
        x=_x;
        y=_y;
        x1=_x1;
        y1=_y1;
        x2=_x2;
        y2=_y2;
        x3=(x+x2)-x1;
        y3=(y+y2)-y1;
        if(((Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2))-Math.sqrt(Math.pow(x3-x,2)+Math.pow(y3-y,2)))>0.0000001)||(Math.sqrt(Math.pow(x2-x,2)+Math.pow(y2-y,2))-(Math.sqrt(Math.pow(x3-x,2)+Math.pow(y3-y,2))*Math.sqrt(2))>0.0000001))throw new IOException("Square doesn't exist");
    }
    public double getX() {//Геттеры
        return x;
    }
    public double getY(){
        return y;
    }
    public double getX1() {
        return x1;
    }
    public double getY1() {
        return y1;
    }
    public double getX2(){
        return x2;
    }
    public double getY2() {
        return y2;
    }
    public double getX3(){
        return x3;
    }
    public double getY3(){
        return y3;
    }

    public double perimeter()throws IOException{//Вычисляет периметр данного треугольника
        double a,p;//a-сторона квадрата
        a=Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
        if(a-0<0.0000001) throw new IOException("Square doesn't exist");
        p=a*4;
        return p;
    }

    public double area()throws IOException {//Вычисляет площадь треугольника. Площадь будем искать через высоту и прямую, которой высота была проведена
        double a, s;//a-сторона квадрата
        a = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
        if (a - 0 < 0.0000001) throw new IOException("Square doesn't exist");
        s = a * a;
        return s;
    }
}
