package problem.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.dotorybook.DBManager;

public class BankDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	
	public void BankInsert(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno, bname, pw) " + 
					"VALUES (seq_bank.NEXTVAL, ?, ? ) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());
						
			int result = pstmt.executeUpdate();
			
			if(result > 0 ) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			 	conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void BankUpdate(BankDTO bto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank "  
					   + "    SET money = ? "
					   + "WHERE bname = ? " ;
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bto.getMoney());
			pstmt.setString(2, bto.getBname());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("입금성공");
			} else {
				System.out.println("입금실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void BankDelete() {}
	public void BankSelect() {}
	public void BankSeach() {}
	
	
	
	
	
}
