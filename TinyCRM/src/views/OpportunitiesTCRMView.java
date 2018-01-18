package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;

public interface OpportunitiesTCRMView extends TCRMView{


	String getTextId();
	String getTextDate();
	String getTextDescription();
	String getTextDollarQuantity();
	String getTextStatus();
	
	void setTextId(String textId);
	void setTextDate(String textDate);
	void setTextDescription(String textDescription);
	void setTextDollarQuantity(String textDollarQuantity);
	void setTextStatus(String textTelephoe);


	// TODO: Verify MVC compliance of these methods
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorDate();
	String getErrorDescription();
	String getErrorDollarQuantity();
	String getErrorStatus();

	
	void setErrorDate(String errorDate);
	void setErrorDescription(String errorDescription);
	void setErrorDollarQuantity(String errorDollarQuantity);
	void setErrorStatus(String errorStatus);
	

}