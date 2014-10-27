package java02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//파일 쓰기
 
public class Test {
 
        public static void main(String[] args) {
               FileOutputStream fos = null;
              
               //파일이 없으면 새로 생성
               //false일 경우 덮어쓰기
               //true일 경우 이어쓰기
               try {
                       fos = new FileOutputStream(args[0], false);
                                            
               } catch (FileNotFoundException e) {
 
               } catch (IOException e) {
 
               } finally{
                       if(fos != null){
                              try{fos.close();
                              }catch(IOException e){}
                       }
               }
              
        }
}