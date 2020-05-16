#include <iostream>
#include <vector>

class HouseRobber
{

public:
    static int rob(std::vector<int>& nums) {
        int n = nums.size();
        
        if (n == 4) {
            if (nums[0] + nums[3] > nums[1] + nums[3] || 
                nums[0] + nums[3] > nums[0] + nums[2]) {
                return nums[0] + nums[3];
            }
        }

        int profitOdd = 0;
        int profitEven = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                profitEven += nums[i];
            }else{
                profitOdd += nums[i];
            }
        }

        if (profitEven > profitOdd) {
            return profitEven;
        }
        return profitOdd;
    }

};

int main() {

    std::vector<int> nums {1, 2, 3, 1};
    std::cout << HouseRobber::rob(nums);

    return 0;
}