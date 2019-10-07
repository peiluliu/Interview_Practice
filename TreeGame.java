import java.io.*;
import java.util.*;

public class TreeGame {

    static int[] order;
    static int[] tree;
    
    public static void process(int node, int target, int beg, int end, int setVal){
        IO.println("node = "+node+" target = "+target+" beg = "+beg+" end = "+end+" mid = "+(beg+end)/2+" setVal = "+setVal);
        if(beg==end){
//            IO.println("Set leaf "+node+" to "+setVal);
            tree[node] = setVal;
            IO.print(setVal+" ");
            return;
        }
        
        int left = tree[node*2], right = tree[node*2+1], mid = (beg+end)/2;
        int nextVal=setVal;
        
        if(setVal==0 && (left==1 || right==1))nextVal=1;
        else if(setVal==1 && (left==1 || right == 1))nextVal = 0;
        else if(setVal==0 && (left==-1 && right == -1))nextVal = 1; 
        
        if(target<=mid) process(node*2, target, beg, mid, nextVal);
        else process(node*2+1, target, mid+1, end, nextVal);   
        
        //Set this parent node's value only if both the children have their values set.
        if(tree[node*2]!=-1 && tree[node*2+1]!=-1)tree[node] = setVal; 
    }
    
    public static void main(String[] args) throws Exception{
        int n = IO.nextInt();
        int nLeaves = (int)Math.pow(2, n); 
        order = IO.nextIntArray(nLeaves, " ");
                
        int nNodes = (int)Math.pow(2,(n+1))-1;
        tree = new int[nNodes+1]; 
        Arrays.fill(tree, -1);
        
        for(int i=1;i<=nLeaves-1;++i){
            process(1, order[i], 1, nLeaves, 0);
        }
//        IO.print("\n");
    }

 
    static class IO {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static int[][] next2dInt(int rows, int cols, String seperator) throws Exception {
            int[][] arr = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; ++i) {
                arr[i] = nextIntArray(cols, seperator);
            }
            return arr;
        }

        public static int[] nextIntArray(int nInts, String seperator) throws IOException {
            String ints = br.readLine();
            String[] sArray = ints.split(seperator);
            int[] array = new int[nInts + 1];
            for (int i = 1; i <= nInts; ++i) {
                array[i] = Integer.parseInt(sArray[i - 1]);
            }
            return array;
        }

        public static long[] nextLongArray(int nLongs, String seperator) throws IOException {
            String longs = br.readLine();
            String[] sArray = longs.split(seperator);
            long[] array = new long[nLongs + 1];
            for (int i = 1; i <= nLongs; ++i) {
                array[i] = Long.parseLong(sArray[i - 1]);
            }
            return array;
        }

        public static double[] nextDoubleArray(int nDoubles, String seperator) throws IOException {
            String doubles = br.readLine();
            String[] sArray = doubles.split(seperator);
            double[] array = new double[nDoubles + 1];
            for (int i = 1; i <= nDoubles; ++i) {
                array[i] = Double.parseDouble(sArray[i - 1]);
            }
            return array;
        }

        public static char[] nextCharArray(int nChars, String seperator) throws IOException {
            String chars = br.readLine();
            String[] sArray = chars.split(seperator);
            char[] array = new char[nChars + 1];
            for (int i = 1; i <= nChars; ++i) {
                array[i] = sArray[i - 1].charAt(0);
            }
            return array;
        }

        public static int nextInt() throws IOException {
            String in = br.readLine();
            return Integer.parseInt(in);
        }

        public static double nextDouble() throws IOException {
            String in = br.readLine();
            return Double.parseDouble(in);
        }

        public static long nextLong() throws IOException {
            String in = br.readLine();
            return Long.parseLong(in);
        }

        public static int nextChar() throws IOException {
            String in = br.readLine();
            return in.charAt(0);
        }

        public static String nextString() throws IOException {
            return br.readLine();
        }

        public static void print(Object... o) {
            for (Object os : o) {
                System.out.print(os);
            }
        }

        public static void println(Object... o) {
            for (Object os : o) {
                System.out.print(os);
            }
            System.out.print("\n");
        }

        public static void printlnSeperate(String seperator, Object... o) {
            StringBuilder sb = new StringBuilder();
            sb.delete(sb.length() - seperator.length(), sb.length());
            System.out.println(sb);
        }
    }
}