class Solution {
    public String minRemoveToMakeValid(String s) {
        /*  = String not end =
         1. empty: )-> remove string 对应的index
                   ( -> push index到stack
         2. not empty: ) -> pop stack
                       ( -> push index 到 stack
         = String to end =
         Delete all String index in stack */

        Stack<Integer> stack = new Stack<>();
        Set<Integer> deleteSet = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){            
                if(c == '('){
                    stack.push(i);
                }else if(c == ')'){
                    deleteSet.add(i);
                }
            }else{
                if(c == '('){
                    stack.push(i);
                }else if(c == ')'){
                    stack.pop();
                }
            }   
        }
        while(!stack.isEmpty()){
            deleteSet.add(stack.pop());
        }
        // 如果不在deleteSet里, 加到stringbuilder
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!deleteSet.contains(i)){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}