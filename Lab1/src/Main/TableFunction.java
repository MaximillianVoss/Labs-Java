package Main;

import java.util.*;

import static java.lang.Math.abs;

/**
 * Created by Александр on 27.03.2017.
 */
public class TableFunction {
    private TreeMap<Double, Double> table = new TreeMap<Double, Double>();

    public void Add(double x, double y) {
        table.put(x, y);
    }

    public void Remove(double x, double y) {
        table.remove(x, y);
    }

    private void Print(Map.Entry item) {
        System.out.println("x:" + item.getKey() + " y:" + item.getValue());
    }

    //поиск ближайшего по ключу
    public Map.Entry Get(double x) {
        if (table.floorEntry(x) != null)
            return table.floorEntry(x);
        else
            return table.ceilingEntry(x);

    }

    public MEntry InterPolation(double x) {
        Map.Entry before = Get(x - Math.ulp(x));
        Map.Entry after = table.ceilingEntry(x +  Math.ulp(x));
        if (before != null && after != null) {
            double x0 = (double) before.getKey(), y0 = (double) before.getValue();
            double x1 = (double) after.getKey(), y1 = (double) after.getValue();
            if ((x1 - x0) != 0)
                return new MEntry(x, y0 + ((y1 - y0) / (x1 - x0)) * (x - x0));
            else
                return null;
        }
        return null;
    }

    /**
     * Created by Александр on 13.04.2017.
     */
    public static class Points {
        ArrayList<Point> points = new ArrayList<>();
        public void Add(double x,double y)
        {
            points.add(new Point(x,y));
        }
        public void Add(Point p)
        {
            points.add(p);
        }
        public void Remove(int index)
        {
            points.remove(index);
        }
        public void RemoveAll()
        {
            points.removeAll(points);
        }
        public HashMap<Double,Double> GetPoints()
        {
            HashMap<Double,Double> res= new HashMap<>();
            for(Point point: points)
                res.put(point.x,point.y);
            return res;
        }
        public Point Get(double x)
        {
            Map<Double,Double> map= GetPoints();
            if(map.containsKey(x))
                return new Point(x, map.get(x));
            else
               return null;
        }
        public Point Find(double x)
        {
            if(points.size()>0)
            {
                double dif =abs(points.get(0).x-x);
                Point res = points.get(0);
                for(int i =0;i<points.size();i++)
                {
                    if(dif>abs(points.get(i).x-x))
                    {
                        dif=abs(points.get(i).x-x);
                        res = points.get(i);
                    }
                }
                return res;
            }
            else
                return null;
        }
        public Point InterPolation(double x)
        {
            if(points.size()>1) {
                Point before = null , after = null;
                for(double i=x;i>=points.get(0).x;i-=0.1) {before = Get(Math.round(i));if (before != null && before.x <x) break;}
                for(double i=x;i<=points.get(points.size()-1).x;i+=0.1) {after = Get(Math.round(i));if(after!=null && after.x>x)break;}
                if (before != null && after != null) {
                        double x0 = before.x, y0 = before.y,x1 = after.x, y1 = after.y;
                        return  new Point(x,y0 + ((y1 - y0) / (x1 - x0)) * (x - x0));
                    }
                }
            return null;
        }
        public  void Print()
        {
            for(int i=0;i<points.size();i++)
                 points.get(i).Print();
        }

    }
}

