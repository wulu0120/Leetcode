class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int w: weights){
            left = Math.max(w, left);
            right += w;
        }
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            int spentDay = countDay(weights, mid);
            if(spentDay <= days){     // 尽可能小
                right = mid;
            }else{
                left = mid;    // 小了, 要大
            }
        }
        if(countDay(weights, left) <= days){
            return left;
        }
        else if(countDay(weights, right) <= days){
            return right;
        }
        return -1;
    }
    
    // helper fun: calculate time spent with given capacity
    private int countDay(int[] weights, int capacity){
        int day = 0, temp = 0;
        for(int w: weights){
            if(temp+w <= capacity){
                temp += w;
            }else{
                day++;
                temp = 0;
                temp += w;
            }
        }
        return day+1;
    }
}