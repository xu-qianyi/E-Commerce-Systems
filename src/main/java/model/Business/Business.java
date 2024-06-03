/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.ArrayList;

import SolutionOrders.MasterSolutionOrderList;
import SolutionOrders.SolutionOfferCatalog;
import model.CustomerManagement.CustomerDirectory;
import model.MarketingManagement.ChannelCatalog;
import model.MarketingManagement.MarketCatalog;
import model.MarketingManagement.MarketChannelComboCatalog;
// import MarketModel.MarketChannelComboCatalog;
// import MarketModel.SolutionOfferCatalog;
// import OrderManagement.MasterOrderList;
import model.MarketingManagement.MarketingPersonDirectory;
import model.OrderManagement.MasterOrderList;
import model.Personnel.EmployeeDirectory;
import model.Personnel.PersonDirectory;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;

import model.SalesManagement.SalesPersonDirectory;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

  String name;

  PersonDirectory persondirectory;
  MasterOrderList masterorderlist;
  CustomerDirectory customers;
  SupplierDirectory suppliers;
  MarketCatalog marketcatalog;
  ChannelCatalog channelcatalog;
  MarketChannelComboCatalog marketChannelComboCatalog;
  SolutionOfferCatalog solutionoffercatalog;
  CustomerDirectory customerdirectory;
  SalesPersonDirectory salespersondirectory;
  UserAccountDirectory useraccountdirectory;
  MasterSolutionOrderList mastersolutionorderlist;

  // MarketingPersonDirectory marketingpersondirectory;
  // EmployeeDirectory employeedirectory; 旧model

  public Business(String n) {
    name = n;
    masterorderlist = new MasterOrderList();
    suppliers = new SupplierDirectory();
    // solutionoffercatalog = new SolutionOfferCatalog();
    persondirectory = new PersonDirectory();
    customerdirectory = new CustomerDirectory(this);
    salespersondirectory = new SalesPersonDirectory(this);
    useraccountdirectory = new UserAccountDirectory();

    marketcatalog = new MarketCatalog();
    channelcatalog = new ChannelCatalog();

    // // Channel c = channelcatalog.newChannel("tv");
    // // market.addValidChannel(c);
    // // c = channelcatalog.newChannel("");

    marketChannelComboCatalog = new MarketChannelComboCatalog();
    // MarketChannelAssignment mca2 =
    // marketChannelComboCatalog.newMarketChannelCombo(market, c);

    solutionoffercatalog = new SolutionOfferCatalog();
    mastersolutionorderlist = new MasterSolutionOrderList();

    // marketingpersondirectory = new MarketingPersonDirectory(this);
    // employeedirectory = new EmployeeDirectory(this); 旧model
  }

  public int getSalesVolume() {
    return masterorderlist.getSalesVolume();
  }

  public PersonDirectory getPersonDirectory() {
    return persondirectory;
  }

  public UserAccountDirectory getUserAccountDirectory() {
    return useraccountdirectory;
  }

  // public MarketingPersonDirectory getMarketingPersonDirectory() {
  // return marketingpersondirectory;
  // }

  public SupplierDirectory getSupplierDirectory() {
    return suppliers;
  }

  public ProductsReport getSupplierPerformanceReport(String n) {
    Supplier supplier = suppliers.findSupplier(n);
    if (supplier == null) {
      return null;
    }
    return supplier.prepareProductsReport();
  }

  public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(
      String n) {
    ProductsReport productsreport = getSupplierPerformanceReport(n);
    return productsreport.getProductsAlwaysAboveTarget();
  }

  public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
    ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
    int i = productsreport.getProductsAlwaysAboveTarget().size(); // return size of the arraylist
    return i;
  }

  public CustomerDirectory getCustomerDirectory() {
    return customerdirectory;
  }

  public SalesPersonDirectory getSalesPersonDirectory() {
    return salespersondirectory;
  }

  public MasterOrderList getMasterOrderList() {
    return masterorderlist;
  }

  // public EmployeeDirectory getEmployeeDirectory() {
  // return employeedirectory;
  // }

  public MarketCatalog getMarketCatalog() {
    return marketcatalog;
  }

  public ChannelCatalog getChannelCatalog() {
    return channelcatalog;
  }

  public MarketChannelComboCatalog getMarketChannelComboCatalog() {
    return marketChannelComboCatalog;
  }

  public void setMarketChannelComboCatalog(MarketChannelComboCatalog marketChannelComboCatalog) {
    this.marketChannelComboCatalog = marketChannelComboCatalog;
  }

  public SolutionOfferCatalog getSolutionofferCatalog() {
    return solutionoffercatalog;
  }

  public MasterSolutionOrderList getMastersolutionorderlist() {
    return mastersolutionorderlist;
  }

  public String getName() {
    return name;
  }
}
