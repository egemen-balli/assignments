//Egemen Balli 11 Nov 2022
#include <iostream>

using namespace std;

enum Direction {
    LEFT, RIGHT
};

template<class T>
class TreeNode {
public:
    T data;
    TreeNode *left;
    TreeNode *right;

    TreeNode(T data) {
        this->data = data;
        this->left = NULL;
        this->right = NULL;
    }
};

template<class T>
class BST {
private:
    TreeNode<T> *root;

public :
    BST() {
        root = NULL;
    }

    bool isEmpty() {
        return root == NULL;
    }

    TreeNode<T> *getRoot() {
        return root;
    }

    //Insertion Rule:New nodes with a value less than the node in the tree are added left, otherwise right.
    // Print the "Node is not inserted !" error, if you can not insert the node due to duplicate value.
    void iterativeInsert(TreeNode<T> *newNode) {
        if (root == NULL) {
            root = newNode;
        } else {
            bool isInserted = false;
            TreeNode<T> *tempRoot = root;
            while ((!isInserted) && tempRoot != NULL) {
                if (newNode->data < tempRoot->data) {
                    if (tempRoot->left == NULL) {
                        tempRoot->left = newNode;
                        isInserted = true;
                    } else {
                        tempRoot = tempRoot->left;
                    }
                } else if (newNode->data > tempRoot->data) {
                    if (tempRoot->right == NULL) {
                        tempRoot->right = newNode;
                        isInserted = true;
                    } else {
                        tempRoot = tempRoot->right;
                    }
                } else {
                    break;
                }
            }
            if (!isInserted) {
                cout << "Node is not inserted !" << endl;
            }
        }
    }

    //Insertion Rule:New nodes with a value less than the node in the tree are added left, otherwise right.
    // Print the "Node is not inserted !" error, if you can not insert the node.
    void recursiveInsert(TreeNode<T> *tempRoot, TreeNode<T> *newNode) {
        if (root == NULL) {
            root = newNode;
        } else {
            if(newNode->data < tempRoot->data && tempRoot->left != NULL ){
                recursiveInsert(tempRoot->left, newNode);
            }
            else if(newNode->data > tempRoot->data && tempRoot->right != NULL){
                recursiveInsert(tempRoot->right, newNode);
            }
            else if(newNode->data == tempRoot->data){
                cout << "Node is not inserted !" << endl;
            }
            else if(newNode->data < tempRoot->data){
                tempRoot->left = newNode;
            }
            else{
                tempRoot->right = newNode;
            }
        }
    }

    // The node with search data may not exist.Print the "Node is not exist !" error, if you can not find the node.
    void deleteNode(T searchData) {
        TreeNode<T> *current = root;
        TreeNode<T> *prevNode = NULL;
        while(current != NULL && current->data != searchData){
            prevNode = current;
            if(searchData < current->data){
                current = current->left;
            }
            else{
                current = current->right;
            }
        }
        if(current == NULL){
            cout << "Node is not exist !" << endl;
            return;
        }
        if(current->left == NULL || current->right == NULL){
            TreeNode<T> *newCurrent;
            if(current->left == NULL){
                newCurrent = current->right;
            }
            else{
                newCurrent = current->left;
            }
            if(prevNode == NULL){
                return;
            }
            if(current == prevNode->left){
                prevNode->left = newCurrent;
            }
            else{
                prevNode->right = newCurrent;
            }
            free(current);
        }
        else{
            TreeNode<T> *p = NULL;
            TreeNode<T> *temp = current->right;
            while(temp->left != NULL){
                p = temp;
                temp = temp->left;
            }
            if (p != NULL){
                p->left = temp->right;
            }
            else{
                current->right = temp->right;
            }
            current->data = temp->data;
            free(temp);
        }
    }


    // Print the tree in horizontal line
    void print(TreeNode<T> *tempRoot, int gap = 0) {
        if (tempRoot != NULL) {
            print(tempRoot->right, gap + 1);
            for (int i = 0; i < gap; i++) {
                cout << "\t";
            }
            cout << tempRoot->data << endl;
            print(tempRoot->left, gap + 1);
        }
    }

    void clear(TreeNode<T> *tempRoot) {
        if (tempRoot != NULL) {
            clear(tempRoot->left);
            clear(tempRoot->right);
            delete tempRoot;
        }
    }

};