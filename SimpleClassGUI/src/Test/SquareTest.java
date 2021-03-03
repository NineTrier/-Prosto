//Михалева Елизавета ИВТ-19
//Unit Тест для класса Square
package Test;

import org.junit.Assert;
import org.junit.Test;
import sample.Square;

import java.io.IOException;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void setAll() throws IOException {
        sample.Square sqr = new Square();
        sqr.setAll(5,4,0,4,0,-1);
        Assert.assertEquals(5,sqr.getX(),0.0000001);
        Assert.assertEquals(4,sqr.getY(),0.0000001);
        Assert.assertEquals(0,sqr.getX1(),0.0000001);
        Assert.assertEquals(4,sqr.getY1(),0.0000001);
        Assert.assertEquals(0,sqr.getX2(),0.0000001);
        Assert.assertEquals(-1,sqr.getY2(),0.0000001);
    }

    @Test
    public void perimeter() throws IOException {
        sample.Square sqr = new Square();
        sqr.setAll(5,4,0,4,0,-1);
        Assert.assertEquals(20,sqr.perimeter(),0.0000001);
    }

    @Test
    public void area() throws IOException {
        sample.Square sqr = new Square();
        sqr.setAll(5,4,0,4,0,-1);
        Assert.assertEquals(25,sqr.area(),0.0000001);
    }
}