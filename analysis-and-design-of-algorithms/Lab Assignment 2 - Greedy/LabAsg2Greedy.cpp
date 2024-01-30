//Egemen Balli 6 Apr 2023

#include <iostream>

using namespace std;

#define MARKET1 true
#define MARKET2 false
#define ITEM_COUNT 5
int market1Prices[] = {5, 7, 12, 3, 4};
int market2Prices[] = {8, 4, 9, 9, 6};
bool markets[ITEM_COUNT];
//Change the values in below to calculate different result
int market1Point = 3;
int market2Point = 22;

// Return the money spent and assign each market to the "markets" variable
int buyItems() {
    int moneySpent = 0;
    for (int i = 0; i < ITEM_COUNT; ++i) {
        if (market1Prices[i] <= market2Prices[i]){
            markets[i] = MARKET1;
            if(market1Point >= market1Prices[i]){
                market1Point -= market1Prices[i];
            }else{
                moneySpent += market1Prices[i];
            }
        }else{
            markets[i] = MARKET2;
            if(market2Point >= market2Prices[i]){
                market2Point -= market2Prices[i];
            }else{
                moneySpent += market2Prices[i];
            }
        }
    }
    return moneySpent;
}

// Print the market information
void printMarkets(){
    cout<<"Additional Money spent = "<<buyItems()<<" TL"<< endl <<"Market1 points = "<<market1Point<< " Market2 points = "<<market2Point<<endl<<"Markets = {";
    for (int i = 0; i < ITEM_COUNT; ++i) {
        if(markets[i]){
            cout<<"MARKET1,";
        } else{
            cout<<"MARKET2,";
        }
    }
    cout<<"}";
}
// You can print other information in the main function
int main(){
    printMarkets();
}
