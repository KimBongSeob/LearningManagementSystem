package student.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import classplan.DTO.ClassplanDataBean;
import jdbc.ConnectionProvider;
import jdbc.jdbcUtil;
import student.DAO.StudentDao;

//로그인한 학생이 수강신청한 강의계획서 select service
public class SelectClassbasketClassplanService {
	private static SelectClassbasketClassplanService instance = new SelectClassbasketClassplanService();
	
	public static SelectClassbasketClassplanService getInstance(){
		return instance;
	}
	private SelectClassbasketClassplanService(){}
	public List<ClassplanDataBean> getItemList(String SD_NUM){

		StudentDao studentDao = StudentDao.getInstance();
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			List<ClassplanDataBean> itemList = studentDao.selectClassbasketClassplan(conn, SD_NUM);
			return itemList;
		}catch(SQLException e){
			throw new RuntimeException("DB 에러:"+e.getMessage(), e);
		}finally{
			jdbcUtil.close(conn);
		}
	}
}
