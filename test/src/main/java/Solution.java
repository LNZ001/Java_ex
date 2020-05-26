import javax.xml.stream.FactoryConfigurationError;
import java.util.*;


class Point {
  int x;
  int y;

    public Point(int i, int j) {
        x=i;
        y=j;
    }
}


class Solution {
    public static void main(String[] args){
        Point[] points = {new Point(2,3), new Point(3,3), new Point(-5,3)};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points){
        if (points == null ){
            return 0;
        }
        if (points.length <= 2){
            return points.length;
        }

        int result = 0;
        for (int i=0; i<=points.length; i++){
            int dup = 1;
            int max = 0;
            HashMap map = new HashMap();
            for (int j = i+1; j< points.length; j++){
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x==0 && y==0){
                    dup++;
                    continue;
                }

                HashMap tmp_map = new HashMap();
                int d = gcd(x, y);
                tmp_map.put(x/d, y/d);
                map.put(tmp_map, (int)map.getOrDefault(tmp_map, 0)+1);

                max = Math.max(max, (int)map.get(tmp_map));
            }

            result = Math.max(result, max+dup);
        }
        return result;
    }



    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}