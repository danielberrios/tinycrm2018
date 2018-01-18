package swingViews;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import beans.CRMBean;
import beans.ContactBean;
import beans.OpportunitiesBean;
import swingViews.ContactSwingView.ClientForComboBox;
import views.OpportunitiesTCRMView;

public class OpportunitiesSwingView extends SwingView implements OpportunitiesTCRMView{

	private static final long serialVersionUID = 1L;

	protected class ClientForComboBox {

		private long id;
		private String description;

		protected long getId() {
			return id;
		}

		protected ClientForComboBox(long id, String description) {
			this.id = id;
			this.description = description;
		}

		protected String getDescription() {
			return description;
		}
		protected void setId(long id) {
			this.id = id;
		}
		protected void setDescription(String description) {
			this.description = description;
		}
		
		// toString() called by JComboBox to obtain display text for item
		public String toString() {
			return description;
		}
		
	}

	private JTextField textId;
	private JTextField textDate;
	private JTextField textSaleDescription;
	private JTextField textDollarQuantity;
	private JComboBox<ClientForComboBox> comboBoxClient;
	private JTextField textSaleStatus;

	private JLabel idLblError;
	private JLabel dateLblError;
	private JLabel saleDescriptionLblError;
	private JLabel dollarQuantityLblError;
	private JLabel clientLblError;
	private JLabel saleStatusLblError;

	/**
	 * Create the frame.
	 */
	public OpportunitiesSwingView() {
		super();
		setTitle("Opportunities");

		JScrollPane centerScrollPane = new JScrollPane();
		centerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		centerScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		setCenterPanel(centerScrollPane);

		JPanel centerGrid = new JPanel();
		centerScrollPane.setViewportView(centerGrid);
		GridBagLayout gbl_centerGrid = new GridBagLayout();
		gbl_centerGrid.columnWidths = new int[]{100, 475, 0};
		gbl_centerGrid.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,Double.MIN_VALUE};
		centerGrid.setLayout(gbl_centerGrid);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		centerGrid.add(lblId, gbc_lblId);

		textId = new JTextField();
		textId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		centerGrid.add(textId, gbc_txtId);
		textId.setColumns(10);

		idLblError = new JLabel("New label");
		idLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		idLblError.setForeground(Color.RED);
		GridBagConstraints gbc_IdLblError = new GridBagConstraints();
		gbc_IdLblError.anchor = GridBagConstraints.WEST;
		gbc_IdLblError.insets = new Insets(0, 0, 5, 0);
		gbc_IdLblError.gridx = 1;
		gbc_IdLblError.gridy = 1;
		centerGrid.add(idLblError, gbc_IdLblError);

		JLabel lblDate = new JLabel("  Estimated Closing Date");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.EAST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 2;
		centerGrid.add(lblDate, gbc_lblDate);

		textDate = new JTextField();
		textDate.setToolTipText("");
		textDate.setEditable(false);
		GridBagConstraints gbc_txtDate = new GridBagConstraints();
		gbc_txtDate.insets = new Insets(0, 0, 5, 0);
		gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDate.gridx = 1;
		gbc_txtDate.gridy = 2;
		centerGrid.add(textDate, gbc_txtDate);
		textDate.setColumns(10);

		dateLblError = new JLabel("New label");
		dateLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		dateLblError.setForeground(Color.RED);
		GridBagConstraints gbc_dateLblbError = new GridBagConstraints();
		gbc_dateLblbError.anchor = GridBagConstraints.WEST;
		gbc_dateLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_dateLblbError.gridx = 1;
		gbc_dateLblbError.gridy = 3;
		centerGrid.add(dateLblError, gbc_dateLblbError);

		JLabel lblSaleDescription = new JLabel("Sale Description");
		lblSaleDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblSaleDescription = new GridBagConstraints();
		gbc_lblSaleDescription.anchor = GridBagConstraints.EAST;
		gbc_lblSaleDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleDescription.gridx = 0;
		gbc_lblSaleDescription.gridy = 4;
		centerGrid.add(lblSaleDescription, gbc_lblSaleDescription);

		textSaleDescription = new JTextField();
		textSaleDescription.setEditable(false);
		GridBagConstraints gbc_textSaleDescription = new GridBagConstraints();
		gbc_textSaleDescription.insets = new Insets(0, 0, 5, 0);
		gbc_textSaleDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSaleDescription.gridx = 1;
		gbc_textSaleDescription.gridy = 4;
		centerGrid.add(textSaleDescription, gbc_textSaleDescription);
		textSaleDescription.setColumns(10);

