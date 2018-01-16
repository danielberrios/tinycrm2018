package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.ClientBean;

public class OpportunitiesModel extends CRMModel {

		private static String OPORTUNITIES_FILE = "data/clients.tsv";

		public OpportunitiesModel() {
			super();
		}
		
		@Override
		public void doInit() {
			super.doInit();
			ArrayList<CRMBean> beans = parseBeansFromFile(OPORTUNITIES_FILE);
			this.setList(beans);
			setIndex(0);	}

//		@Override
//		public void doLeft() {
//			super.doLeft();
//		}

//		@Override
//		public void doRight() {
//			super.doRight();
//		}

//		@Override
//		public void doEdit() {
//			super.doEdit();
//		}

		@Override
		public void doAdd() {
			long id = 1;
		}

		@Override
		public void doSave() {
			super.doSave();
		}
		
		public ArrayList<CRMBean> parseBeansFromFile(String filename) {
			File inputFile = new File(filename);
			try {
				ArrayList<CRMBean> contactBeans = new ArrayList<CRMBean>();
				Scanner inputScanner = new Scanner(inputFile);
				inputScanner.nextLine();  // Ignore header line
				int count = 0;
				inputScanner.useDelimiter("[\t\n]");
				while (inputScanner.hasNextLine()) {
					String ID = inputScanner.next();
					int id = Integer.parseInt(ID);
					ClientBean newBean = new ClientBean(id);
					String company = inputScanner.next();
					newBean.setCompany(company);
					String telephone = inputScanner.next();
					newBean.setTelephone(telephone);
					String email = inputScanner.next();
					newBean.setEmail(email);
					String website = inputScanner.next();
					newBean.setWebsite(website);
					String facebook = inputScanner.next();
					newBean.setFacebook(facebook);
					inputScanner.nextLine();  // Skip over anything left in line
					contactBeans.add(newBean);
					count++;
				}
				inputScanner.close();
				return contactBeans;
			}
			catch (FileNotFoundException e) {
				throw new RuntimeException("Fatal Error: Input file not Found");
			}
		}
		
		public void saveBeansToFile(String filename) {
			
			ArrayList<CRMBean> contactBeans = getAllBeans();
			File outputFile = new File(filename);
			try {
				PrintWriter out = new PrintWriter(outputFile);
				// Print Header Line
				out.println("TinyCRM Clients data file");
				for (CRMBean bean : contactBeans) {
					out.println(beanToFileLine(bean));
				}
				out.close();
			}
			catch (FileNotFoundException e) {
				throw new RuntimeException("Fatal Error: Output file not Found");
			}
		}
		
		public String beanToFileLine(CRMBean bean) {

			String result = "";
			ClientBean cb = (ClientBean) bean;
			result += cb.getId();
			result += '\t';
			result += cb.getCompany();
			result += '\t';
			result += cb.getTelephone();
			result += '\t';
			result += cb.getEmail();
			result += '\t';
			result += cb.getWebsite();
			result += '\t';
			result += cb.getFacebook();
			return result;
			
		}

	}
