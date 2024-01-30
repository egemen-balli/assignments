// Egemen BALLI 21 Oct 2022
#include <iostream>

using namespace std;

template<class T>
class CircularQueue {
private:
    int front;
    int rear;
    int size;
    T *elements;
public:

    CircularQueue(int size) {
        front = rear = -1;
        elements = new T[size];
        this->size = size;
    }

    int getFrontIndex() {
        return front;
    }

    int getRearIndex() {
        return rear;
    }

    // Fill the function and add necessary control statements to prevent program crash
    void enqueue(T element) {
        if (isFull()){
        	cout << "Queue is full." << endl;
        	return;
    	}
            
        if (isEmpty())
            front = (front + 1) % size;
            
        rear = (rear + 1) % size;
        elements[rear] = element;
    }

    // Fill the function and add necessary control statements to prevent program crash
    T dequeue() {
        if (isEmpty()){
            cout << "Queue is empty." << endl;
        	return NULL;
    	}
            
        T element = elements[front];
        elements[front] = NULL;
        front = (front + 1) % size;
        
        if (isEmpty()){
        	front = -1;
        	size = -1;
		}
        
        return element;
    }

    // Check that if the given element is existing.
    // Fill the function and add necessary control statements to prevent program crash
    bool searchElement(T element) {
        for(int i = 0; i < size; i++){
            if(element == elements[i]){
                return true;
            }
        }
        return false;
    }

    void clear(){
        delete[] elements;
    }

    void print() {
        cout << "CircularQueue" << endl;
        if (front != -1) {
            if (front <= rear) {
                for (int i = front; i <= rear; i++) {
                    cout << elements[i] << "->";
                }
                cout << endl;
            } else {
                for (int i = front; i <= size - 1; i++) {
                    cout << elements[i] << "->";
                }
                for (int i = 0; i <= rear; i++) {
                    cout << elements[i] << "->";
                }
                cout << endl;
            }
        }
    }

    bool isEmpty() {
        return front == -1;
    }

    bool isFull() {
        return ((front == 0) && (rear == size - 1)) || (front == rear + 1);
    }
};

