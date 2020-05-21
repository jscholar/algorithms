class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        r, f = 8, 8;
        board = [[False for x in range(r)] for y in range(f)]
        result = [];
        for queen in queens:
            board[queen[0]][queen[1]] = True;
        
        for x in [-1, 0, 1]:
            for y in [-1, 0, 1]:
                for d in range(1, 8):
                    qx = king[0] + (x * d);
                    qy = king[1] + (y * d);
                    if qx < 0 or qy < 0 or qx >= 8 or qy >= 8:
                        break;
                    if x == 0 and y == 0:
                        break;
                    if board[qx][qy]:
                        result.append([qx, qy]);
                        break;
        
        return result;