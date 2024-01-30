//Egemen Balli 18 Nov 2022
#include <iostream>

using namespace std;


template<class T>
class TreeNode {
public:
    T data;
    int frequency;
    string path;
    TreeNode *left;
    TreeNode *right;

    TreeNode(T data, int frequency) {
        this->data = data;
        this->frequency = frequency;
        this->left = NULL;
        this->right = NULL;
        this->path = "";
    }
};

template<class T>
class HuffmanTree {
public :
    HuffmanTree(TreeNode<T> **sortedNodeList, int size) {
        this->sortedNodeList = sortedNodeList;
        this->size = size;
    }

    // Use the mergeNodes function and sortedNoteList to construct a huffman tree.
    // You can type function calls by yourself instead of using for/while loops.
    TreeNode<T> *buildTree() {
        TreeNode<T> *a = mergeNodes(sortedNodeList[0], sortedNodeList[1]);
        TreeNode<T> *b = mergeNodes(sortedNodeList[2], sortedNodeList[3]);
        TreeNode<T> *c = mergeNodes(sortedNodeList[4], a);
        TreeNode<T> *d = mergeNodes(sortedNodeList[5], sortedNodeList[6]);
        TreeNode<T> *e = mergeNodes(b, c);
        TreeNode<T> *root = mergeNodes(d, e);
        return root;
    }

    // Use one of the tree traversal methods to assign correct path value to the leaf nodes
    // As an example, the node with value 's' should have a path as "00" and
    // the node with value 'q' should have a path "1110"
    void assignPaths(TreeNode<T> *tempRoot, string path) {
        if(tempRoot->left == NULL && tempRoot->right == NULL){
            tempRoot->path = path;
        }
        else{
            tempRoot->path = path;
            assignPaths(tempRoot->left, path + "0");
            assignPaths(tempRoot->right, path + "1");
        }
    }

    void clear(TreeNode<T> *tempRoot) {
        if (tempRoot != NULL) {
            clear(tempRoot->left);
            clear(tempRoot->right);
            delete tempRoot;
        }
    }

private :
    TreeNode<T> **sortedNodeList;
    int size;

    // merge the given node values and return a new node connection
    // merged node data can be NULL
    TreeNode<T> *mergeNodes(TreeNode<T> *leftChild, TreeNode<T> *rightChild) {
        TreeNode<T> *temp = new TreeNode<T>(NULL, leftChild->frequency + rightChild->frequency);
        temp->left = leftChild;
        temp->right = rightChild;
        return temp;
    }


};