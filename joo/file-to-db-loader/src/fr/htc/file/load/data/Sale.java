package fr.htc.file.load.data;

public class Sale {

	private int id;
	private int qty;
	private float unitSale;
	private String productId;

	// Getters & Setters


	public int getId() {
		return id;
	}

	public Sale(int id, int qty, float unitSale, String productId) {
		super();
		this.id = id;
		this.qty = qty;
		this.unitSale = unitSale;
		this.productId = productId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getUnitSale() {
		return unitSale;
	}

	public void setUnitSale(float unitSale) {
		this.unitSale = unitSale;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAsInsertStatement() {
		StringBuilder sqlQuery = new StringBuilder("INSERT INTO SALE VALUES (");

		sqlQuery.append(this.id + ",");
		sqlQuery.append(this.qty + ",");
		sqlQuery.append(this.unitSale + ",");
		sqlQuery.append("'" + this.productId + "')");
		return sqlQuery.toString();
	}

}
