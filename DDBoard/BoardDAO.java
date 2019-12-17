package problem.DDBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import jdbc.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();
	
	public void BoardInsert(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) "
					+ "VALUES(seq_board.nextVAL, ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	public void BoardUpdate(BoardDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board "
					+ " SET  title = ?, "
					+ "      content = ?, "
					+ "      writer = ? "
					+ " WHERE bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setInt(4, bDto.getBno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("입력성공");
			}else { 
				System.out.println("입력실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void BoardDelete() {
//		try {
//			conn = DBManager.getConnection();
//			//String sql = 
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//		}
		
	}
	public void BoardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " ;
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			list.clear();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
				
		   	}	   	
			for (BoardDTO line : list) {
				System.out.print(line.getBno()+"\t");
				System.out.print(line.getTitle()+"\t");
				System.out.print(line.getContent()+"\t");
				System.out.print(line.getWriter()+"\t");
				System.out.print(line.getRegdate()+"\t");
				System.out.println();
			 }
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void BoardSearch() {}
	public void BoardView() {}
	public void BoardSort() {}

}
