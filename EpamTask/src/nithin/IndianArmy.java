package nithin;
import java.util.*;

class IndianArmy {
	
	public long calculateUnsafeDistance(int noOfCheckPoints, long S, long E, long checkPoints[], long armyStrength[]) {
		
		long unsafeDistance = 0;

		for(int i = 0; i < checkPoints.length; i++)
			for(int j = i+1; j < checkPoints.length; j++)
				if(checkPoints[i]>checkPoints[j])
				{
					long temp = checkPoints[i];
					checkPoints[i] = checkPoints[j];
					checkPoints[j] = temp;
					temp = armyStrength[i];
					armyStrength[i] = armyStrength [j];
					armyStrength[j] = temp;
				}

		List<Long> checkMinimum = new ArrayList<>();
		List<Long> checkMaximum = new ArrayList<>();

		for(int i=0; i<checkPoints.length; i++)
		{
			checkMinimum.add(checkPoints[i]-armyStrength[i]);
			checkMaximum.add(checkPoints[i]+armyStrength[i]);
		}
		
		int indexRequiredFrom = getFromIndex(checkPoints,S);
		int indexRequiredTo = getToIndex(checkPoints,E);
		
		if(indexRequiredFrom > noOfCheckPoints -1)
		{
			long tempMax = maxOfList(checkMaximum, 0, noOfCheckPoints - 1);
			if(S > tempMax)
				unsafeDistance += E - S;
			else
			if(E > tempMax)
				unsafeDistance += E - tempMax;

			return unsafeDistance;
		}
		else
		if(indexRequiredTo == 0)
		{
			long tempMin;
			tempMin = minOfList(checkMinimum, 0, noOfCheckPoints - 1);
			if(tempMin > E)
				unsafeDistance += E - S;
			else
			if(tempMin > S)
				unsafeDistance += tempMin - S;
			return unsafeDistance;

		}

		for(int i=indexRequiredFrom; i <= indexRequiredTo; i++)
		{	
			long tempMin=0;
			long tempMax=0;
			int j=i;
			if(i==indexRequiredFrom)
			{
				if(indexRequiredFrom!=0)
				{
					tempMax = maxOfList(checkMaximum, 0, indexRequiredFrom - 1);
					tempMin = minOfList(checkMinimum, indexRequiredFrom, checkPoints.length-1);

					if(S >= tempMax)
					{
						if(tempMin > S)
							unsafeDistance += tempMin -S;
					}
					else
					if(tempMin > tempMax)
					{
						unsafeDistance += tempMin - tempMax;
					}
					
				}
				else
				{
					
					tempMin = minOfList(checkMinimum, 0, noOfCheckPoints-1);
					
					if(tempMin > S)
					{
						unsafeDistance += tempMin - S;
						
					}
				}
			}
			else
			if(i==indexRequiredTo)
			{
				if(indexRequiredTo != noOfCheckPoints -1)
				{
					tempMax = maxOfList(checkMaximum, 0, indexRequiredTo - 1);
					tempMin = minOfList(checkMinimum, indexRequiredTo, noOfCheckPoints - 1);
					if(tempMin > tempMax)
						unsafeDistance += tempMin - tempMax;
				}
				else
				{
					tempMax = maxOfList(checkMaximum, 0, noOfCheckPoints - 2);
					tempMin = checkMinimum.get(noOfCheckPoints - 1);
					if(tempMin > tempMax)
						unsafeDistance += tempMin - tempMax;
				}
			}
			else
			{
				tempMax = maxOfList(checkMaximum, 0, i -1);
				tempMin = minOfList(checkMinimum, i, noOfCheckPoints - 1);
				
				if(tempMin > tempMax)
					unsafeDistance += tempMin - tempMax;
			}
		}

		if(indexRequiredTo != noOfCheckPoints -1)
				{
					
					long tempMax = maxOfList(checkMaximum, 0, indexRequiredTo);
					long tempMin = minOfList(checkMinimum, indexRequiredTo + 1, noOfCheckPoints - 1);
					
					if(E < tempMin)
					{
						if(E > tempMax)
							unsafeDistance += E - tempMax;
					}
					else
					{
						if(tempMin > tempMax)
							unsafeDistance += tempMin - tempMax;
					}	
				}
				else
				{
					
					
					long tempMax = maxOfList(checkMaximum, 0, noOfCheckPoints - 1);
					
					if(E > tempMax)
						unsafeDistance += E - tempMax;
				}
		
		return unsafeDistance;
	}
	
	long maxOfList(List<Long> tempArray, int beginIndex, int endIndex)
	{
		long tempMax=0;
		if(beginIndex<=endIndex)
		tempMax=tempArray.get(beginIndex);
		for(int i = beginIndex+1; i<= endIndex; i++ )
		{
			if(tempArray.get(i) > tempMax)
				tempMax = tempArray.get(i);
		}
		
		return tempMax;
	}
	
	long minOfList(List<Long> tempArray, int beginIndex, int endIndex)
	{
		long tempMin=0;
		if(beginIndex <= endIndex)
		tempMin=tempArray.get(beginIndex);
		for(int i = beginIndex+1; i<= endIndex; i++ )
		{
			if(tempArray.get(i) < tempMin)
				tempMin = tempArray.get(i);
		}
		
		return tempMin;
	}
	int getFromIndex(long checkPoints[],long S)
	{
		int indexRequiredFrom = checkPoints.length;
		for(int i=0; i < checkPoints.length; i++)
		{
			if(S < checkPoints[i])
			{
				indexRequiredFrom = i;
				break;
			}
				
		}
		return indexRequiredFrom;
		
	}
	int getToIndex(long checkPoints[],long E)
	{
		int indexRequiredTo = 0;
		for(int i = checkPoints.length -1; i >= 0; i--)
		{
			if(E > checkPoints[i])
			{
				indexRequiredTo = i;
				break;
			}
				
		}
		
		return indexRequiredTo;
	}

}