
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wirasinee
 */

public class UFLP_small {
    public static void main(String[] args){
       
        Scanner in = new Scanner(System.in);
        
        System.out.print("โกดัง(n): ");
        int n = in.nextInt(); //จ โกดัง
        System.out.print("\nลูกค้า(m): ");
        int m = in.nextInt(); //จ ลูกค้า
        System.out.print("\nต้นทุน(w): ");
        int[] w = new int[n];
        int sumW = 0;
        for(int i=0;i<n;i++){
            w[i]=in.nextInt();
            sumW+=w[i];
        }
        System.out.println("\ndistance[ลูกค้า\\คลัง]: ");//ระยะทาง
        int[][] distance = new int[n][m];
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                distance[i][j] = in.nextInt();
            }
        }
        
        for(int j=0;j<m;j++){ //พิมitptmk'
            for(int i=0;i<n;i++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }
        
        int[] min = new int[m];
        int[][] tree = new int[n][m];
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++)
            tree[i][j]=0;
        }
        
        System.out.println("ผลรวมต้นทุน(SumW): "+sumW); //พิมค่าผลรวมต้นทุน
        int sumDistance = 0;
        for(int j=0;j<m;j++){
            int minJ = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
               if(minJ>=distance[i][j]){
                   minJ = distance[i][j];
                   tree[i][j] = 1; 
                   for(int z=i-1;z>=0;z--)
                   tree[z][j]=0;
               }
                   
               
                   
            }
            min[j]=minJ;
            sumDistance+=min[j];
            
        }
        System.out.println("ระยะทางที่ใกล้ที่สุด ");
        for(int i=0;i<min.length;i++){
            System.out.print("ลูกค้า "+(i+1)+" : "+min[i]+" ");
        }
        System.out.println("\nโกดังที่ใกล้กับลูกค้า [ลูกค้า\\โกดัง]");
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
            System.out.print(tree[i][j]+" ");
            }
            System.out.println();
        }
        
        int[] tree_small = new int[n];
        for(int i=0;i<n;i++){
            tree_small[i]=0;
        }
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                if(tree[i][j]>=1){
                    tree_small[i]+=tree[i][j];
                }
            }
            
        }
         System.out.println("จำนวนคนที่ถูกบริการในโกดังนั้นๆ");
        for(int i=0;i<n;i++){
            System.out.print(tree_small[i]+" ");
        }
        System.out.println();
        int C = sumW+sumDistance;
         
        System.out.println("_________________________________");        
        System.out.println("C(S) = "+C);
        System.out.println("โกดังที่เปิด");   
        for(int i=0;i<n;i++){
                if(tree_small[i]>=1){
                     System.out.println("-โกดัง"+(i+1)+" ");
                }
            
            
        }
        
    }
    
    
}
