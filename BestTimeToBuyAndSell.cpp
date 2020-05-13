#include <iostream>
#include <vector>
#include <algorithm>

/**
 * Compute best time to buy and sell stocks
 */
class BestTimeToBuyAndSell
{
public:
    static int maxProfit(std::vector<int>& prices) {
        int n = prices.size();
        int* aux = new int[n];
        for (int i = 0 ; i < n ; ++i) {
            aux[i] = 0;
        }
        
        for (int i = 1 ; i < prices.size() ; ++i ){
            int tmp = prices[i] - prices[i - 1];
            aux[i] = std::max(tmp, tmp + aux[i - 1]);
        }


        int max_profit = 0;
        for (int i = 0 ; i < n ; ++i) {
            if (max_profit < aux[i]) {
                max_profit = aux[i];
            }
        }

        return max_profit;
    }
};

int main() {
    std::vector<int> vector {7, 4, 11, 12, 400, 500, 4};
    std::cout << BestTimeToBuyAndSell::maxProfit(vector);
}