import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    static class Node{
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        String input="";
        while((input = br.readLine())!=null && input.length()!=0){
            root = insert(root, Integer.parseInt(input));
        }
        postorder(root);
        System.out.println(sb.toString());
    }

    static Node insert(Node node, int input){
        if(node == null){
            node = new Node(input);
        }
        else if(input<node.key){
            node.left = insert(node.left, input);
        }
        else{
            node.right = insert(node.right, input);
        }
        return node;
    }

    private static void postorder(Node node) {
        if(node.left != null) postorder(node.left);
        if(node.right != null) postorder(node.right);
        sb.append(node.key).append("\n");
    }
}
