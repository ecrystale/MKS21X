import java.util.Arrays;   
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "09.Lee.Emily"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
  public static void selectionSort(int[] data){
      for (int i=0;i<data.length-1;i++){
	  int orig=data[i];
	  int place=data[i];
	  int placement=i;
	  for(int x=i+1;x<data.length;x++){
	      if (place>data[x]){
		  place=data[x];
		  placement=x;
	      }
	  }
	  data[i]=data[placement];
	  data[placement]=orig;
      }
  }

    public static void insertionSort(int[] data){
	int place;
	for (int i=0;i<data.length-1;i++){
	    place=data[i];
	    for(int x=i+1;x<data.length;x++){
		place=data[i];
		if (data[x]<place){
		    data[i]=data[x];
		    data[x]=place;
		}
	    }
	}
    }
    public static void main(String[]args){                                      
        int[] randish = new int[15];                                            
        for(int i = 0 ; i < randish.length; i++){                              
            randish[i] =(int)(Math.random()*100);                               
        }                                                                      
        System.out.println(Arrays.toString(randish));
	selectionSort(randish);                           
        System.out.println(Arrays.toString(randish));   
        int[] randish2 = new int[15];                                           
        for(int i = 0 ; i < randish2.length; i++){                              
            randish2[i] =(int)(Math.random()*100);                              
        }                                                                     
        System.out.println(Arrays.toString(randish2));
	insertionSort(randish2);                          
        System.out.println(Arrays.toString(randish2));
    }                                                     
}
