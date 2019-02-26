
package criptosistemahill;

public class DeterminanteDeMatriz {
    
     public int determin(int i, int matriz[][], int tamMatriz)
     {
         if(tamMatriz== 2){
             int deter = matriz[0][0]*matriz[1][1] - matriz[0][1]*matriz[1][0];
             return deter;
         }else {
             int deter=0;
             for (int j = 0; j < tamMatriz; j++) {
                 int [][]temp = this.subMatriz(i, j, matriz,tamMatriz);
                 deter = deter + (int)Math.pow(-1, i+j) * matriz[i][j] * this.determin(i, temp,tamMatriz-1);
             }
             return deter;
         } 
     }
     
     
     public int [][]subMatriz(int i, int j, int matriz[][], int tamMatriz){
         int [][]temp=new int[tamMatriz-1][tamMatriz-1];
         int cont1=0;
         int cont2=0;
         for (int k = 0; k < tamMatriz; k++) {
             if (k!=i) {
                 cont2=0;
                 for (int l = 0; l < tamMatriz; l++) {
                     if (l!=j) {
                         temp[cont1][cont2]=matriz[k][l];
                         cont2++;
                     }
                 }
                 cont1++;
             }
         }

         
         return temp;
     }
       
     
     /////////////////////////////// COFACTORES ////////////////////////////////
     
     public int [][]cofactores(int M[][], int d){
        int [][]A = new int[100][100];
        int [][]temp= new int[100][100];
        for(int i = 0; i < d; i++){
             for(int j = 0; j < d ;j++) {              
                  A[j][i] = (int)Math.pow(-1,i+j)*subMatrizC(i,j,M,temp,d);
             }
        }
        return A;
     }
     
     
     int subMatrizC(int i, int j, int M[][],int temp[][],int d) {
		
	int fil=0;
	int col=0;
	
	for(int k=0;k<d;k++){
            if(k!=i){
                col=0;
                for(int l=0;l<d;l++){
                    if(l!=j){
			temp[fil][col]=M[k][l];
			col++;
                    }			
		}
            fil++;			
            }	
	}
	return deterMatrizC(temp,d-1);
     }
     
     int deterMatrizC(int M[][],int d){
        int [][]temp= new int[100][100];
        if(d==2){
             int deter=M[0][0]*M[1][1]-M[1][0]*M[0][1];	

             return deter;
        }else{
            int deter=0;
            for(int j=0;j<d;j++){		    
                subMatrizC(0,j,M,temp,d);
                deter=deter+(int)Math.pow(-1,0+j)*M[0][j]*deterMatrizC(temp,d-1);
            }
            return deter;
        }		
     }
     
}