		saleDescriptionLblError = new JLabel("New label");
		saleDescriptionLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		saleDescriptionLblError.setForeground(Color.RED);
		GridBagConstraints gbc_saleDescriptionLblError = new GridBagConstraints();
		gbc_saleDescriptionLblError.anchor = GridBagConstraints.WEST;
		gbc_saleDescriptionLblError.insets = new Insets(0, 0, 5, 0);
		gbc_saleDescriptionLblError.gridx = 1;
		gbc_saleDescriptionLblError.gridy = 5;
		centerGrid.add(saleDescriptionLblError, gbc_saleDescriptionLblError);

		JLabel lblDollarQuantity = new JLabel("Monetary Value ($)");
		GridBagConstraints gbc_lblDollarQuantity = new GridBagConstraints();
		gbc_lblDollarQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblDollarQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblDollarQuantity.gridx = 0;
		gbc_lblDollarQuantity.gridy = 6;
		centerGrid.add(lblDollarQuantity, gbc_lblDollarQuantity);

		textDollarQuantity = new JTextField();
		textDollarQuantity.setEditable(false);
		GridBagConstraints gbc_textDollarQuantity = new GridBagConstraints();
		gbc_textDollarQuantity.insets = new Insets(0, 0, 5, 0);
		gbc_textDollarQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDollarQuantity.gridx = 1;
		gbc_textDollarQuantity.gridy = 6;
		centerGrid.add(textDollarQuantity, gbc_textDollarQuantity);
		textDollarQuantity.setColumns(10);

		dollarQuantityLblError = new JLabel("New label");
		dollarQuantityLblError.setForeground(Color.RED);
		dollarQuantityLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_dollarQuantityLblError = new GridBagConstraints();
		gbc_dollarQuantityLblError.anchor = GridBagConstraints.WEST;
		gbc_dollarQuantityLblError.insets = new Insets(0, 0, 5, 0);
		gbc_dollarQuantityLblError.gridx = 1;
		gbc_dollarQuantityLblError.gridy = 7;
		centerGrid.add(dollarQuantityLblError, gbc_dollarQuantityLblError);

		JLabel lblClient = new JLabel("Client");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.EAST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 8;
		centerGrid.add(lblClient, gbc_lblClient);

		comboBoxClient = new JComboBox<ClientForComboBox>();
		comboBoxClient.setEditable(false);
		comboBoxClient.setEnabled(false);
		GridBagConstraints gbc_comboBoxClient = new GridBagConstraints();
		gbc_comboBoxClient.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClient.gridx = 1;
		gbc_comboBoxClient.gridy = 8;
		centerGrid.add(comboBoxClient, gbc_comboBoxClient);

		clientLblError = new JLabel("New label");
		clientLblError.setForeground(Color.RED);
		clientLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_clientLblError = new GridBagConstraints();
		gbc_clientLblError.anchor = GridBagConstraints.WEST;
		gbc_clientLblError.insets = new Insets(0, 0, 5, 0);
		gbc_clientLblError.gridx = 1;
		gbc_clientLblError.gridy = 9;
		centerGrid.add(clientLblError, gbc_clientLblError);
		//comboBoxClient.setColumns(10);

		JLabel lblSaleStatus = new JLabel("Sale Status");
		GridBagConstraints gbc_lblSaleStatus = new GridBagConstraints();
		gbc_lblSaleStatus.anchor = GridBagConstraints.EAST;
		gbc_lblSaleStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleStatus.gridx = 0;
		gbc_lblSaleStatus.gridy = 10;
		centerGrid.add(lblSaleStatus, gbc_lblSaleStatus);

		textSaleStatus = new JTextField();
		textSaleStatus.setEditable(false);
		textSaleStatus.setToolTipText("");
		GridBagConstraints gbc_textSaleStatus = new GridBagConstraints();
		gbc_textSaleStatus.insets = new Insets(0, 0, 5, 0);
		gbc_textSaleStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSaleStatus.gridx = 1;
		gbc_textSaleStatus.gridy = 10;
		centerGrid.add(textSaleStatus, gbc_textSaleStatus);
		textSaleStatus.setColumns(10);

		saleStatusLblError = new JLabel("New label");
		saleStatusLblError.setForeground(Color.RED);
		saleStatusLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_saleStatusLblError = new GridBagConstraints();
		gbc_saleStatusLblError.anchor = GridBagConstraints.WEST;
		gbc_saleStatusLblError.insets = new Insets(0, 0, 5, 0);
		gbc_saleStatusLblError.gridx = 1;
		gbc_saleStatusLblError.gridy = 11;
		centerGrid.add(saleStatusLblError, gbc_saleStatusLblError);

