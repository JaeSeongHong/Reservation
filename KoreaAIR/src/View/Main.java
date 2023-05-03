package View;

import java.util.Scanner;

import Model.UserDAO;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		int select;
		
		
		System.out.println("==========================================");
		System.out.println("===========K O R E A -- A I R=============");
		System.out.println("==========================================");
		
		while(true) {
			System.out.print("[1]회원가입\t[2]로그인    \t[3]종료 ");
			select = sc.nextInt();
			
			if(select==1) {//회원가입
				
				System.out.print("새로운 아이디를 입력해주세요 >> ");
				String newId = sc.next();
				System.out.print("새로운 비밀번호를 입력해주세요 >> ");
				String newPw = sc.next();
				System.out.print("이름을 입력해주세요 >> ");
				String newName = sc.next();
				System.out.print("휴대폰 번호를 입력해주세요 >> ");
				String newCellnum = sc.next();
				
				dao.SignUp(newId, newPw, newName, newCellnum);
				
			}else if(select==2) {//로그인
				
				System.out.print("아이디를 입력해주세요 >> ");
				String inputId = sc.next();
				System.out.print("비밀번호를 입력해주세요 >> ");
				String inputPw = sc.next();
				
				String username = dao.login(inputId, inputPw);
				
				if(username != null) {//로그인 성공 시 서비스 선택
					System.out.println("'"+username+"'님 환영합니다!");
					System.out.println("=========원하시는 서비스를 선택해주세요.=========");
					System.out.print("[1]예약하기 \t [2]예약조회 \t [3]예약취소 >> ");
					select = sc.nextInt();
					if(select==1) {//예약하기
						System.out.print("도착지를 입력해주세요 >> ");
						String arrive = sc.next();
						
					}else if(select==2) {//예약조회
						
					}else if(select==3) {//예약취소
						
					}else {
						System.out.println("다시 입력해주세요!");
					}
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}else {//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
			
			
		}
		
		
		
		
	}
}
