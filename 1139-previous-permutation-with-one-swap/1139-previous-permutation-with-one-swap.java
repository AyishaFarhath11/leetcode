class Solution {
    public int[] prevPermOpt1(int[] arr) {
         int i = arr.length - 2, max_ = -1;
        while(i >= 0 && arr[i] <= arr[i+1])
            --i;
        if(i >= 0){
			max_ = i + 1;
			for(int j=max_ + 1; j < arr.length; ++j)
				if(arr[max_] < arr[j] && arr[j] < arr[i])
					max_ = j;
			int temp = arr[max_];
			arr[max_] = arr[i];
			arr[i] = temp;
		}
        return arr;
    }
}