package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jdbc.mybatis.SqlMapConfig;

public class ProductDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	Boolean flag = false;
	
	// 입력받은 pname(상품명) 이 DB에 있는지 확인
	public Boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.selectOne("pdt.already", pname);
			if(result > 0) {
				flag = true;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
			
	}
	public void CntPlusPdt(String pname, int cnt) {
		try {
			HashMap <String , Object> map = new HashMap<>();
			map.put("pname", pname);
			map.put("cnt", cnt);
			map.put("flag", 1);
			int result = sqlSession.update("changePname", map);

			if(result > 0) {
				System.out.println("▦▦▦▦▦▦ " + cnt +"을 추가 성공 하였습니다.");
			} else {
				System.out.println("▦▦▦▦▦▦ 추가 실패하였습니다. 관리자에게 문의해주세요. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	public void insertPdt(String pname ,String company, int price, int cnt) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
