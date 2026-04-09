import java.io.*;
import java.util.*;

class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
    public static void main(String[] args) throws Exception {
    	
    	st = new StringTokenizer(reader.readLine());
    	Node root = new Node(Integer.parseInt(st.nextToken()));
    	
    	while(true) {
    		String line;
            line = reader.readLine();
            if(line != null && !line.isEmpty() == true) {
            	int number = Integer.parseInt(line);
        		root.insert(number);
            } else {
            	break;
            }
    	}
    	
    	postorder(root);
    	writer.flush();
    	
    	
    }
    
    static void postorder(Node node) throws IOException {
    	if (node.leftChild != null) {
    		postorder(node.leftChild);
    	}
    	if (node.rightChild != null) {
    		postorder(node.rightChild);
    	}
    	writer.write(node.num + "\n");
    }
}

class Node {
	int num = -1;
	Node leftChild = null;
	Node rightChild = null;
	
	public Node(int n) {
		this.num = n;
	}
	
	public void insert(int n) {
		if (n < this.num) {
			if (this.leftChild == null) {
				this.leftChild = new Node(n);
			} else {
				this.leftChild.insert(n);
			}
		} else {
			if (this.rightChild == null) {
				this.rightChild = new Node(n);
			} else {
				this.rightChild.insert(n);
			}
		}
	}
}