import java.util.HashMap;
import java.util.Map;

// 双向链表
class ListNode{
    int key;
    int value;
    ListNode pre;
    ListNode next;

}


//class LRUCache {
//
//    private int capacity;
//    private Map<Integer, ListNode> cache;
//
//    private ListNode protectHead = new ListNode();
//    private ListNode protectTail = new ListNode();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        cache = new HashMap<>(capacity);
//        protectHead.next = protectTail;
//        protectTail.pre = protectHead;
//
//    }
//
//    public int get(int key) {
//        if(cache.containsKey(key)){
//            ListNode node = cache.get(key);
//            this.moveToTail(node);
//            return node.value;
//        }else{
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        if(cache.containsKey(key)){
//            ListNode node = cache.get(key);
//            node.value = value;
//            this.moveToTail(node);
//            return;
//        }
//        if(cache.size() == capacity){
//            ListNode node = protectHead.next;
//            this.remove(node);
//            cache.remove(node.key);
//        }
//        ListNode node = new ListNode();
//        node.key = key;
//        node.value = value;
//        this.addToTail(node);
//        cache.put(key, node);
//    }
//
//    private void addToTail(ListNode node){
//        protectTail.pre.next = node;
//        node.pre = protectTail.pre;
//        node.next = protectTail;
//        protectTail.pre = node;
//    }
//
//    private void remove(ListNode node){
//        node.pre.next = node.next;
//        node.next.pre = node.pre;
//        node.pre = null;
//        node.next = null;
//    }
//
//    private void moveToTail(ListNode node){
//        this.remove(node);
//        this.addToTail(node);
//    }
//}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache {

    private int capacity;
    private Map<Integer, ListNode> cache;
    private ListNode headNode = new ListNode();
    private ListNode tailNode = new ListNode();

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        headNode.next = tailNode;
        tailNode.pre = headNode;
    }

    public void addNodeToTail(ListNode node){
        tailNode.pre.next = node;
        node.pre = tailNode.pre;
        node.next = tailNode;
        tailNode.pre = node;
    }

    public void removeNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    public void moveNodeToTail(ListNode node){
        this.removeNode(node);
        this.addNodeToTail(node);
    }


    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }else{
            ListNode node = cache.get(key);
            this.moveNodeToTail(node);
            return node.value;
        }
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            node.value = value;
            this.moveNodeToTail(node);
            return;
        }
        if(cache.size() == capacity){
            ListNode node = headNode.next;
            this.removeNode(node);
            cache.remove(node.key);
        }
        ListNode node = new ListNode();
        node.key = key;
        node.value = value;
        this.addNodeToTail(node);
        cache.put(key, node);

    }

}