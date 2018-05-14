package pubg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * 2018-05-13
 * 
 * @author BeakJongHun
 *
 */
public class QnASQL {

	private PreparedStatement stmt;
	private ResultSet rs;
	private int max_count = 0;

	/**
	 * QnA �� ����Ʈ
	 * 
	 * @return
	 */
	public Vector<QnABean> SelectAll() {

		DBCon dbCon = new DBCon();
		Connection conn = null;
		Vector<QnABean> vc = new Vector<QnABean>();
		String sql = "select  * from qa_border";

		try {

			conn = DriverManager.getConnection(dbCon.getJDBC_URL(), dbCon.getID(), dbCon.getPASS());
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			for (int i = 0; i < 20; i++) {
				if (rs.next()) {

					QnABean qnABean = new QnABean();
					qnABean.setRegno(rs.getInt(1));
					qnABean.setUser_id(rs.getString("User_id"));
					qnABean.setNo_title(rs.getString("qa_title"));
					qnABean.setNo_date(rs.getString("qa_date"));
					qnABean.setNo_text(rs.getString("qa_text"));
					qnABean.setTextReturn(rs.getString("qa_reply"));
					qnABean.setEmail(rs.getString("email"));

					vc.add(qnABean);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e);
			// TODO: handle exception
		} finally {
			dbCon.dbClose(rs, stmt, conn);
		}

		return vc;
	}

}
