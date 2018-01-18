package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunitiesTCRMView extends TCRMView{


	String getTextId();
	String getTextDate();
	String getTextSaleDescription();
	String getTextDollarQuantity();
	String getTextSaleStatus();
	
	void setTextId(String textId);
	void setTextDate(String textDate);
	void setTextSaleDescription(String textSaleDescription);
	void setTextDollarQuantity(String textDollarQuantity);
	void setTextSaleStatus(String textTelephoe);


	// TODO: Verify MVC compliance of these methods
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorDate();
	String getErrorSaleDescription();
	String getErrorDollarQuantity();
	String getErrorSaleStatus();

	
	void setErrorDate(String errorDate);
	void setErrorSaleDescription(String errorSaleDescription);
	void setErrorDollarQuantity(String errorDollarQuantity);
	void setErrorSaleStatus(String errorSaleStatus);
	

}