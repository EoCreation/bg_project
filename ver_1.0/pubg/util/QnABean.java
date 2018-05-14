package pubg.util;

import java.io.File;

public class QnABean {

	private int regno ;   //�ۼ���
	private String user_id; //���̵� 
	private String no_title; //����
	private String no_text; //�ؽ�Ʈ
	private String email; //�̸���
	private String no_date;

	public String getNo_date() {
		return no_date;
	}


	public void setNo_date(String no_date) {
		this.no_date = no_date;
	}
	private String textReturn; //���
	private File imageFile; //�̹��� ����


	public void setFile(String stc) {

	}


	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_text() {
		return no_text;
	}
	public void setNo_text(String no_text) {
		this.no_text = no_text;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTextReturn() {
		return textReturn;
	}
	public void setTextReturn(String textReturn) {
		this.textReturn = textReturn;
	}



}
