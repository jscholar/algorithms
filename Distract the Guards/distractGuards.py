from fractions import gcd;
from math import log;

# Observations:
#     It seems that when the total number of bananas is a power 2, then the game
#     will inevitably end.
#
#     Also observe that the multiples of a game, say 1,3 and 2,6 will play out
#     exactly the same way and will have the same result. They are essentially
#     The same game.

def solution(banana_list):
    # Compute adjacency list
    edges = [[] for x in range(len(banana_list))];
    
    for i in range(len(banana_list)):
      for j in range(i + 1, len(banana_list)):
        if (isInfinite(banana_list[i], banana_list[j])):
          edges[i].append(j);
          edges[j].append(i);

    unmatched = {x for x in range(len(banana_list))};

    notDistracted = 0;
    # Pair the guards with the least connections first
    numEdges = map(lambda edges: len(edges), edges);
    while (len(unmatched)):
      # Find unmatched guard with fewest connections
      fewest = len(banana_list);
      guard1 = -1;
      for guard in unmatched:
        if (numEdges[guard] < fewest):
          fewest = numEdges[guard];
          guard1 = guard;
        
      # Match with guards with fewest connections
      fewest = len(banana_list);
      guard2 = -1;
      for guard in edges[guard1]:
        if (guard in unmatched and numEdges[guard] < fewest):
          fewest = numEdges[guard];
          guard2 = guard;

      unmatched.remove(guard1);
      # Update numEdges
      for guard in edges[guard1]:
        numEdges[guard] -=1;
      
      if (guard2 == -1):
        # No matches for guard1, then guard 1 is not distracted
        notDistracted += 1;
      else:
        # Match guard1 with guard 2
        unmatched.remove(guard2);
        for guard in edges[guard2]:
          numEdges[guard] -=1;

    return notDistracted;

def isInfinite(X, Y):
    # Check if the sum of the game adds up to a power of 2.
    # Or if the game is a multiple of one with a sum of a power of 2.
    scale = gcd(X, Y);
    X, Y = X / scale, Y / scale;
    total = X + Y;
    
    return not log(total, 2).is_integer();

def maximumMatching(graph):
    print('blah')
# Computes a maximal matching for the graph
def maximalMatching(graph):
    print('ha');

print(solution([1,7,3,21,13,19]));