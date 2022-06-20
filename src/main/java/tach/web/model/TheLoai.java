package tach.web.model;

public class TheLoai {
	private int ID_TheLoai;
	private String TenTheLoai;
	
//	public TheLoai(String id_TheLoai, String tenTheLoai) {
//
//		ID_TheLoai = id_TheLoai;
//		TenTheLoai = tenTheLoai;
//	}
	
	public int getID_TheLoai() {
		return ID_TheLoai;
	}
	public void setID_TheLoai(int iD_TheLoai) {
		ID_TheLoai = iD_TheLoai;
	}
	public String getTenTheLoai() {
		return TenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}
	@Override
	public String toString() {
		return "TheLoai [ID_TheLoai=" + ID_TheLoai + ", TenTheLoai=" + TenTheLoai + "]";
	}

	

	
	
}
