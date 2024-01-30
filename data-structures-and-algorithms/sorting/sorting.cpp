//Egemen Balli 9 Dec 2022
#include <random>
#include <iostream>

using namespace std;

int *generateRandomArray(int size) {
    random_device dev;
    mt19937 rng(dev());
    uniform_int_distribution <mt19937::result_type> randInt(1, size - 1); // distribution in range [1, size-1]
    int *array = new int[size];
    for (int i = 0; i < size; i++) {
        array[i] = randInt(rng);
    }
    return array;
}

void printArray(int *array, int size) {
    for (int i = 0; i < size; i++) {
        cout << array[i] << ",";
    }
    cout << endl;
}

// https://www.cs.usfca.edu/~galles/visualization/CountingSort.html
int *countingSort(int *array, int size) {
    int *sortedArray = new int[size];

    int max = array[0];

    for (int i = 1; i < size; i++) {
        if (array[i] > max){
            max = array[i];
        }
    }

    int *count = new int[max + 1];

    for (int i = 0; i < max + 1; i++){
        count[i] = 0;
    }

    for (int i = 0; i < size; i++) {
        count[array[i]]++;
    }

    for (int i = 0; i < max; i++) {
        count[i + 1] += count[i];
    }

    for(int i = size - 1; i > -1; i--){
        sortedArray[count[array[i]] - 1] = array[i];
        count[array[i]]--;
    }

    return sortedArray;
}

int *bubbleSort(int *array, int size) {
    int *sortedArray = new int[size];

    for(int i = 0; i < size; i++){
        sortedArray[i] = array[i];
    }

    for(int j = 0; j < size - 1; j++){
        for(int i = 0; i < size - 1 - j; i++){
            if(sortedArray[i] > sortedArray[i + 1]){
                int tmp = sortedArray[i];
                sortedArray[i] = sortedArray[i + 1];
                sortedArray[i + 1] = tmp;
            }
        }
    }

    return sortedArray;
}

int *selectionSort(int *array, int size) {
    int *sortedArray = new int[size];

    for (int i = 0; i < size; i++){
        sortedArray[i] = array[i];
    }

    for(int i = 0; i < size - 1; i++){
        int min = i;
        for(int j = i + 1; j < size; j++){
            if(sortedArray[min] > sortedArray[j]){
                int tmp = sortedArray[min];
                sortedArray[min] = sortedArray[j];
                sortedArray[j] = tmp;
            }
        }
    }

    return sortedArray;
}

int main() {
    int size = 10;
    int *array = generateRandomArray(size);
    cout << "Before Sort " << endl;
    printArray(array, size);
    cout << "After Counting Sort" << endl;
    printArray(countingSort(array, size), size);
    cout << "After Bubble Sort" << endl;
    printArray(bubbleSort(array, size), size);
    cout << "After Selection Sort" << endl;
    printArray(selectionSort(array, size), size);
    return 0;
}