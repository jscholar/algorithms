const merge = (intervals) => {
  if (intervals.length === 0) {
    return [];
  }
  
  // Sort the intervals by lowerBound (increasing)
  intervals.sort(([a,], [b,]) => a - b);
  
  // Create our mergedIntervals structure
  // Prepoluate merged with the first interval.
  const merged = [intervals[0]];
  
  
  // Iterate over intervals
  for (let i = 1; i < intervals.length; i++) {
    // Check if the next interval merges with the last merged interval
    const [, upperBound] = merged[merged.length - 1];
    const [lowerBound, newUpperBound] = intervals[i];
    
    // Compare the new minimum with the last maximum of our merged interval
    if (lowerBound <= upperBound) {
      merged[merged.length - 1][1] = Math.max(upperBound, newUpperBound);
    } else {
      // If not overlapping, start a new interval
      merged.push(intervals[i]);
    }
    
  }
  return merged;
}
