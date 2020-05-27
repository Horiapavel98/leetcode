#include <iostream>
#include <vector>
#include <algorithm>
class HouseRobber
{

public:
    static int rob(std::vector<int>& nums) {
        int n = nums.size();

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return std::max(nums[0], nums[1]);
        }

        // Initialize auxiliary array
        int* aux = new int[n];

        aux[0] = nums[0];
        aux[1] = nums[1];

        // Input: 3, 5, 1, 3, 4, 5, 1
        // Aux:   3, 5, 5, 8, 9, 13, 13

        // Input: 2, 1, 1, 2
        // Aux  : 2, 1, 3, 

        // Input: 1, 2, 3, 1
        // Aux  : 1, 2, 4, 
        for (int i = 2 ; i < n ; ++i) {
            if (i != n - 1){
                aux[i] = std::max(nums[i] + aux[i - 2], aux[i - 1]);
            }else {
                aux[i] = std::max(std::max(nums[i] + aux[i - 2], nums[i] + aux[0]), aux[i - 1]);
            }
        }

        
        for (int i = 0 ; i < n ; ++i)  {
            std::cout << aux[i] << " ";
        }
        

        // std::cout << "| ";
        int tmp = aux[n - 1];
        delete aux;
        return tmp;
    }

};
// [4, 1, 2, 7, 5, 3, 1]
// [4, 1, 6, 8, 11, 11, 12]

int main() {

    std::vector<int> nums { 4,1,2,7,5,3,1 };
    std::cout << HouseRobber::rob(nums);

    return 0;
}