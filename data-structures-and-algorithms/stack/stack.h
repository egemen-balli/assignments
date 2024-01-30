//Egemen Ballı 14 Oct 2022
#include <iostream>

using namespace std;

template<class T>
class Stack {
private:
    int top;
    int size;
    T *elements;
public:
    Stack(int size) {
        this->size = size;
        elements = new T[size];
        top = -1;
        for (int i = 0; i < size; i++) {
            elements[i] = NULL;
        }
    }

    int getTopIndex() {
        return top;
    }

    T getTopElement(){
    	return elements[top];
	}

    bool isEmpty() {
        return top == -1;
    }

    bool isFull() {
        return top == (size - 1);
    }

    void printStack() {
        cout << "Stack = {" << endl;
        for (int i = 0; i <= top; i++) {
            cout << elements[i] << ",";
        }
        cout << "} " << endl;
    }

    void clear() {
        delete[] elements;
    }

    // Fill the function and add necessary control statements to prevent program crash
    void push(T element) {
		if(isFull()){
			cout << "Stack is Full!" << endl;

		}else{
			top++;
			elements[top] = element;
		}
    }

    // Fill the function and add necessary control statements to prevent program crash
    T pop() {
		if(isEmpty()){
			cout << "Stack is Empty!" << endl;

		}else{
			T x = elements[top];
			top--;
			return x;
		}
    }
};
