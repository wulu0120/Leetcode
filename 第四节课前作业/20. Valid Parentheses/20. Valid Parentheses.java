class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        
        Stack<Character> charStack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(charMap.containsKey(c)){   // 有char, pop第一位, 比较是不是左半边
                char topChar = charStack.empty() ? '*' : charStack.pop();
                if(topChar != charMap.get(c)){
                    return false;   // 不相等, 直接false
                }   
            }else{
                charStack.push(c);   // stack没有这个char, push入栈
            }
        }
        return charStack.isEmpty();  // 空的说明对称, 不空说明不对
    }
}