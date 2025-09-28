package project1;

public class versionComp {

	static int versionComp (String s1, String s2) {
		String[] arr1 = s1.split("\\.");
		String[] arr2 = s2.split("\\.");
        System.out.println(arr1.length);
        System.out.println(arr2.length);
        
        int num = 0;
        //102.32.42
        int i = 0;
        while (s1.charAt(i) != '.') {
        num = num *10 + s1.charAt(i) - '0';
        i++;
        
        }
        
        System.out.println("num== " + num);
		
		int count = 0;
		int smaller = Math.min(arr1.length,  arr2.length);
		while (count < arr1.length && count < arr2.length) {
			System.out.println("on loop");
			int int1 = Integer.parseInt(arr1[count]);
			int int2 = Integer.parseInt(arr2[count]);
			
			System.out.println("int1 =" + int1 + "  int2 = " + int2);
			if(int1 > int2)
				return 1;
			else if  (int2  > int1)
				return -1;
			else
				count++;
		}
		//At this point both are equal
		System.out.println("here");
		if (arr1.length == arr2.length)
			return 0;
		// str 2 has more finer version sleg: 1.2.4 and 1.2.4.1
		else if (smaller == arr1.length)
			return -1;
		else
			return 1;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = versionComp("1234.2.40.5.6", "1.2.34");
		System.out.println("result = " + result);

	}

}
