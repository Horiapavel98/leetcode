from typing import List

"""
Count all the possible ways of climbing stairs
using either 1 or 2 steps at a time.
"""
class ClimbingStairs:
    
    # Climbing stairs recursive method
    # Initial method does not work
    # Requires memorisation
    """
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            return self.climbStairs(n - 1) + self.climbStairs(n - 2)

    """

    def recursiveHelper(self, n: int, mem) -> int:
        if n <= len(mem):
            return mem[n - 1]
        else:
            tmp = self.recursiveHelper(n - 1, mem) + self.recursiveHelper(n - 2, mem)
            mem.append(tmp)
            return tmp

    def climbStairs(self, n: int) -> int:
        return self.recursiveHelper(n, [1, 2])

    # Faster variant: iteratively
    def climbStairsIteratively(self, n: int) -> int:
        if n==1:
            return 1
        elif n==2:
            return 2
        a,b = 1,2
        for i in range(2, n):
            temp = a+b
            a, b = b, temp
        return temp


obj = ClimbingStairs()
print(obj.climbStairs(5))