from typing import List

"""
Rotate matrix both clockwise and counterclockwise.

Both operations are done in place.
"""
class RotateImage:
    
    # Rotate matrix counter clockwise
    def rotateCounterClockwise(self, matrix: List[List[int]]) -> None:
        n = len(matrix[0])
        for i in range (n // 2):
            for j in range (i, n - i - 1):
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][n - i - 1]
                matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1]
                matrix[n - i - 1][n - j - 1] = matrix[n - j - 1][i]
                matrix[n - j - 1][i] = temp


    # Rotate matrix clockwise
    def rotateClockwise(self, matrix: List[List[int]]) -> None:
        n = len(matrix[0])
        for i in range (n // 2):
            for j in range(i, n - i - 1):
                temp = matrix[i][j] 
                matrix[i][j] = matrix[n - 1 - j][i] 
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j] 
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i] 
                matrix[j][n - 1 - i] = temp 




matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

o = RotateImage()

for row in matrix:
    print(row)

print("--------------")

o.rotateClockwise(matrix)

for row in matrix:
    print(row)
