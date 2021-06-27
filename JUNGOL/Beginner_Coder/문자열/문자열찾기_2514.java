import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_문자열찾기_2514 {

	public static void main(String[] args) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] cArr = br.readLine().toCharArray();
		
		int kSum = 0, iSum = 0;
		int len = cArr.length;
		for(int i = 0; i < len-2; i++) {
			if(cArr[i] == 'K' && cArr[i+1] == 'O' && cArr[i+2] == 'I') kSum++;
			if(cArr[i] == 'I' && cArr[i+1] == 'O' && cArr[i+2] == 'I') iSum++;
		}
		
		System.out.println(kSum);
		System.out.println(iSum);
	}

}
