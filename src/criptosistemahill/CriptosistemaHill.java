/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptosistemahill;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author BD Y TOPBD
 */
public class CriptosistemaHill {
    criptosistemahill.Inverso inverso = new criptosistemahill.Inverso();
    criptosistemahill.DeterminanteDeMatriz determinanteM = new criptosistemahill.DeterminanteDeMatriz();
    criptosistemahill.ValidarPatron validPat = new criptosistemahill.ValidarPatron();
    criptosistemahill.Bloques addBloques = new criptosistemahill.Bloques();
    criptosistemahill.Alfabeto alfabeto = new criptosistemahill.Alfabeto();
    char[] patronc;
    char[] patronr;
    int errorr;
    char[] espacios;
    String espacio="";
    public static void main(String[] args) {
     CriptosistemaHill nuevo=new CriptosistemaHill();
     nuevo.contenido();
             
    }
public void contenido()
{
    int tamaño;
    int [][]matrizz;
 Scanner leer = new Scanner(System.in);
 System.out.print("\n Ingrese el tamaño: "); 
 tamaño = leer.nextInt();
 matrizz=new int[tamaño][tamaño];
 for (int x=0; x < matrizz.length; x++) {
  for (int y=0; y < matrizz[x].length; y++) {
    System.out.println("Introduzca el elemento [" + x + "," + y + "]");
    matrizz[x][y] = leer.nextInt();
  }
 }
 ////Muestra la matriz ingresada
     //inicio  
 System.out.println("\n La matriz ingresada fue: ");
     for (int x=0; x < matrizz.length; x++) {
      for (int y=0; y < matrizz[x].length; y++) {
      System.out.print(""+matrizz[x][y]+" ");
      }
      System.out.println("");
    }
     //fin
 //
  char [] mensaje;
  Scanner recibido = new Scanner(System.in);
  System.out.print("\n Ingresa el mensaje a encriptar : ");
 String s = recibido.nextLine();
mensaje = s.toCharArray();
/*
System.out.println("\n el mensaje es: "); 
for(int o=0;o<mensaje.length;o++)
{
System.out.println(mensaje[o]); 
}
*/
     
int determ = determinanteM.determin(0, matrizz,tamaño) %26;
int inversaDeterm = inverso.euclidesExtendidoX(determ, 26);
            System.out.println("Det(A)= det(a)%26:: "+determ+" y La inversa de Det(A): "+inversaDeterm);
            if (determ==0 || determ==2 || determ==13 || inversaDeterm==-666) {
              System.out.print("\n La matriz no se puede usar : "); 
            }
            else 
            {
            Cifrado(mensaje,matrizz,tamaño);
            Descifrado(mensaje,matrizz,tamaño);
            }
                
 
     
}
 public char[] Cifrado(char []a, int [][]matrizA, int tamMatriz){
        
        ///////////////// OBTENER PATRON MODIFICADO /////////
        System.out.print("\nEl Patron a cifrar original es: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(""+a[i]);
        }
        int errorPI = validPat.error(a);
        errorr=errorPI;
        char[] patronInicial = new char[a.length];
        patronInicial = validPat.validarPatron2(a);
        int tamPV = patronInicial.length-errorPI;
        char[] patronvalidado = new char[tamPV];
        for (int i = 0; i < tamPV; i++) {
            patronvalidado[i]=patronInicial[i];
        }
        
        int tamPatron = addBloques.tamBloques(tamMatriz, patronvalidado);
        char[] patron = new char[tamPatron];
        
        patron=addBloques.bloques2(tamMatriz, patronvalidado, tamPatron);
        System.out.print("\nEL PATRON A CIFRAR SEGUN EL TAMAÑO 'N' MODIFICADO ES: ");
        int contad=0, sumador=0, verificador=0;
        for (int i = 0; i < patron.length; i=i+tamMatriz) {
            while (contad<tamMatriz) {
                System.out.print(""+patron[sumador]);
                sumador++;
                contad++;
            }
            System.out.print(" ");
            contad=0;
            verificador++;
        }
        char[] resul= new char[tamPatron];
        int pos =0, indice=0, numPatron=0, z=0;
        String r;
        
        for(int k=0; k<(tamPatron/tamMatriz); k++){
            for (int i = 0; i < tamMatriz; i++) {
                pos=z;
                indice=0;
                for (int j = 0; j < tamMatriz; j++) {
                    numPatron=alfabeto.numero(String.valueOf(patron[pos]));
                    indice = indice + (matrizA[i][j]*numPatron);
                    pos++;
                    
                }
                indice=indice%26;
                r=alfabeto.letra(indice);
                resul[z+i]=r.charAt(0); 
            }
            z=z+tamMatriz;
        }
     
        patronr=Arrays.copyOfRange(resul, 0,resul.length);
       contad=0;
       sumador=0;
       System.out.print("\n TEXTO CIFRADO ES: ");
        for (int i = 0; i < resul.length; i=i+tamMatriz) {
            while (contad<tamMatriz) {
                System.out.print(""+resul[sumador]);
                sumador++;
                contad++;
                
            }
            System.out.print(" ");
            contad=0;
        }
        return resul;
    }
    
    
    public char[] Descifrado(char []a, int [][]matrizA, int tamMatriz){
        
        ///////////////// OBTENER PATRON MODIFICADO /////////
        System.out.print("\n\nEl Patron a decifrar es: ");
             int  contad1=0;
       int sumador1=0;
       System.out.print("\n TEXTO CIFRADO ES: ");
        for (int i = 0; i < patronr.length; i=i+tamMatriz) {
            while (contad1<tamMatriz) {
                System.out.print(""+patronr[sumador1]);
                sumador1++;
                contad1++;
                
            }
            System.out.print(" ");
            contad1=0;
        } 
        int errorPI = validPat.error(a);
        char[] patronInicial = new char[a.length];
        patronInicial = validPat.validarPatron(a);
        int tamPV = patronInicial.length-errorPI;
        char[] patronvalidado = new char[tamPV];
        for (int i = 0; i < tamPV; i++) {
            patronvalidado[i]=patronInicial[i];
        }
        
        int tamPatron = addBloques.tamBloques(tamMatriz, patronvalidado);
        char[] patron = new char[tamPatron];
        
        patron=addBloques.bloques2(tamMatriz, patronvalidado, tamPatron);
        //System.out.print("\nEl patron  DECIFRAR Modificado es: ");
        int contad=0, sumador=0;
        for (int i = 0; i < patron.length; i=i+tamMatriz) {
            while (contad<tamMatriz) {
          //      System.out.print(""+patron[sumador]);
                sumador++;
                contad++;
            }
            System.out.print(" ");
            contad=0;
        }
        
        int [][]matrizCofactores = determinanteM.cofactores(matrizA, tamMatriz);
        System.out.println("\nLa Matriz para Descifrar es:");
        for (int i = 0; i < tamMatriz; i++) {
            for (int j = 0; j < tamMatriz; j++) {
                matrizCofactores[i][j]=(matrizCofactores[i][j]*3);
                if (matrizCofactores[i][j]>=0) {
                    matrizCofactores[i][j]=matrizCofactores[i][j]%26;
                }else if(matrizCofactores[i][j]>=-26){
                    matrizCofactores[i][j]=26+matrizCofactores[i][j];
                }else if(matrizCofactores[i][j]<-26){
                    matrizCofactores[i][j]=26-((matrizCofactores[i][j]*(-1))%26);
                }
                System.out.print(""+matrizCofactores[i][j]+" ");
            }
            System.out.println("");
        }
        
        char[] resul= new char[tamPatron];
        int pos =0, indice=0, numPatron=0, z=0;
        String r;
        
        for(int k=0; k<(tamPatron/tamMatriz); k++){
            for (int i = 0; i < tamMatriz; i++) {
                pos=z;
                indice=0;
                for (int j = 0; j < tamMatriz; j++) {
                    numPatron=alfabeto.numero(String.valueOf(patronr[pos]));
                    indice = indice + (matrizCofactores[i][j]*numPatron);
                    pos++;
                }
                indice=indice%26;
                r=alfabeto.letra(indice);
                resul[z+i]=r.charAt(0); 
            }
            z=z+tamMatriz;
        }
               System.out.print("\n CLAVE DESCIFRADA : ");
        for(int yy=0;yy<resul.length;yy++)
        {
            System.out.print(resul[yy]);
        }  
              
        return resul;
    }   
    
    public CriptosistemaHill() {
    }
    
}
