#include <iostream>
#include <vector>

using namespace std;

class Node;
vector<Node> nodeList;

class Node {
  public:
    int num;
    int leftChild = -1;
    int rightChild = -1;
    Node(int n) : num(n) {}
};

void insert(int node, int num) {
  if (num > nodeList[node].num) {
    if (nodeList[node].rightChild == -1) {
      nodeList.emplace_back(Node(num));
      nodeList[node].rightChild = nodeList.size() - 1;
    } else {
      insert(nodeList[node].rightChild, num);
    }
  } else {
    if (nodeList[node].leftChild == -1) {
      nodeList.emplace_back(Node(num));
      nodeList[node].leftChild = nodeList.size() - 1;
    } else {
      insert(nodeList[node].leftChild, num);
    }
  }
}

void postorder(int n) {
  if (nodeList[n].leftChild != -1) postorder(nodeList[n].leftChild);
  if (nodeList[n].rightChild != -1) postorder(nodeList[n].rightChild);
  cout << nodeList[n].num << "\n";
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int rootNum;
  cin >> rootNum;
  nodeList.emplace_back(Node(rootNum));

  int input;
  while (cin >> input) {
    insert(0, input);
  }
  
  postorder(0);
  return 0;
}