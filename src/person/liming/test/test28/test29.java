package person.liming.test.test28;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliming
 * @Description ʹ��jdbc���в�ѯ
 */
public class test29 {
	
	public static void main(String[] args) {
		QuestionDAO question = new QuestionDAO();
		List<Object> re = new ArrayList<Object>();
		
		String[] strs = {"name", "group_id"};
		try {
			question.getConnection();
			re = question.querySingle("select * from q_group where group_id = 5", strs);
			System.out.println(re.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
