class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // 找max, 相当于找剩余card的sum最小
        int totalScore = 0;
        for(int i: cardPoints){
            totalScore += i;
        }
        if(k == cardPoints.length) return totalScore;
        
        int minScore = totalScore, currentScore = 0;
        int startIndex = 0;
        int remainLength = cardPoints.length - k;
        
        for(int i = 0; i < cardPoints.length; i++){
            currentScore += cardPoints[i]; // 向后扩大窗口
            
            // 判断窗口是否达到指定值
            int currentLength = i - startIndex + 1;
            if(currentLength == remainLength){
                minScore = Math.min(minScore, currentScore);
                currentScore -= cardPoints[startIndex++];    // startIndex往后挪, 判断下一组窗口
            } 
        }
        return totalScore - minScore;
    }
}