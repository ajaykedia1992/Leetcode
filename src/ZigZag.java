
public class ZigZag {

	public static void main(String args[]) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}
	
	public static String convert(String s, int numRows) {
		if (numRows == 1 || s == null || s.length() == 0) {
			return s;
		}
		String[] row = new String[numRows];
		
		row = defaultString(row);

		int step = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			row[step] += ""+s.charAt(i);
			
			if(step == numRows - 1) {
				flag = true;
			}
			else if(step == 0){
				flag = false;
			}
			if(flag) {
				step--;
			}else {
				step++;
			}
		
			
		}
		StringBuffer result = new StringBuffer("");
		for(int i = 0; i<row.length; i++) {
			result.append(row[i]);
		}
		
		return result.toString();
	}

	private static String[] defaultString(String[] row) {
		for(int i = 0; i<row.length; i++) {
			row[i] = "";
		}
		return row;
	}
}
