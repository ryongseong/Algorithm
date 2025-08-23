import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            this.data = item;
        }

        Node (int num, Node left, Node right) {
            this.data = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.data) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else if (n > this.data) {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String line;

        while (true) {
            line = br.readLine();
            if (line == null || line.isEmpty()) break;
            root.insert(Integer.parseInt(line));
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }
}