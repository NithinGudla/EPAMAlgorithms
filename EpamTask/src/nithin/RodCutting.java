package nithin;

public class RodCutting {
	
	public int calculateSpecialRods(int lengthOfRod) {
		
		int count=0;
		for(int j=1 ; j <= lengthOfRod ; j+=2)
        {
            int k = j;
            boolean result = true;
            while(k > 1)
            {
                if(k % 2 == 0)
                {
                    result = false;
                    break;
                }
                
                k /= 2;
            }
            if(result)
                count++;
        }
		return count-1;
	}

}
