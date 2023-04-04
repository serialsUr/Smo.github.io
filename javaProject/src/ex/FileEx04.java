package ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class FileEx04 {
	 public static void main(String[] args){ 
		   
	        FileInputStream fis = null;
	        FileOutputStream fos = null;
	        Date now = null;
	       
	        try{
	            //"FileStreamSample.txt" FileInputStream객체 생성
	            //"copyFile.txt"파일에 FileOutputStream객체 생성
	            //데이터 출력시 현재 데이터의 마지막에 추가.
	           // fis = new FileInputStream("C:\\test폴더\\test.txt");
	            fis = new FileInputStream("C:\\DBStudy\\pg\\mysql-connector-java-5.1.49-bin.jar");
	            fos = new FileOutputStream("1.jar", true);
	           
	            int i = 0;
	            now = new Date();
	            long start = now.getTime();//복사시작시간
	           
	            //FileInputStream에서 데이터를 1바이트씩 읽어오기
	            while((i=fis.read())!=-1){
	                // FileOutputStream에 읽은 데이터를 출력한다.
	                fos.write(i);
	            }
	           
	            now = new Date();
	            long end = now.getTime();//복사종료시간
	           
	            System.out.println("복사시간:" +(end-start));
	           
	        }catch(Exception e){
	            e.printStackTrace();
	       
	        }finally{
	           
	            //FileInputStream, FileOutputStream을 닫기
	            if(fis != null) try{fis.close();}catch(IOException e){}
	            if(fos != null) try{fos.close();}catch(IOException e){}
	           
	        }
	    }
}
