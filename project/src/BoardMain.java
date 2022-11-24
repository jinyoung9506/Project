import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardMain {

	Scanner sc = new Scanner(System.in);
	List<BoardVO> boardList = new ArrayList<>();

	public void getBoardList() {

		System.out.println("======================");
		System.out.println(" 번호 제목 작성자 작성일 ");
		System.out.println("----------------------");
		System.out.println("1.목록  2.등록 3.내용 4.삭제 0.종료");
		
			if (boardList.isEmpty()) {
				System.out.println("게시판이 비어있습니다.");
			} else {
				for (BoardVO boardVO : boardList) {
					System.out.println();
					
				}
			}
		}

	public void showBoardList() {
		if (boardList.size()>0) {
			for (BoardVO boardVO : boardList) {
				System.out.print(boardVO.getNum());
				System.out.print("  ");
				System.out.print(boardVO.getTitle());
				System.out.print("  ");
				System.out.print(boardVO.getWriter());
				System.out.print("  ");
				System.out.print(boardVO.getDate());
				}
			}
		else{
			System.out.println("게시판이 비어있습니다.");
		}
		
	}
	
	public void boardInsert() {
		BoardVO vo = new BoardVO();

		System.out.println("글 제목: ");
		String title = sc.nextLine();

		System.out.println("내용: ");
		String content = sc.nextLine();

		System.out.println("작성자: ");
		String writer = sc.nextLine();

		vo.setNum(boardList.indexOf(vo));
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy, hh:mm aaa");
		String registDate = sdf.format(new Date());
		vo.setDate(registDate);

		boardList.add(vo);
		System.out.println("글이 등록되었습니다.");
	}

	public void boardDetail(int select) {
		if (boardList.isEmpty()) {
			System.out.println("등록된 게시글이 없습니다.");
			return;
		}

		BoardVO vo = new BoardVO();
		vo = boardList.get(select - 1); // 인덱스= 글 번호-1
		System.out.println("번호: " + vo.getNum());
		System.out.println("제목: " + vo.getTitle());
		System.out.println("작성자: " + vo.getWriter());
		System.out.println("작성날짜: " + vo.getDate());
		System.out.println("----------------------");
		System.out.println(vo.getContent());
		System.out.println("0. 목록으로 돌아가기");
		select = Integer.parseInt(sc.nextLine());
		if (select == 0) {
			return;
		}
	}

	public void boardDelete(int select) {

		if (boardList.isEmpty()) {
			System.out.println("등록된 글이 없습니다.");
			return;
		}

		BoardVO vo1 = new BoardVO();
		vo1 = boardList.get(select - 1);
		boardList.remove(boardList.indexOf(vo1));

	}

}