/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    if (capacity <= 0) {
        return null;
    }
    this.capacity = capacity;
    this.cached = new Map();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (!this.cached.has(key)) {
        return -1;
    }
    
    const value = this.cached.get(key);
    this.cached.delete(key);
    this.cached.set(key, value);
    
    return value;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    this.cached.delete(key);
    this.cached.set(key, value);
    if (this.cached.size > this.capacity) {
        for (let key of this.cached.keys()) {
            this.cached.delete(key);
            return;
        }
    }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */