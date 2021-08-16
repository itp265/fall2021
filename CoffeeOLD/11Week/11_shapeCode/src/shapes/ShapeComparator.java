package shapes;

import java.util.Comparator;

public class ShapeComparator<T> implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		//first order by TYPE of shape
		int num = o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
		if(num == 0) {
			double diff = o1.calculateArea() - o2.calculateArea();
			if(diff > 0) {
				num = 1;
			}
			else if (diff < 0) {
				num = -1;
			}
			else {
				num = o1.getColor().compareTo(o2.getColor());
			}
		}
		// TODO Auto-generated method stub
		return num;
	}

}
