
package criptosistemahill;

public class Alfabeto {
    
    public int numero(String a){
        int C=-666;
        if(a.equals(" ")){
            C=-555;
        }else if(a.equals("a")){
            C=0;
        }else if(a.equals("b")){
            C=1;
        }else if(a.equals("c")){
            C=2;
        }else if(a.equals("d")){
            C=3;
        }else if(a.equals("e")){
            C=4;
        }else if(a.equals("f")){
            C=5;
        }else if(a.equals("g")){
            C=6;
        }else if(a.equals("h")){
            C=7;
        }else if(a.equals("i")){
            C=8;
        }else if(a.equals("j")){
            C=9;
        }else if(a.equals("k")){
            C=10;
        }else if(a.equals("l")){
            C=11;
        }else if(a.equals("m")){
            C=12;
        }else if(a.equals("n")){
            C=13;
        }else if(a.equals("o")){
            C=14;
        }else if(a.equals("p")){
            C=15;
        }else if(a.equals("q")){
            C=16;
        }else if(a.equals("r")){
            C=17;
        }else if(a.equals("s")){
            C=18;
        }else if(a.equals("t")){
            C=19;
        }else if(a.equals("u")){
            C=20;
        }else if(a.equals("v")){
            C=21;
        }else if(a.equals("w")){
            C=22;
        }else if(a.equals("x")){
            C=23;
        }else if(a.equals("y")){
            C=24;
        }else if(a.equals("z")){
            C=25;
        }
        return C;
    }
    
    public String letra(int a){
        String C=null;
        if(a==-555){
            C=" ";
        }else if(a==0){
            C="a";
        }else if(a==1){
            C="b";
        }else if(a==2){
            C="c";
        }else if(a==3){
            C="d";
        }else if(a==4){
            C="e";
        }else if(a==5){
            C="f";
        }else if(a==6){
            C="g";
        }else if(a==7){
            C="h";
        }else if(a==8){
            C="i";
        }else if(a==9){
            C="j";
        }else if(a==10){
            C="k";
        }else if(a==11){
            C="l";
        }else if(a==12){
            C="m";
        }else if(a==13){
            C="n";
        }else if(a==14){
            C="o";
        }else if(a==15){
            C="p";
        }else if(a==16){
            C="q";
        }else if(a==17){
            C="r";
        }else if(a==18){
            C="s";
        }else if(a==19){
            C="t";
        }else if(a==20){
            C="u";
        }else if(a==21){
            C="v";
        }else if(a==22){
            C="w";
        }else if(a==23){
            C="x";
        }else if(a==24){
            C="y";
        }else if(a==25){
            C="z";
        }
        return C;
    }
    
}
