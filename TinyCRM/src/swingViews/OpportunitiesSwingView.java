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
	private JTextField textDescription;
	private JTextField textCost;
	private JComboBox<ClientForComboBox> comboBoxClient;
	private JTextField textStatus;

	private JLabel idLblError;
	private JLabel dateLblError;
	private JLabel DescriptionLblError;
	private JLabel CostLblError;
	private JLabel clientLblError;
	private JLabel StatusLblError;

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

		JLabel lblDate = new JLabel("Closing Date");
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

		JLabel lblDescription = new JLabel(" Description");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 4;
		centerGrid.add(lblDescription, gbc_lblDescription);

		textDescription = new JTextField();
		textDescription.setEditable(false);
		GridBagConstraints gbc_textDescription = new GridBagConstraints();
		gbc_textDescription.insets = new Insets(0, 0, 5, 0);
		gbc_textDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDescription.gridx = 1;
		gbc_textDescription.gridy = 4;
		centerGrid.add(textDescription, gbc_textDescription);
		textDescription.setColumns(10);

		DescriptionLblError = new JLabel("New label");
		DescriptionLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		DescriptionLblError.setForeground(Color.RED);
		GridBagConstraints gbc_DescriptionLblError = new GridBagConstraints();
		gbc_DescriptionLblError.anchor = GridBagConstraints.WEST;
		gbc_DescriptionLblError.insets = new Insets(0, 0, 5, 0);
		gbc_DescriptionLblError.gridx = 1;
		gbc_DescriptionLblError.gridy = 5;
		centerGrid.add(DescriptionLblError, gbc_DescriptionLblError);

		JLabel lblCost = new JLabel("Value/Cost");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 6;
		centerGrid.add(lblCost, gbc_lblCost);

		textCost = new JTextField();
		textCost.setEditable(false);
		GridBagConstraints gbc_textCost = new GridBagConstraints();
		gbc_textCost.insets = new Insets(0, 0, 5, 0);
		gbc_textCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCost.gridx = 1;
		gbc_textCost.gridy = 6;
		centerGrid.add(textCost, gbc_textCost);
		textCost.setColumns(10);

		CostLblError = new JLabel("New label");
		CostLblError.setForeground(Color.RED);
		CostLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_CostLblError = new GridBagConstraints();
		gbc_CostLblError.anchor = GridBagConstraints.WEST;
		gbc_CostLblError.insets = new Insets(0, 0, 5, 0);
		gbc_CostLblError.gridx = 1;
		gbc_CostLblError.gridy = 7;
		centerGrid.add(CostLblError, gbc_CostLblError);

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

		JLabel lblStatus = new JLabel(" Status");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.EAST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 10;
		centerGrid.add(lblStatus, gbc_lblStatus);

		textStatus = new JTextField();
		textStatus.setEditable(false);
		textStatus.setToolTipText("");
		GridBagConstraints gbc_textStatus = new GridBagConstraints();
		gbc_textStatus.insets = new Insets(0, 0, 5, 0);
		gbc_textStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStatus.gridx = 1;
		gbc_textStatus.gridy = 10;
		centerGrid.add(textStatus, gbc_textStatus);
		textStatus.setColumns(10);

		StatusLblError = new JLabel("New label");
		StatusLblError.setForeground(Color.RED);
		StatusLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		GridBagConstraints gbc_StatusLblError = new GridBagConstraints();
		gbc_StatusLblError.anchor = GridBagConstraints.WEST;
		gbc_StatusLblError.insets = new Insets(0, 0, 5, 0);
		gbc_StatusLblError.gridx = 1;
		gbc_StatusLblError.gridy = 11;
		centerGrid.add(StatusLblError, gbc_StatusLblError);

		this.setMessagesText("No Opportunities in the CRM"); 

	}

	public String getTextId()        { return textId.getText(); }
	public String getTextDate() { return textDate.getText(); }
	public String getTextDescription()  { return textDescription.getText(); }
	public String getTextCost()   { return textCost.getText(); }
	public String getTextStatus() { return textStatus.getText(); }

	public void setTextId(String textId)               { this.textId.setText(textId); }
	public void setTextDate(String textDate) { this.textDate.setText(textDate); }
	public void setTextDescription(String textDescription)   { this.textDescription.setText(textDescription); }
	public void setTextCost(String textCost)     { this.textCost.setText(textCost); }
	public void setTextStatus(String textStatus)  { this.textStatus.setText(textStatus); }
	
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
	public String getErrorDescription() { return DescriptionLblError.getText(); }
	public String getErrorCost()   { return CostLblError.getText(); }
	public String getErrorStatus() { return StatusLblError.getText(); }
	
	public void setErrorDate(String errorDate) { dateLblError.setText(errorDate); }
	public void setErrorDescription(String errorDescription)   { DescriptionLblError.setText(errorDescription); }
	public void setErrorCost(String errorCost)     { CostLblError.setText(errorCost); }
	public void setErrorStatus(String errorStatus) { StatusLblError.setText(errorStatus); }
	
	public void beanToForm(CRMBean bean) {
		OpportunitiesBean ob = (OpportunitiesBean) bean;
		this.setTextId(""+ob.getId());
		this.setTextDate(ob.getDate());
		this.setTextDescription(ob.getDescription());
		this.setTextCost(ob.getCost());
		for (int i=0; i < comboBoxClient.getItemCount(); i++) {
			ClientForComboBox item = comboBoxClient.getItemAt(i);
			if (item.getId() == ob.getId()) {
				this.setSelectedClientIndex(i);
			}
		}
		this.setTextStatus(ob.getStatus());
	}

	public void formToBean(CRMBean bean) {
		OpportunitiesBean ob = (OpportunitiesBean) bean;
		//cb.setId(Integer.parseInt(textId.getText()));  // Id is never editable
		ob.setDate(textDate.getText());
		ob.setDescription(textDescription.getText());
		ob.setCost(textCost.getText());
		ob.setClient(((ClientForComboBox) comboBoxClient.getSelectedItem()).getId());
		ob.setStatus(textStatus.getText());
	}

	public void enableEditMode() { 
		super.enableEditMode();
		//textId.setEditable(true);
		textDate.setEditable(true);
		textDescription.setEditable(true);
		textCost.setEditable(true);
		comboBoxClient.setEnabled(true);
		textStatus.setEditable(true);
	}
	
	public void disableEditMode() {
		super.disableEditMode();
		textId.setEditable(false);
		textDate.setEditable(false);
		textDescription.setEditable(false);
		textCost.setEditable(false);
		comboBoxClient.setEnabled(false);
		textStatus.setEditable(false);
	}

	public void clearForm() {
		textId.setText("");
		textDate.setText("");
		textDescription.setText("");
		textCost.setText("");
		if (comboBoxClient.getItemCount() > 0) { comboBoxClient.setSelectedIndex(0); }
		textStatus.setText("");
		clearFieldErrors();
	}

	public void clearFieldErrors() {
		idLblError.setText("");
		dateLblError.setText("");
		DescriptionLblError.setText("");
		CostLblError.setText("");
		clientLblError.setText("");
		StatusLblError.setText("");
	}
}