package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.OpportunitiesBean;

public class OpportunitiesModel extends CRMModel {

	private static String OPPORTUNITIES_FILE = "data/opportunities.tsv";

	public OpportunitiesModel() {
		super();
	}
	
	@Override
	public void doInit() {
		super.doInit();
		ArrayList<CRMBean> beans = parseBeansFromFile(OPPORTUNITIES_FILE);
		this.setList(beans);
		this.setIndex(0);
	}

//	@Override
//	public void doLeft() {
//		super.doLeft();
//	}

//	@Override
//	public void doRight() {
//		super.doRight();
//	}

	@Override
	public void doEdit() {
		super.doEdit();
	}

	@Override
	public void doAdd() {
		long id = 1;
		if (this.getCount() > 0) {
			id = ((OpportunitiesBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.getAllBeans().add(new OpportunitiesBean(id));
		this.setIndex(this.getCount() - 1);  
	}

//	@Override
//	public void doDelete() {
//		super.doDelete();
//	}

	@Override
	public void doSave() {
		super.doSave();
		saveBeansToFile(OPPORTUNITIES_FILE);
	}
	
//	@Override
//	public void doCancel() {
//		super.doCancel();
//	}

	public ArrayList<CRMBean> parseBeansFromFile(String filename) {
		File inputFile = new File(filename);
		try {
			ArrayList<CRMBean> opportunitiesBeans = new ArrayList<CRMBean>();
			Scanner inputScanner = new Scanner(inputFile);
			inputScanner.nextLine();  // Ignore header line
			int count = 0;
			inputScanner.useDelimiter("[\t\n]");
			while (inputScanner.hasNextLine()) { 
				String ID = inputScanner.next();
				int id = Integer.parseInt(ID);
				OpportunitiesBean newBean = new OpportunitiesBean(id);
				String date = inputScanner.next();
				newBean.setDate(date);
				String Description = inputScanner.next();
				newBean.setDescription(Description);
				String Cost = inputScanner.next();
				newBean.setCost(Cost);
//				String client = inputScanner.next();
//				int clientId = Integer.parseInt(client);
//				newBean.setClient(clientId);
				String Status = inputScanner.next();
				newBean.setStatus(Status);
				inputScanner.nextLine(); 
				opportunitiesBeans.add(newBean);
				count++;
			}
			inputScanner.close();
			return opportunitiesBeans;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input file not Found");
		}
	}
	
	public String beanToFileLine(CRMBean bean) {

		String result = "";
		OpportunitiesBean ob = (OpportunitiesBean) bean;
		result += ob.getId();
		result += '\t';
		result += ob.getDate();
		result += '\t';
		result += ob.getDescription();
		result += '\t';
		result += ob.getCost();
		result += '\t';
//		if (ob.getClient() < 0) {
//			result += "-1";
//		}
//		else {
//			result += ""+ob.getClient();
//		}
//		result += '\t';
		result += ob.getStatus();
		return result;
		
	}

	public void saveBeansToFile(String filename) {
		
		ArrayList<CRMBean> opportunitiesBeans = getAllBeans();
		File outputFile = new File(filename);
		try {
			PrintWriter out = new PrintWriter(outputFile);
			// Print Header Line
			out.println("TinyCRM Opportunities data file");
			for (CRMBean bean : opportunitiesBeans) {
				out.println(beanToFileLine(bean));
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output file not Found");
		}
	}

}
