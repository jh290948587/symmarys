package to_offer.sort;

public class MaxSum {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        else{
            int total=array[0],maxSum=array[0];
            for(int i=1;i<array.length;i++){
                if(total>=0)
                    total+=array[i];
                else
                    total=array[i];
                if(total>maxSum)
                    maxSum=total;
            }
            return maxSum;
        }

    }

    public static void main(String[] args) {
        int[] arrays = new int[]{ 1, -2, 3, 10, -4, 7,  2, -5 };
        int sum = new MaxSum().FindGreatestSumOfSubArray(arrays);
        System.out.println(sum);
    }
}
