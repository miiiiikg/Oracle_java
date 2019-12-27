package com.biz.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.config.DBContract;

public class IoService {
	
	Connection dbConn = null;
	
	public IoService() {
		this.dbConn = DBConnection.getDBConnection();
	}
	
	public void selectAll() {
		PreparedStatement pst = null;
		String sql = DBContract.CRUD.SELECT_ALL;
		
		try {
			pst = dbConn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("=========================================");
			System.out.println("SEQ\t날짜\t시간\t거래처\t 상품");
			System.out.println("------------------------------------------");
			while(rst.next()) {
				this.listView(rst);
			}
			System.out.println("=========================================");
			rst.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void findBySeq (long io_seq ) {
		String sql = DBContract.CRUD.SELECT_ALL;
		sql += "WHERE io_seq = ?";
		
		PreparedStatement pst = null;
		
		try {
			pst = dbConn.prepareStatement(sql);
			pst.setLong(1, io_seq);
			ResultSet rst = pst.executeQuery();
			
			if(rst.next()) {
				System.out.println("================================");
				System.out.printf("SEQ : %d\n" , rst.getLong(DBContract.IO_COLUMN.IO_SEQ));
				System.out.printf("거래일자 : %s\n" , rst.getString(DBContract.IO_COLUMN.IO_DATE));
				System.out.printf("거래시각 : %s\n" , rst.getString(DBContract.IO_COLUMN.IO_TIME));
				System.out.printf("거래구분 : %s\n" , rst.getString(DBContract.IO_COLUMN.IO_INOUT));
				System.out.printf("거래처 : %s\n" , rst.getString(DBContract.IO_COLUMN.IO_DNAME));
				System.out.printf("상품명 : %s\n" , rst.getString(DBContract.IO_COLUMN.IO_PNAME));
				System.out.printf("수량 : %d\n" , rst.getInt(DBContract.IO_COLUMN.IO_QTY));
				System.out.printf("단가 : %d\n" , rst.getInt(DBContract.IO_COLUMN.IO_PRICE));
			}
			rst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listView(ResultSet rst) throws SQLException {
		
		System.out.print(rst.getString(DBContract.IO_COLUMN.IO_SEQ)+"\t");
		System.out.print(rst.getString(DBContract.IO_COLUMN.IO_DATE)+"\t");
		System.out.print(rst.getString(DBContract.IO_COLUMN.IO_TIME)+"\t");
		System.out.print(rst.getString(DBContract.IO_COLUMN.IO_DNAME)+"\t");
		System.out.print(rst.getString(DBContract.IO_COLUMN.IO_PNAME)+"\n");
		
	}
	

}
