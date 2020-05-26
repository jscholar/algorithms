from math import floor;

def solution(h, q):
    # Observations:
    #   Nodes contain only values smaller than it (makes sense)
    #   All left children are smaller than all right children (also makes sense)
    #   The children will contain all nodes in range [left < right < root]
    #   We can use this property to binary search through the tree for our value.
    result = [];
    for i in range(len(q)):
        target = q[i];
        parent = -1;
        node = (2 ** h) - 1;
        left = 1;
        right = node;
        while (target < node and node != target):
            parent = node;
            mid = floor((right - left) / 2) + left;
            if (target < mid):
                node = right = mid - 1;
            else:
                node = right = right - 1;
                left = mid;
        result.append(parent)
    
    return result;