		this.setMessagesText("No Opportunities in the CRM"); 

	}

	public String getTextId()        { return textId.getText(); }
	public String getTextDate() { return textDate.getText(); }
	public String getTextSaleDescription()  { return textSaleDescription.getText(); }
	public String getTextDollarQuantity()   { return textDollarQuantity.getText(); }
	public String getTextSaleStatus() { return textSaleStatus.getText(); }

	public void setTextId(String textId)               { this.textId.setText(textId); }
	public void setTextDate(String textDate) { this.textDate.setText(textDate); }
	public void setTextSaleDescription(String textSaleDescription)   { this.textSaleDescription.setText(textSaleDescription); }
	public void setTextDollarQuantity(String textDollarQuantity)     { this.textDollarQuantity.setText(textDollarQuantity); }
	public void setTextSaleStatus(String textSaleStatus)  { this.textSaleStatus.setText(textSaleStatus); }
	
	public int getSelectedClientIndex() {
		return comboBoxClient.getSelectedIndex();
	}

	public void setSelectedClientIndex(int index) {
		if (index >= 0 && index <= comboBoxClient.getItemCount()) {
			comboBoxClient.setEnabled(false);
			comboBoxClient.setSelectedIndex(index);
			comboBoxClient.setEnabled(true);
		}
	}

	public void setSelectClientItems(ArrayList<CRMBean> list) {
		comboBoxClient.removeAllItems();
		for (CRMBean item : list) {
			comboBoxClient.addItem(new ClientForComboBox(item.getId(), item.getDescription()));
		}
	}

	public void setSelectClientListener(ActionListener listener) {
		comboBoxClient.addActionListener(listener);
	}

	public String getErrorDate() { return dateLblError.getText(); }
	public String getErrorSaleDescription() { return saleDescriptionLblError.getText(); }
	public String getErrorDollarQuantity()   { return dollarQuantityLblError.getText(); }
	public String getErrorSaleStatus() { return saleStatusLblError.getText(); }
	
	public void setErrorDate(String errorDate) { dateLblError.setText(errorDate); }
	public void setErrorSaleDescription(String errorSaleDescription)   { saleDescriptionLblError.setText(errorSaleDescription); }
	public void setErrorDollarQuantity(String errorDollarQuantity)     { dollarQuantityLblError.setText(errorDollarQuantity); }
	public void setErrorSaleStatus(String errorSaleStatus) { saleStatusLblError.setText(errorSaleStatus); }
	
	public void beanToForm(CRMBean bean) {
		OpportunitiesBean ob = (OpportunitiesBean) bean;
		this.setTextId(""+ob.getId());
		this.setTextDate(ob.getDate());
		this.setTextSaleDescription(ob.getSaleDescription());
		this.setTextDollarQuantity(ob.getDollarQuantity());
		for (int i=0; i < comboBoxClient.getItemCount(); i++) {
			ClientForComboBox item = comboBoxClient.getItemAt(i);
			if (item.getId() == ob.getId()) {
				this.setSelectedClientIndex(i);
			}
		}
		this.setTextSaleStatus(ob.getSaleStatus());
	}

	public void formToBean(CRMBean bean) {
		OpportunitiesBean ob = (OpportunitiesBean) bean;
		//cb.setId(Integer.parseInt(textId.getText()));  // Id is never editable
		ob.setDate(textDate.getText());
		ob.setSaleDescription(textSaleDescription.getText());
		ob.setDollarQuantity(textDollarQuantity.getText());
		ob.setClient(((ClientForComboBox) comboBoxClient.getSelectedItem()).getId());
		ob.setSaleStatus(textSaleStatus.getText());
	}

	public void enableEditMode() { 
		super.enableEditMode();
		//textId.setEditable(true);
		textDate.setEditable(true);
		textSaleDescription.setEditable(true);
		textDollarQuantity.setEditable(true);
		comboBoxClient.setEnabled(true);
		textSaleStatus.setEditable(true);
	}
	
	public void disableEditMode() {
		super.disableEditMode();
		textId.setEditable(false);
		textDate.setEditable(false);
		textSaleDescription.setEditable(false);
		textDollarQuantity.setEditable(false);
		comboBoxClient.setEnabled(false);
		textSaleStatus.setEditable(false);
	}

	public void clearForm() {
		textId.setText("");
		textDate.setText("");
		textSaleDescription.setText("");
		textDollarQuantity.setText("");
		if (comboBoxClient.getItemCount() > 0) { comboBoxClient.setSelectedIndex(0); }
		textSaleStatus.setText("");
		clearFieldErrors();
	}

	public void clearFieldErrors() {
		idLblError.setText("");
		dateLblError.setText("");
		saleDescriptionLblError.setText("");
		dollarQuantityLblError.setText("");
		clientLblError.setText("");
		saleStatusLblError.setText("");
	}
}