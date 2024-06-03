package SolutionOrders;

import java.util.ArrayList;

import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.Product;

public class SolutionOffer {
    ArrayList<Product> products;

    int price;// floor, ceiling, and target
    String ad;
    MarketChannelAssignment marketchannelcomb;
    ArrayList<SolutionOrder> solutionorders;

    public SolutionOffer(MarketChannelAssignment m) {
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        m.addSolutionOffer(this);

    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void setTotalPrice(int p) {
        price = p;

    }

    public int getSolutionPrice() {
        return price;
    }

    public int getRevenues() {
        int sum = 0;
        for (SolutionOrder so : solutionorders) {
            sum = sum + so.getSolutionPrice();

        }
        return sum;
    }

    public void addSolutionOrder(SolutionOrder so) {
        solutionorders.add(so);
    }

    // this will allow one to retrieve all offers meant for this market/channel
    // combo
    public boolean isSolutionOfferMatchMarketChannel(MarketChannelAssignment mca) {

        if (marketchannelcomb == mca)
            return true;
        else
            return false;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String a) { // this an amazing solution for people like
        ad = a;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
