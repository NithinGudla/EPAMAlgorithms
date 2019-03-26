package nithin;

import java.util.*;

public class GlowingBulbs {
	
	public int findBulb(String switches, int k) {
		
		List<Integer> resultSet = new ArrayList<>();
		List<Integer> onSwitches = new ArrayList<>();
		for(int i = 0; i < switches.length(); i++)
			if(switches.charAt(i) == '1')
				onSwitches.add(i+1);
		int max = onSwitches.get(0) * k;
		for(int x : onSwitches)
			for(int p = 1; p * x <= max; p++)
				resultSet.add(p * x);	
		TreeSet<Integer> treeSet = new TreeSet<>();
		for(int temp : resultSet)
			treeSet.add(temp);
		while(k-->1)
			treeSet.pollFirst();
		
		return treeSet.pollFirst();
	}
}
