import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static int N;
    static int[][] tree = new int[26][2];
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int root = -1;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            byte[] b1 = st.nextToken().getBytes(StandardCharsets.US_ASCII);
            byte[] b2 = st.nextToken().getBytes(StandardCharsets.US_ASCII);
            byte[] b3 = st.nextToken().getBytes(StandardCharsets.US_ASCII);

            if(i==0)root = b1[0]-65;
            tree[b1[0]-65][0] = b2[0]-65;
            tree[b1[0]-65][1] = b3[0]-65;
        }
        preorder(root);
        inorder(root);
        postorder(root);
        System.out.println(pre.toString());
        System.out.println(in.toString());
        System.out.println(post.toString());
    }

    private static void postorder(int parent) {
        int left = tree[parent][0];
        int right = tree[parent][1];
        if(left<0){
            if(right>=0) postorder(right);
        }
        else{
            postorder(left);
            if(right>=0) postorder(right);
        }
        post.append((char)(parent+65));
    }

    private static void preorder(int parent) {
        pre.append((char)(parent+65));
        int left = tree[parent][0];
        int right = tree[parent][1];
        if(left<0){
            if(right>=0) preorder(right);
        }
        else{
            preorder(left);
            if(right>=0) preorder(right);
        }
    }

    private static void inorder(int parent) {
        int left = tree[parent][0];
        int right = tree[parent][1];
        if(left<0){
            in.append((char)(parent+65));
            if(right>=0) inorder(right);
        }
        else{
            inorder(left);
            in.append((char)(parent+65));
            if(right>=0) inorder(right);
        }
    }
}
