package LRUCache;

import java.util.Hashtable;

/**
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    class DoubledLinkedListNode {
        int key;
        int value;
        DoubledLinkedListNode pre, next;

        DoubledLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        DoubledLinkedListNode() {
            this.key = 0;
            this.value = 0;
        }
    }

    private final Hashtable<Integer, DoubledLinkedListNode> cache = new Hashtable<>();
    private final int capacity;

    private int count;
    private DoubledLinkedListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new DoubledLinkedListNode();
        tail = new DoubledLinkedListNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubledLinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubledLinkedListNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            DoubledLinkedListNode newNode = new DoubledLinkedListNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);

            ++count;
            if (count > capacity) {
                DoubledLinkedListNode tail = popTail();
                cache.remove(tail.key);
                --count;
            }
        }
    }

    private DoubledLinkedListNode popTail() {
        DoubledLinkedListNode lastNode = tail.pre;
        removeNode(lastNode);
        return lastNode;
    }

    private void removeNode(DoubledLinkedListNode node) {
        DoubledLinkedListNode preNode = node.pre;
        DoubledLinkedListNode nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void moveToHead(DoubledLinkedListNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(DoubledLinkedListNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }
}
