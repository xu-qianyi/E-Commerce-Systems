/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

import java.util.Scanner;

import SolutionOrders.MasterSolutionOrderList;
import SolutionOrders.SolutionOffer;
import SolutionOrders.SolutionOfferCatalog;
import SolutionOrders.SolutionOrder;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.MarketingManagement.Channel;
import model.MarketingManagement.ChannelCatalog;
import model.MarketingManagement.MarketCatalog;
import model.MarketingManagement.MarketChannelComboCatalog;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  public static Business loadBusiness() {

    // create business
    Business business = new Business("Ssense");

    System.out
        .println("\n\033[1;36mWelcome to " + business.getName() + "! Your most reliable online bag purchase platform!");
    System.out.println("\033[1;33mWe offer you the best shopping experience with different budgets.");
    System.out.println("\033[1;31mPlease first let us know you a little bit more.\n");

    // create person
    PersonDirectory persondirectory = business.getPersonDirectory();

    // person representing sales organization
    Person salesPerson = persondirectory.newPerson("Ssense_sales");
    Person marketingperson = persondirectory.newPerson("Ssense_marketing");
    Person adminperson001 = persondirectory.newPerson("Ssense_admin");

    // create customers
    Person marttaPerson = persondirectory.newPerson("Martta");
    Person lilyPerson = persondirectory.newPerson("Lily");
    Person lindaPerson = persondirectory.newPerson("Linda");
    Person melodyPerson = persondirectory.newPerson("Melody");
    Person sandyPerson = persondirectory.newPerson("Sandy");

    // create customer profiles
    CustomerDirectory customerdirectory = business.getCustomerDirectory();
    CustomerProfile customerprofile1 = customerdirectory.newCustomerProfile(marttaPerson);
    CustomerProfile customerprofile2 = customerdirectory.newCustomerProfile(lilyPerson);
    CustomerProfile customerprofile3 = customerdirectory.newCustomerProfile(lindaPerson);
    CustomerProfile customerprofile4 = customerdirectory.newCustomerProfile(melodyPerson);
    CustomerProfile customerprofile5 = customerdirectory.newCustomerProfile(sandyPerson);

    // create sales people
    SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
    SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(salesPerson);

    // creat suppliers
    SupplierDirectory supplierdirectory = business.getSupplierDirectory();

    Supplier hermesSupplier = supplierdirectory.newSupplier("Hermes");
    ProductCatalog productcatalogHermes = hermesSupplier.getProductCatalog();
    Product birkin = productcatalogHermes.newProduct("Birkin", 10020, 120090, 200300);
    Product kelly = productcatalogHermes.newProduct("Kelly", 10000, 20000, 30000);
    Product lindy = productcatalogHermes.newProduct("Lindy", 9000, 12000, 15000);

    Supplier channelSupplier = supplierdirectory.newSupplier("Channel");
    ProductCatalog productcatalogChannel = channelSupplier.getProductCatalog();
    Product leboy = productcatalogChannel.newProduct("LeBoy", 5000, 6000, 7000);
    Product gabrielle = productcatalogChannel.newProduct("Gabrielle", 3400, 4500, 5600);
    Product Canvas = productcatalogChannel.newProduct("Canvas", 2700, 3600, 4500);
    Product coco = productcatalogChannel.newProduct("Coco", 9100, 12000, 15000);

    Supplier coachSupplier = supplierdirectory.newSupplier("Coach");
    ProductCatalog productcatalogCoach = coachSupplier.getProductCatalog();
    Product williow = productcatalogCoach.newProduct("Willow", 400, 500, 600);
    Product tabby = productcatalogCoach.newProduct("Tabby", 670, 780, 890);
    Product tote = productcatalogCoach.newProduct("Tote", 340, 470, 600);
    Product madison = productcatalogCoach.newProduct("Madison", 790, 890, 990);
    Product bonnie = productcatalogCoach.newProduct("Bonnie", 660, 760, 860);

    // create markets and channels

    MarketCatalog mc = business.getMarketCatalog();
    Market luxuryMarket = mc.newMarket("Luxury Market");
    Market midRangeMarket = mc.newMarket("Mid-range Market");
    Market lowEndMarket = mc.newMarket("Low-end Market");

    ChannelCatalog channelcatalog = business.getChannelCatalog();
    Channel privateSaleChannel = channelcatalog.newChannel("private");
    Channel shoppingMallChannel = channelcatalog.newChannel("shopping mall");
    Channel outletsChannel = channelcatalog.newChannel("outlets");

    luxuryMarket.addValidChannel(privateSaleChannel);
    luxuryMarket.addValidChannel(shoppingMallChannel);
    luxuryMarket.addValidChannel(outletsChannel);

    midRangeMarket.addValidChannel(privateSaleChannel);
    midRangeMarket.addValidChannel(shoppingMallChannel);
    midRangeMarket.addValidChannel(outletsChannel);

    lowEndMarket.addValidChannel(privateSaleChannel);
    lowEndMarket.addValidChannel(shoppingMallChannel);
    lowEndMarket.addValidChannel(outletsChannel);

    // create market-channel assignments
    MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();

    MarketChannelAssignment email_privateSaleChannel = mccc.newMarketChannelCombo(luxuryMarket, privateSaleChannel);
    email_privateSaleChannel.setAdbudget(60000);
    MarketChannelAssignment email_shoppingmallChannel = mccc.newMarketChannelCombo(luxuryMarket, shoppingMallChannel);
    email_shoppingmallChannel.setAdbudget(40000);
    MarketChannelAssignment email_outletsChannel = mccc.newMarketChannelCombo(luxuryMarket, outletsChannel);
    email_outletsChannel.setAdbudget(300000);
    MarketChannelAssignment youtube_privatesaleChannel = mccc.newMarketChannelCombo(midRangeMarket, privateSaleChannel);
    youtube_privatesaleChannel.setAdbudget(30000);
    MarketChannelAssignment youtube_shoppingmallChannel = mccc.newMarketChannelCombo(midRangeMarket,
        shoppingMallChannel);
    youtube_shoppingmallChannel.setAdbudget(20000);
    MarketChannelAssignment youtube_outletsChannel = mccc.newMarketChannelCombo(midRangeMarket, outletsChannel);
    youtube_outletsChannel.setAdbudget(10000);
    MarketChannelAssignment tiktok_privatesaleChannel = mccc.newMarketChannelCombo(lowEndMarket, privateSaleChannel);
    tiktok_privatesaleChannel.setAdbudget(4000);
    MarketChannelAssignment tiktok_shoppingmallChannel = mccc.newMarketChannelCombo(lowEndMarket, shoppingMallChannel);
    tiktok_shoppingmallChannel.setAdbudget(3000);
    MarketChannelAssignment tiktok_outletsChannel = mccc.newMarketChannelCombo(lowEndMarket, outletsChannel);
    tiktok_outletsChannel.setAdbudget(2000);

    // create solution offers: bundles of products
    SolutionOfferCatalog solutionoffercatalog = business.getSolutionofferCatalog();

    SolutionOffer solutionEP = solutionoffercatalog.newSolutionOffer(email_privateSaleChannel);
    solutionEP.addProduct(lindy);
    solutionEP.addProduct(birkin);
    solutionEP.addProduct(kelly);
    solutionEP.setTotalPrice(245300);

    solutionEP.setAd("Ads for private sales customers from Email promotion channel who is targeted at luxury market.");

    SolutionOffer solutionES = solutionoffercatalog.newSolutionOffer(email_shoppingmallChannel);
    solutionES.addProduct(lindy);
    solutionES.addProduct(birkin);
    solutionES.addProduct(kelly);
    solutionES.setTotalPrice(152090);
    solutionES.setAd("Ads for shopping mall customers from Email promotion who is targeted at mid-range market.");

    SolutionOffer solutionEO = solutionoffercatalog.newSolutionOffer(email_outletsChannel);
    solutionEO.addProduct(lindy);
    solutionEO.addProduct(birkin);
    solutionEO.addProduct(kelly);
    solutionEO.setTotalPrice(29020);
    solutionEO.setAd("Ads for outlets customers from Email promotion who is targeted at low-end market.");

    SolutionOffer solutionYP = solutionoffercatalog.newSolutionOffer(youtube_privatesaleChannel);
    solutionYP.addProduct(coco);
    solutionYP.addProduct(leboy);
    solutionYP.addProduct(Canvas);
    solutionYP.setTotalPrice(26500);
    solutionYP.setAd("Ads for private sale customers from Youtube who is targeted at luxury market.");

    SolutionOffer solutionYS = solutionoffercatalog.newSolutionOffer(youtube_shoppingmallChannel);
    solutionYS.addProduct(coco);
    solutionYS.addProduct(leboy);

    solutionYS.addProduct(gabrielle);
    solutionYS.setTotalPrice(22500);
    solutionYS.setAd("Ads for shopping mall customers from Youtube who is targeted at mid-range market.");

    SolutionOffer solutionYO = solutionoffercatalog.newSolutionOffer(youtube_outletsChannel);
    solutionYO.addProduct(coco);
    solutionYO.addProduct(leboy);
    solutionYO.addProduct(gabrielle);
    solutionYO.setTotalPrice(17500);
    solutionYO.setAd("Ads for outlets customers from Youtube who is targeted at low-end market.");

    SolutionOffer solutionTP = solutionoffercatalog.newSolutionOffer(tiktok_privatesaleChannel);
    solutionTP.addProduct(tote);
    solutionTP.addProduct(tabby);
    solutionTP.addProduct(madison);
    solutionTP.setTotalPrice(2480);
    solutionTP.setAd("Ads for private sales customers from TIKTOK who is targeted at luxury market.");

    SolutionOffer solutionTS = solutionoffercatalog.newSolutionOffer(tiktok_shoppingmallChannel);
    solutionTS.addProduct(tote);
    solutionTS.addProduct(tabby);
    solutionTS.addProduct(williow);
    solutionTS.setTotalPrice(1750);
    solutionTS.setAd("Ads for shopping mall customers from TIKTOK who is targeted at mid-range market.");

    SolutionOffer solutionTO = solutionoffercatalog.newSolutionOffer(tiktok_outletsChannel);
    solutionTO.addProduct(tote);
    solutionTO.addProduct(tabby);
    solutionTO.addProduct(bonnie);
    solutionTO.setTotalPrice(1670);
    solutionTO.setAd("Ads for outlets customers from TIKTOK who is targeted at low-end market.");

    // create orders for different type of customers through different bundles
    MasterSolutionOrderList msol = business.getMastersolutionorderlist();

    String customerInput = "";
    String budgetInput = "";
    String channelInput = "";
    Scanner scan = new Scanner(System.in);
    System.out.println("\u001B[30mPlease input your name:______\u001B[0m");
    customerInput = scan.nextLine();

    for (CustomerProfile csp : customerdirectory.getCustomerlist()) {
      if (csp.getCustomerId().equalsIgnoreCase(customerInput)) {

        System.out.println(
            "\u001B[33m\nDear " + customerInput + ", Please input your budget total:_____($1000~$250000)\u001B[0m");
        budgetInput = scan.nextLine();
        int i = Integer.valueOf(budgetInput).intValue();
        System.out.println();
        System.out.println("\u001B[31mWhere did you see our ads?(email/youtube/tiktok)\u001B[0m");
        channelInput = scan.nextLine();
        // scan.close();
        System.out.println();

        // highlevel market
        if (i >= 150000) {
          csp.setCustomerType("private sale");
          if (channelInput.equals("email")) {

            SolutionOrder SH = msol.newSolutionOrder(solutionEP, email_privateSaleChannel);
            csp.addSolutionOrder(SH);
            solutionEP.addSolutionOrder(SH);

            System.out.println(solutionEP.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionEP.getProducts()) {
              System.out.println(p.getName());
            }

          } else if (channelInput.equals("youtube")) {

            SolutionOrder TH = msol.newSolutionOrder(solutionYP, youtube_privatesaleChannel);
            csp.addSolutionOrder(TH);
            solutionYP.addSolutionOrder(TH);

            System.out.println(solutionYP.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionYP.getProducts()) {
              System.out.println(p.getName());
            }

          } else if (channelInput.equals("tiktok")) {
            SolutionOrder BH = msol.newSolutionOrder(solutionTP, tiktok_privatesaleChannel);
            csp.addSolutionOrder(BH);
            solutionTP.addSolutionOrder(BH);

            System.out.println(solutionTP.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionTP.getProducts()) {
              System.out.println(p.getName());
            }

          }

        }
        // mid-range market
        else if (i > 20000 && i < 150000) {
          csp.setCustomerType("shopping mall");
          if (channelInput.equals("email")) {
            SolutionOrder SA = msol.newSolutionOrder(solutionES, email_shoppingmallChannel);
            csp.addSolutionOrder(SA);
            solutionES.addSolutionOrder(SA);

            System.out.println(solutionES.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionES.getProducts()) {
              System.out.println(p.getName());
            }

          } else if (channelInput.equals("youtube")) {
            SolutionOrder TA = msol.newSolutionOrder(solutionYS, youtube_shoppingmallChannel);
            csp.addSolutionOrder(TA);
            solutionYS.addSolutionOrder(TA);

            System.out.println(solutionYS.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionYS.getProducts()) {
              System.out.println(p.getName());
            }

          } else if (channelInput.equals("tiktok")) {
            SolutionOrder BA = msol.newSolutionOrder(solutionTS, tiktok_shoppingmallChannel);
            csp.addSolutionOrder(BA);
            solutionTS.addSolutionOrder(BA);

            System.out.println(solutionTS.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionTS.getProducts()) {
              System.out.println(p.getName());
            }

          }
        }
        // low-end market
        else {
          csp.setCustomerType("outlets");
          if (channelInput.equals("email")) {
            SolutionOrder SL = msol.newSolutionOrder(solutionEO, email_outletsChannel);
            csp.addSolutionOrder(SL);
            solutionEO.addSolutionOrder(SL);

            System.out.println(solutionEO.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionEO.getProducts()) {
              System.out.println(p.getName());
            }

          } else if (channelInput.equals("youtube")) {
            SolutionOrder TL = msol.newSolutionOrder(solutionYO, youtube_outletsChannel);
            csp.addSolutionOrder(TL);
            solutionYO.addSolutionOrder(TL);

            System.out.println(solutionYO.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionYO.getProducts()) {
              System.out.println(p.getName());
            }

          } else if (channelInput.equals("tiktok")) {
            SolutionOrder BL = msol.newSolutionOrder(solutionTO, tiktok_outletsChannel);
            csp.addSolutionOrder(BL);
            solutionTO.addSolutionOrder(BL);

            System.out.println(solutionTO.getAd());
            System.out.println();
            System.out.println("\u001B[30mYour recommended choices are:\u001B[0m");
            for (Product p : solutionTO.getProducts()) {
              System.out.println(p.getName());
            }

          }
        }

      } else {
        System.out.print("");
      }
    }

    // Create and generate reports to enable management to know sales revenues by
    // market, channel, ads, and solution bundles.
    // start interacting with user

    System.out.println("do you want to print the report(yes/no):");
    String inputString = scan.nextLine();
    // System.out.println(inputString);
    scan.close();

    if ("yes".equals(inputString)) {
      System.out.println("\u001B[1;31mThe sales report of SSENSE is as follows:\u001B[0m\n");
      for (Market m : business.getMarketCatalog().getMarkets()) {
        String name = m.getName();
        int marketTotalR = business.getMastersolutionorderlist().getRevenueByMarket(m);
        System.out.println("\u001B[35m\nMarket: " + name + "\n\u001B[0m");

        for (Channel c : m.getValidchannels()) {
          String channeltype = c.getChannelType();
          int channelrevenue = business.getMastersolutionorderlist().getRevenueByChannel(c);
          int comborevenue = business.getMastersolutionorderlist()
              .getRevenueByMarketChannelCombo(business.getMarketChannelComboCatalog().finMarketChannelCombo(m, c));

          System.out.println("Channel: " + channeltype);
          System.out.println("Total Channel Revenue: " + channelrevenue);
          System.out.println("Total Combo Revenue: " + comborevenue);
          System.out.println();
        }
        System.out.println("\u001B[33mTotal " + name + " market Revenue: " + marketTotalR + "\u001B[0m");

      }
    } else {
      System.out.println("\u001B[1;31mThank you for your time!\u001B[0m");
    }
    return business;

  }

}
