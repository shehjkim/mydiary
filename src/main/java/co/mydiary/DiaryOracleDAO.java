package co.mydiary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiaryOracleDAO implements DAO {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;
	

	@Override
	public int insert(DiaryVO vo) {
		try {
			conn = JdbcUtil.connect();
			String sql = " INSERT INTO diary VALUES (?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getWdate());
			psmt.setString(2, vo.getContents());
			int r = psmt.executeUpdate();
			System.out.println(r + "건이 등록됨.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}JdbcUtil.disconnect(conn);
		return 0;
	}

	@Override
	public void update(DiaryVO vo) {
		// TODO Auto-generated method stub
		try {
			conn = JdbcUtil.connect();
			String sql  = "UPDATE diary SET contents = ? WHERE wdate=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContents());
			psmt.setString(2, vo.getWdate());
			int r = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public int delete(String date) {
		// TODO Auto-generated method stub
		return 0;
	}
//날짜로 단건조회
	@Override
	public DiaryVO selectDate(String date) {
		DiaryVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql= " select * from diary where wdate= ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new DiaryVO();
				vo.setWdate(rs.getString("wdate"));
				vo.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}JdbcUtil.disconnect(conn);		
		return vo;
	}

	@Override
	public List<DiaryVO> selectContent(String content) {

		return null;
	}
//전체조회
	@Override
	public List<DiaryVO> selectAll() {
		ArrayList<DiaryVO> list = new ArrayList<DiaryVO>();
		DiaryVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql= " select * from diary order by wdate";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new DiaryVO();
				vo.setWdate(rs.getString("wdate"));
				vo.setContents(rs.getString("contents"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}JdbcUtil.disconnect(conn);		
		return list;
	}


}
