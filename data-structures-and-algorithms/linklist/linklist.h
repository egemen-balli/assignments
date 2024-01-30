//Egemen Balli 4 Nov 2022
#include <iostream>

using namespace std;

template<class T>
class LinkListNode {
public:
    T data;
    LinkListNode *next;

    LinkListNode(T data) {
        this->data = data;
        next = NULL;
    }
};

template<class T>
class LinkList {
    LinkListNode<T> *head;
public:
    LinkList() {
        head = NULL;
    }

    bool isEmpty() {
        return head == NULL;
    }

    // This function is implemented for testing.Don't use this function.
    LinkListNode<T> *getHead() {
        return head;
    }

    void insertFirst(LinkListNode<T> *node) {
        if(head==NULL){
            node->next = NULL;
            head = node;
        }else{
            node->next = head;
            head = node;
        }
    }

    // Insert "after" the node that contains searchData value
    void insert(LinkListNode<T> *node, T searchData) {
        LinkListNode<T> *index = head;
        while(index != NULL && index->data != searchData){
            index = index->next;
        }
        LinkListNode<T> *temp = index->next;
        index->next = node;
        node->next = temp;
    }

    void insertLast(LinkListNode<T> *node) {
        if(head == NULL){
            head = node;
        }else{
            topElement()->next = node;
        }
    }

    LinkListNode<T> *removeElement(T searchData) {
        if(head == NULL){
            cout << "Linked List is empty." << endl;
            return NULL;
        }else if(head->data == searchData){
            LinkListNode<T> *oldHead = head;
            head = head->next;
            return oldHead;
        }
        LinkListNode<T> *prevNode = NULL;
        LinkListNode<T> *index = head;
        while(index != NULL && index->data != searchData){
            prevNode = index;
            index = index->next;
        }
        if(index == NULL){
            cout << "Data not found." << endl;
            return NULL;
        }
        prevNode->next = index->next;
        return index;
    }

    //Element on the tail, returned but not removed from the linklist
    LinkListNode<T> *topElement() {
        LinkListNode<T> *tempHead = head;
        LinkListNode<T> *topElement = NULL;
        while (tempHead != NULL) {
            if (tempHead->next == NULL) {
                topElement = tempHead;
                break;
            }
            tempHead = tempHead->next;
        }
        return topElement;
    }

    void print() {
        //You have to use temp node when you move the head temporarily,
        // otherwise the node position won't be correct
        cout << "List Info" << endl;
        LinkListNode<T> *tempHead = head;
        while (tempHead != NULL) {
            cout << tempHead->data << "->";
            tempHead = tempHead->next;
        }
        cout << endl;
    }

    void clear() {
        LinkListNode<T> *tempHead = head;
        LinkListNode<T> *next = NULL;
        while (tempHead != NULL) {
            next = tempHead->next;
            delete tempHead;
            tempHead = next;
        }
    }
};