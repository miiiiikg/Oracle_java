package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.DDEnter.MemberDTO;

public class BookDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<>();

	public void bookInsert(BookDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_book(bno, bname, price, company, writer) "
					+ "VALUES(seq_book.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{ 
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void bookUpdate() {
// try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE tbl_enter "
//					+ "SET bname = ?, "
//					+ "	   price = ?, "
//					+ "    company = ?, "
//					+ "    writer = ?, "
//					+ "    regdate = ? "
//					+ "WHERE bno = ? " ;
//			pstmt = conn.prepareStatement(sql)l;
//			pstmt.set
//		}
	}
	public void bookDelete() {}
	
	public void bookSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book ";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				String bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
		
				
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
				
				for (BookDTO line: list) {
					System.out.print(line.getBno() + "\t");
					System.out.print(line.getBname() + "\t");
					System.out.print(line.getPrice() + "\t");
					System.out.print(line.getCompany() + "\t");
					System.out.print(line.getWriter() + "\t");
					System.out.print(line.getRegdate() + "\t");
					System.out.println();
					
				}
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void bookSearch(String bname) {
		
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book "
					+"WHERE bname LIKE '%' ||?|| '%' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bno = rs.getString("bno");
				bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				
				BookDTO mDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(mDto);
			}
			for(BookDTO line : list) {
				// System.out.println(line.toString());
				System.out.print(line.getBno() +"\t");
				System.out.print(line.getBname() +"\t");
				System.out.print(line.getPrice() +"\t");
				System.out.print(line.getCompany() +"\t");
				System.out.print(line.getWriter() +"\t");
				System.out.print(line.getRegdate() +"\t");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			conn.close();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}
	public void madeBy() {}
	

}
