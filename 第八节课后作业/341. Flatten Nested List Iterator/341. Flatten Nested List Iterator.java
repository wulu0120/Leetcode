/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    private ArrayList<Integer> res = new ArrayList<>();
    private int posPtr = 0;     // pointer
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatListHelper(nestedList);
    }
    
    private void flatListHelper(List<NestedInteger> nestedList) {
        for (NestedInteger ele: nestedList) {
            if (ele.isInteger()) {
                res.add(ele.getInteger());     // 是数字, 直接加进array
            }
            else {
                flatListHelper(ele.getList());  // 是list, 调用本身, 拆分该list
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return res.get(posPtr++);    // 返回当前int, 并将pointer往后移
    }

    @Override
    public boolean hasNext() {
        return posPtr < res.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */