package leetcode.editor.cn;

//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
//
// 实现 MyHashMap 类： 
//
// 
// MyHashMap() 用空映射初始化对象 
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。 
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= key, value <= 106 
// 最多调用 104 次 put、get 和 remove 方法 
// 
//
// 
//
// 进阶：你能否不使用内置的 HashMap 库解决此问题？ 
// Related Topics 设计 哈希表 
// 👍 198 👎 0

public class DesignHashmap{
    public static void main(String[] args) {
        // Solution solution = new DesignHashmap().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {
    public static final int CAPCITY = 2069;
    class Node{
        private int key;
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Node[CAPCITY];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        if(table[index] == null){
            Node newNode = new Node(key, value);
            table[index] = newNode;
        }else{
            Node head = table[index];
            boolean inTable = false;
            do{
                if(key == head.key){
                    // key相同替换值
                    head.value = value;
                    inTable = true;
                    break;
                }
                head = head.next;
            }while (head != null);
            if(!inTable){
                Node newNode = new Node(key, value);
                newNode.next = table[index].next;
                table[index].next = newNode;
            }
        }

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        if(table[index] == null){
            return -1;
        }else{
            Node head = table[index];
            do{
                if(key == head.key){
                    return head.value;
                }
                head = head.next;
            }while (head != null);
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        if(table[index] != null) {
            Node head = table[index];
            if (head.key == key){
                table[index] = head.next;
            }
            for (Node curr=head.next; curr!=null;curr=curr.next,head=head.next){
                if(curr.key == key){
                    head.next = curr.next;
                    return;
                }
            }
        }
    }
     public int hash(int key){
        return key % CAPCITY;
     }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}