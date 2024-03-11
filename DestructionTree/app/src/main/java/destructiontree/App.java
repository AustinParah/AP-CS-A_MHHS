/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package destructiontree;

public class App {

    public static void main(String[] args) {
      recursiveBase(0, 11);
      Trunk(11);
    }

  public static void recursiveBase(int i, int height){
    if(i<height){
    
      for( int j=i; j<height; j++){
        System.out.print("_");
      }
      for(int j=0; j<i; j++){
        System.out.print("#");
      }
      for(int j=0; j<i; j++){
        System.out.print("#");
      }
      for( int j=i; j<height; j++){
        System.out.print("_");
      }
      System.out.println();
      recursiveBase(i+1, height);
    }
  }

  public static void Trunk(int height){
    for(int i=0; i<3; i++){
      for(int j=0; j<height-1; j++){
        System.out.print("_");
      }
      System.out.println("$$");      
    }
    }
  }
