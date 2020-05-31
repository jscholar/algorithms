from math import floor;

# Observations:
#   We know that (M, F) must have been a result of either
#   (M + F, F) or (M, F + M)
#
#   If F > M, then the previous generation must have been (M, F - M)
#   If M > F, then the previous generation must have been (M - F, F)
#
#   If M and F are equivalent, then the result is impossible

def solution(M, F):
    M, F = int(M), int(F);
    if (F > M):
        M, F = F, M;
    gens = 0;
    while (F != 1):
        if (M <= 0 or F <= 0):
            return "impossible";
        gens += int(floor(M / F));
        M, F = F, M % F;
    gens += M - F;
    return str(gens);