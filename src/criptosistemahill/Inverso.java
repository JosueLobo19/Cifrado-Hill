
package criptosistemahill;

public class Inverso {
    
    public int euclidesExtendidoX(int a, int b){
        int resul=0;
        int d=0, q=0, r=0, x=0, y=0, x2=1, x1=0, y2=0, y1=1;
        int iN=b, iA=a;
        if(iN==0){
            d=iA;
            x=1;
            y=0;
        }
        else{
            while(iN>0){
                q=(iA/iN);
                r=iA-q*iN;
                x = x2-q*x1;
                y = y2-q*y1;
                iA = iN;
                iN = r;
                x2 = x1;
                x1 = x;
                y2 = y1;            
                y1 = y;
            }
            d = iA;   
            x = x2;   
            y = y2;
        }
        if(d==1){
            resul=x;
        }else{
            resul=-666;
        }
        
        return resul;
    }
    
}
