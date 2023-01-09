package classObject;

public abstract class People {
	
	private String nama, role;
	private int umur;
	
	public People(String nama, String role, int umur) {
		super();
		this.nama = nama;
		this.role = role;
		this.umur = umur;
	}
	
	public People() {
		// TODO Auto-generated constructor stub
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}
	
	public abstract void info();
	
	

}
