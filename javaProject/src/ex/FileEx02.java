package ex;

import java.io.File;

public class FileEx02 {
	public static void main(String[] args) {
	       
        //프로젝트 현재 폴더를 객체로 생성
        File file = new File(".");
       
        //file이 존재하고 폴더라면
        if(file.exists() && file.isDirectory()){
           
            //폴더의 파일/폴더 목록을 문자열 배열로 반환
            String[] fList = file.list();
           
            for(int i=0; i<fList.length; i++)
                System.out.println("["+i+"]번째=>"+fList[i]);
        }else{
            System.out.println("해당 경로는 폴더가 아닙니다.");
        }//if문
    }
}
