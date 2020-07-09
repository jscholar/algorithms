class Solution:
    def luckyNumbers (self, mat):
        lucky = []
        
        row_min = [min(row) for row in mat]
        col_max = [max([row[j] for row in mat]) for j in range(len(mat[0]))]
        
        for i in range(len(mat)):
            for j in range(len(mat[i])):
                curr = mat[i][j]
                if (curr == row_min[i] and curr == col_max[j]):
                    lucky.append(curr)
        return lucky