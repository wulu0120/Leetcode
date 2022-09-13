class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length-1;
        while(left+1 < right){
            int mid = left + (right - left) / 2;
            int missingNum = arr[mid] - mid - 1;   // Missing # = prevPos - currPos
            
            if(missingNum < k){     // < k -> mid 左边都不符合, 要扩大
                left = mid;
            }
            else{
                right = mid;     // mid 右边都不符合，要缩小
            }
        }        
        /* 比较具体case: 
          1. right < k 说明比最右边的还大; *****此时肯定比左边的大，所以应先比较right
          2. left < k 说明在left和right中间
          3. 说明比最左边的还小
        */
        if (arr[right] - right - 1 < k){
            return right + k + 1;
        }
        else if(arr[left] - left - 1 < k){
            return left + k + 1;
        }
        else{
            return left + k;
        }
    }
}