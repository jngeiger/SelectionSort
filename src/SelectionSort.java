import java.util.Arrays;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> {
    public static void main(String[] args)
    { }
    private void selectionSort(List<T> list) {
        for (int i = list.size()-1; i >= 0; i--)
        {
            int highestIdx = 0;
            T highest = list.get(0);
            for (int j = i; j >= 0; j--)
            {
                if (list.get(j).compareTo(highest) > 0)
                {
                    highest = list.get(j);
                    highestIdx = j;
                }
            }
            swapAtIndex(list,i,highestIdx);
        }
    }
    public void selectionSortRec(List<T> list)
    {
        selectionSortRecCall(list,0,list.size()-1);
    }
    public void selectionSortRecCall(List<T> list, int l, int r)
    {
        if (l == r)
            return;
        int result = insertionGoingUp(list,l,r,0);
        swapAtIndex(list,result,r);
        selectionSortRecCall(list,l,r-1);
    }
    public int insertionGoingUp(List<T> list, int l, int r, int max)
    {
        if (l > r)
        {
            return max;
        }
        if (list.get(l).compareTo(list.get(max)) > 0)
        {
            max = l;
        }
        return insertionGoingUp(list,l+1,r,max);
    }
    private void swapAtIndex(List<T> list, int one, int two)
    {
        T temp = list.get(one);
        list.set(one,list.get(two));
        list.set(two,temp);
    }
}
