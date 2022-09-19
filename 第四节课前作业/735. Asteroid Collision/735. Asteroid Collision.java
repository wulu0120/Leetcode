class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();
        for(int i: asteroids){
            collision: {
                while(!res.isEmpty() && i < 0 && res.peek() > 0){  // 继续查看下一个             
                    // 判断大小
                    if(res.peek() < -i){
                        res.pop();   // 上一个被撞掉
                        continue;
                    }
                    else if(res.peek() == -i){
                        res.pop();    // 相等, 都撞掉
                    }
                    break collision;  // 上一个大, 解除碰撞, 不push, 直接到下一个
                }
                res.push(i); // 不符合碰撞条件, 直接push      
            }
           
        }
        int[] ans = new int[res.size()];
        for(int j = ans.length-1; j >= 0; j--){
            ans[j] = res.pop();
        }
        return ans;
    }
}