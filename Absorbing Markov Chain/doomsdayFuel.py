from fractions import Fraction, gcd;

def solution(m):

    convertToFractions(m);
    absorbing, transient = getStates(m);

    if (len(absorbing) == 1):
      return [1, 1];

    m = toStandardForm(absorbing, transient, m);

    # We need to calculate the fundamental matrix

    Q = subMatrix(m, [len(absorbing), len(m)], [len(absorbing), len(m)]);
    F = fundamentalMatrix(Q);

    # The product FR gives the limiting matrix, which tells us the chances
    # to end up at any absorbing state from a given state in the long run.
    R = subMatrix(m, [len(absorbing), len(m)], [0, len(absorbing)]);
    FR = matrixMultiply(F, R);

    # The first row in FR will give the probabilities starting at s0
    # Now find the LCM of denominators

    denominators = map(lambda f: f.denominator, FR[0]);
    commonDenominator = lcm(denominators);
    
    numerators = map(lambda f: f.numerator * (commonDenominator / f.denominator), FR[0]);

    return numerators + [commonDenominator];

def convertToFractions(m):
  for i, row in enumerate(m):
    s = sum(row);
    if (s > 0):
      for j, val in enumerate(row):
        _gcd = gcd(val, s);
        row[j] = Fraction(val / _gcd, s / _gcd);
    else:
      for j, val in enumerate(row):
        row[j] = Fraction(1 if i == j else 0, 1);
    
# Returns indexes of transient and absorbing states.
# Requires probability matrix (out of 1.0);
def getStates(m):
    transient = [];
    absorbing = [];
    for i, row in enumerate(m):
      if (isAbsorbing(i, row)):
        absorbing.append(i);
      else:
        transient.append(i);
    return [absorbing, transient];

# i is the state of the row
def isAbsorbing(i, row):
  for j, val in enumerate(row):
    if (i != j and val > 0):
        # Has some probability of entering another state
        return False;
  return True;

# Creates a copy of the markov matrix in standard form
def toStandardForm(absorbing, transient, m):
  standard = [];
  indexMap = absorbing + transient;
  for i in indexMap:
    temp = [];
    for j in range(len(m[i])):
      prevIndex = indexMap[j];
      temp.append(m[i][prevIndex]);
    standard.append(temp);
  return standard;

# Creates a copy of 2D submatrix from specifed ranges
def subMatrix(m, irange, jrange):
  sub = [];
  for i in range(irange[0], irange[1]):
    row = m[i][jrange[0]:jrange[1]];
    sub.append(row);
  return sub;

def fundamentalMatrix(Q):
  # Fundamental Matrix is F = (I - Q)^(-1)
  F = subtractFromIdentity(Q);
  F = invertMatrix(F);
  return F;

# Returns copy of matrix subtracted from identity
def subtractFromIdentity(m):
  result = [];
  for i, row in enumerate(m):
    temp = []
    for j, val in enumerate(row):
      newVal = (1 if i == j else 0) - val;
      temp.append(newVal);
    result.append(temp);
  return result;
  
# Inverts given matrix
def invertMatrix(m):
  # Invert by gaussian elimination
  n = len(m);
  I = identityMatrix(n);
  convertToFractions(I);

  # Perform addition of pivot to from 0's in column
  for j in range(n):
    # Ensure the pivot is non-zero
    if (m[j][j] == 0):
      for k in range(j + 1, n):
        if (m[k][j] != 0):
          swapRows(m, j, k);
          swapRows(I, j, k);
          break;

    for i in range(n):
      if (i != j and m[i][j] != 0):
        # Add scaled pivot value to sum current value to 0 by row addition
        scale = -(m[i][j] / m[j][j]);
        rowAddition(m[j], m[i], scale);
        rowAddition(I[j], I[i], scale);

  # Scale rows so diagonals are 1.0 on original matrix
  for i in range(n):
    scale = 1 / m[i][i];
    for j in range(n):
      m[i][j] *= scale;
      I[i][j] *= scale;

  return I;

# Generates an identity matrix of given size
def identityMatrix(n):
  I = [[0] * n for x in range(n)];
  for i in range(n):
    I[i][i] = 1;
  return I;

# Adds row1 to row2. Accepts optional scaling factor for row1 addend
def rowAddition(row1, row2, scale = 1):
  for i in range(len(row2)):
    row2[i] += row1[i] * scale;

# Swap two rows in a matrix
def swapRows(m, r1, r2):
  m[r1], m[r2] = m[r2], m[r1];

# Calculates and returns product AB
def matrixMultiply(A, B):
  product = [];
  for i in range(len(A)):
    row = [];
    for j in range(len(B[i])):
      val = 0;
      for k in range(len(B)):
        val += A[i][k] * B[k][j];
      row.append(val);
    product.append(row);

  return product;

# Calculate least common multiple of array of positive integers
def lcm(nums):
  curLCM = nums[0];
  for num in nums:
    curLCM = curLCM * num / gcd(curLCM, num);
  return curLCM;
  