//Egemen Ballı 14 Oct 2022
#include "stack.h"

#define prettyPrint(value) (value?"Yes":"No")

int priority(char c){
	if(c == '*' || c == '/'){
		return 2;
	}else if(c == '+'|| c == '-'){
		return 1;
	}else{
		return 0;
	}
}

// Example input   -> "a+b*c+(d*e+f)*g"
// Expected output -> "abc*+de*f+g*+"
string inFixToPostFix(string word) {
    Stack<char> stack = Stack<char>(word.length());
    string result;
// Some operations
	for(int i = 0; word[i] != '\0'; i++){
		if(word[i] >= 'a' && word[i] <= 'z' || word[i] >= 'A' && word[i] <= 'Z' || word[i] >= '0' && word[i] <= '9' ){
			result += word[i];
		}else if(word[i] == '('){
			stack.push(word[i]);
		}else if(word[i] == ')'){
			while(stack.getTopElement() != '('){
				result += stack.pop();
			}
			stack.pop();
		}else{
			while(!stack.isEmpty() && priority(word[i]) <= priority(stack.getTopElement())){
				result += stack.pop();
			}
			stack.push(word[i]);
		}
	}

	while(!stack.isEmpty()){
		result += stack.pop();
	}

    return result;
}


int main() {
    Stack<int> numbers = Stack<int>(3);
    cout << "Is stack empty ? " << prettyPrint(numbers.isEmpty()) << endl;
    cout << "Is stack full ? " << prettyPrint(numbers.isFull()) << endl;
    numbers.push(1);
    cout << "Is test case 1 correct ? : " << prettyPrint(numbers.isEmpty() == false) << endl;
    int value = numbers.pop();
    cout << "Is test case 2 correct ? : " << prettyPrint(numbers.isEmpty() == true) << endl;
    cout << "Is test case 3 correct ? :" << prettyPrint(value == 1) << endl;
    numbers.push(1);
    numbers.push(2);
    numbers.push(3);
    cout << "Is test case 4 correct ? :" << prettyPrint(numbers.isFull()) << endl;
    numbers.push(4);
    cout << "Is test case 5 correct ? :" << prettyPrint(numbers.getTopIndex() == 2) << endl;
	cout << "Is test case 6 correct ? :" << prettyPrint(inFixToPostFix("a+b*c+(d*e+f)*g") == "abc*+de*f+g*+") << endl;
    return 0;
}
