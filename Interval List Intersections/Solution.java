class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int a = 0;
        int b = 0;
        List<int[]> intersections = new ArrayList();
        while (a < A.length && b < B.length) {
            // Add intersection if exists
            int[] intersection = findIntersection(A[a], B[b]);
            if (intersection != null) {
                intersections.add(intersection);
            }
            
            // Increment index of interval with smaller upper bound.
            if (A[a][1] < B[b][1]) {
                a++;
            } else {
                b++;
            }
        }
        return intersections.toArray(new int[intersections.size()][2]);
    }
    
    private int[] findIntersection(int[] a, int[] b) {
        int[] intersection = new int[2];
        intersection[0] = Math.max(a[0], b[0]);
        intersection[1] = Math.min(a[1], b[1]);
        if (intersection[1] < intersection[0]) {
            return null;
        } else {
            return intersection;
        }
    }
}