import java.util.*; 
import java.io.*;



class Node 
{ 
    int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 


public class BinarySearchLCA {  
  public static String BinarySearchTreeLCA(String[] strArr) { 
  
    // code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
       
    String x = strArr[0];
    x = x.substring(1,x.length()-1);
    String[] xarr = x.split(",");
    
    int[] intarr = new int[xarr.length];
    for(int i=0; i < xarr.length; i++){
        intarr[i] = Integer.parseInt(xarr[i].trim());
    }

    Node root = new Node(intarr[0]);
    
    for(int i=1; i < intarr.length; i++){
        insert(root,new Node(intarr[i]));
    }

    int int1 = Integer.parseInt(strArr[1].trim());
    int int2 =   Integer.parseInt(strArr[2].trim());
    
    
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    lookup(root,int1,list1 );
    //System.out.println(list1);
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    lookup(root,int2,list2 );
    //System.out.println(list2);
    int len1 = list1.size();
    int len2 = list2.size();
    int size = len1 > len2? len2:len1;  
  
  
    int LCA = 0; 
    for(int i=0; i < size ; i++){
    if(list1.get(i).intValue() == list2.get(i).intValue()){
           LCA = list1.get(i).intValue();
       } else{
           break;
       }
        
    }

   // System.out.println(LCA);
        return LCA + "";

  } 
  
  	private static void lookup(Node root, int i, ArrayList<Integer> arrList){
		
		if(root == null) {
			arrList.clear();
			return;
		}
		
		arrList.add(new Integer(root.data));
		if(i == root.data) {
			return;
		}

		if(i <= root.data) {
			lookup(root.left,i,arrList);
		}else {
			lookup(root.right,i,arrList);
		}
	}
	
	
  
  	public static Node insert(Node head, Node node){
		if(head==null) {
			return node;
		}
		
		if(node.data > head.data) {
			head.right  = insert(head.right,node);
		}else {
			head.left = insert(head.left,node);
		}
		return head; 
	}
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(BinarySearchTreeLCA(s.nextLine())); 
  }   
  
}