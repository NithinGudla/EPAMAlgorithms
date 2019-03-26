package nithin;

import java.util.*;

class DescendingWeights{
    
    public List<Integer> solve(int N, int K, int a[]){
       int temp;
       List<Data> myList = new ArrayList<Data>();
       for (int i=0; i<N; i++)
           myList.add(new Data(a[i], a[i] % K));
       Collections.sort(myList);
       List<Integer> finalList = new ArrayList<>();
       for(Data x: myList)
        finalList.add(x.value);
       
       return finalList;
    }
}

class Data implements Comparable{
    int value;
    int weight;
    Data(int value, int weight)
    {
        this.value = value;
        this.weight = weight;
    }
    
    public int compareTo(Object input)
    {
        Data data = (Data) input;
        if(weight != data.weight)
            return data.weight - weight;
        else
            return value - data.value;
    }
}
