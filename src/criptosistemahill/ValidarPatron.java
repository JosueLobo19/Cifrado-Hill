
package criptosistemahill;

public class ValidarPatron {
    
    public char[] validarPatron(char []k){
        String datos = "abcdefghiklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ";
        String letra = "ji";
        int tamK=k.length, contAlf=0, tamAlf=25;
        char[] clave1= new char[tamK];
        char[] clave2= new char[tamK];
        
        for (int i = 0; i < tamK; i++) {
            if (k[i]==letra.charAt(0)) {
                clave1[i]=letra.charAt(1);
            }else{
                clave1[i]=k[i];
            }
//            System.out.print(""+clave1[i]);
        }
        
       // System.out.print("\nModificando patron 1: ");
        int encontrado=0, no=0, contC1=0, tamC2=0;
        int tamC1 = tamK;
        for (int i = 0; i < tamC1; i++) {
                encontrado=0;
                int j=0;
                while(j < tamAlf) {
                    if(contC1==tamC1){
                        j=tamAlf;
                    }else if (clave1[i]==datos.charAt(j)){
                        clave2[tamC2]=clave1[i];
                        tamC2++;
                        encontrado=1;
                        j=tamAlf;
                    }else{
                        j++;
                    } 
                }
                if (encontrado==0) {
                    no++;
                }
        }
        for (int i = 0; i < tamC2; i++) {
         //   System.out.print(""+clave2[i]); 
        }
//        System.out.println("\nLongitud de Patron: "+clave2.length);
        return clave2;
    }
    
    public int error(char []clave1){
        String datos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int tamK=clave1.length, contAlf=0, tamAlf=datos.length();
        char[] clave2= new char[tamK];
        
        int encontrado=0, no=0, contC1=0, tamC2=0;
        int tamC1 = tamK;
        for (int i = 0; i < tamC1; i++) {
                encontrado=0;
                int j=0;
                while(j < tamAlf) {
                    if(contC1==tamC1){
                        j=tamAlf;
                    }else if (clave1[i]==datos.charAt(j)){
                        clave2[tamC2]=clave1[i];
                        tamC2++;
                        encontrado=1;
                        j=tamAlf;
                    }else{
                        j++;
                    } 
                }
                if (encontrado==0) {
                    no++;
                }
        }
        System.out.print("\nCorrecciones en Patron4= "+no);
        
        return no;
    }
    
    public char[] validarPatron2(char []k){
        String datos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int tamK=k.length, contAlf=0, tamAlf=datos.length();
        char[] clave1= new char[tamK];
        char[] clave2= new char[tamK];
        
        for (int i = 0; i < tamK; i++) {
                clave1[i]=k[i];
        }
        
        System.out.print("\nModificando patron: ");
        int encontrado=0, no=0, contC1=0, tamC2=0;
        int tamC1 = tamK;
        for (int i = 0; i < tamC1; i++) {
                encontrado=0;
                int j=0;
                while(j < tamAlf) {
                    if(contC1==tamC1){
                        j=tamAlf;
                    }else if (clave1[i]==datos.charAt(j)){
                        clave2[tamC2]=clave1[i];
                        tamC2++;
                        encontrado=1;
                        j=tamAlf;
                    }else{
                        j++;
                    } 
                }
                if (encontrado==0) {
                    no++;
                }
        }
        for (int i = 0; i < tamC2; i++) {
            System.out.print(""+clave2[i]); 
        }
//        System.out.println("\nLongitud de Patron: "+clave2.length);
        return clave2;
    }
    
}
