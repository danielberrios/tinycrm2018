package beans;

public class OpportunitiesBean extends CRMBean {

	private String saleDescription;
	private String dollarQuantity; //maybe it should be a double?
	private String date; //maybe should be stored in numbers? or like a string but we parse it?
	private long client;
//	private long saleStatus; //lo puse como long emulando lo de client, assuming que asi bregaria para hacer un drop down menu thing like the client thing
	private String saleStatus;
	
	public OpportunitiesBean(long id) {
		super(id);
		date = "";
		saleDescription = "";
		dollarQuantity = "";
		client = -1;
		saleStatus = "";
	}
	
	public String getSaleDescription() {
		return saleDescription;
	}

	public void setSaleDescription(String saleDescription) {
		this.saleDescription = saleDescription;
	}

	public String getDollarQuantity() {
		return dollarQuantity;
	}

	public void setDollarQuantity(String dollarQuantity) {
		this.dollarQuantity = dollarQuantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public long getClient() {
		return client;
	}
	
	public void setClient(long id) {
		this.client = id;
	}
	
	@Override
	public String getDescription() { 
		return saleDescription + "-" + saleStatus; 
	}
	
	public String toString() {
		return this.getId() + ": " + this.getSaleDescription() + " " + this.getSaleStatus();
	}
	
	public boolean equals(Object o) {
		if (o instanceof OpportunitiesBean) {
			OpportunitiesBean c = (OpportunitiesBean) o;
			return (c.getId() == this.getId());
		}
		return false;
	}
	
}