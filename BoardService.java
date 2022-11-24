package project;

import java.util.Scanner;

public class BoardService {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BoardMain main = new BoardMain(); // 접근객체

		while (true) {
			main.getBoardList();
			int answer = Integer.parseInt(sc.nextLine());
			if (answer == 1) {
				main.showBoardList();
			} else if (answer == 2) {
				main.boardInsert();
				continue;
			} else if (answer == 3) {
				System.out.println("보고싶은 게시글의 번호를 입력하세요>> ");
				int select = Integer.parseInt(sc.nextLine());
				main.boardDetail(select);
			} else if (answer == 4) {
				System.out.println("삭제할 게시글의 번호를 입력하세요>> ");
				int select = Integer.parseInt(sc.nextLine());
				main.boardDelete(select);
			} else if (answer == 0) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		System.out.println("프로그램이 종료되었습니다.");

	}
}