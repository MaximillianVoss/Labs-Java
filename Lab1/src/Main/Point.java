package Main;

/**
 * Created by Александр on 13.04.2017.
 */
public class Point {
    public double x;
    public double y;
    void Print()
    {
        System.out.println("x:"+x+" y:"+ y);
    }
    Point(double _x,double _y)
    {
       y=_y;
       x = _x;
    }
}
