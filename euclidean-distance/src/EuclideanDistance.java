
import java.text.DecimalFormat;

public class EuclideanDistance {
	private static DecimalFormat df = new DecimalFormat("0.00");
	private static String first ="(2, 10); (2, 5); (8, 4); (5, 8); (7, 5); (6, 4); (1, 2); (4, 9)";
	private static String second ="(2, 10); (2, 5); (8, 4); (5, 8); (7, 5); (6, 4); (1, 2); (4, 9)";

	public static void main(String[] args) {
		String[] first_array = first.split(";");
		String[] second_array = second.split(";");
		for(int i=0;i<first_array.length;i++)
		{
			System.out.println(">>>> All Distances from :" + first_array[i].trim());
			for(int j=0;j<second_array.length;j++)
			{
				String first_element=first_array[i];
				String second_element=second_array[j];
				first_element=first_element.trim();
				second_element=second_element.trim();
				double x1=getPoint(0,first_element);
				double y1=getPoint(1,first_element);
				double x2=getPoint(0,second_element);
				double y2=getPoint(1,second_element);
				String eucDistance=calculateDistanceBetweenPoints(x1,y1,x2,y2);
				System.out.println("Distance:" + first_element + " - " + second_element + "= " + eucDistance);
			}
			System.out.println();
		}
		System.out.println(" --- End  ---");

	}

	public static String calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2) {
		return df.format(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
	}
	
	public static double getPoint(int position, String point)
	{
		String result="";
		String pointEdit="";
		pointEdit=point.split(",")[position].trim();
		if(position==0)
			result=String.valueOf(pointEdit.split("\\(")[1]);
		else if(position==1)
			result=String.valueOf(pointEdit.split("\\)")[0]);
		return Double.parseDouble(result);
	}
	
}
