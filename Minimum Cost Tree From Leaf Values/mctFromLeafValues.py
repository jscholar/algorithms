def solution(leaves):
  if (len(leaves) <= 1):
    return 0
  best = 999999999999999999999999999999999999;
  # Iterate through leaves
  for i in range(1, len(leaves)):
    score = 0
    # Try the split at each position, and update best score
    # Find the max values on either side of i
    maxLeft = max(leaves[0:i])
    maxRight = max(leaves[i:])
    # Add product to score
    score += maxLeft * maxRight
    score += solution(leaves[0:i])
    score += solution(leaves[i:])
    # Calculate the best scores for left and right subtrees split by i
    best = min(best, score)
  return best
  
print(solution([6,2,4]))