#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>

class MaximumSubarray
{
public:
    static int maxSubArray(std::vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        int max_subarray = nums[0];
        // Iterate over nums
        int prev = nums[0];
        for (int i = 1 ; i < nums.size(); ++i) {
            int cur = nums[i];
            max_subarray = std::max(max_subarray, std::max(cur, cur + prev));
            prev = std::max(cur, cur + prev);
        }

        return max_subarray;
    }
};

int main() {
    
    std::vector<int> nums {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    std::cout << MaximumSubarray::maxSubArray(nums);

    return 0;
}