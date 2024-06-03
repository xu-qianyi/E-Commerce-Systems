/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import SolutionOrders.SolutionOffer;
import SolutionOrders.SolutionOrder;
import model.MarketingManagement.Channel;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    Market market;
    Channel channel;
    int adbudget;

    // int targetrevenue;
    ArrayList<SolutionOffer> solutionofferlist;
    ArrayList<SolutionOrder> solutionorderlist;

    public MarketChannelAssignment(Market m, Channel c) {

        market = m;
        channel = c;
        solutionofferlist = new ArrayList();
        solutionorderlist = new ArrayList();

    }

    public void addSolutionOffer(SolutionOffer soffer) {

        solutionofferlist.add(soffer);

    }

    public void addSolutionOrder(SolutionOrder so) {

        solutionorderlist.add(so);

    }

    public int getRevenues() {
        int sum = 0;
        for (SolutionOrder so : solutionorderlist) {
            sum = sum + so.getSolutionPrice();

        }
        return sum;
    }

    public boolean matches(Market m, Channel c) {

        if (market == m && channel == c) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMarketMatch(Market m) {

        if (market == m) {
            return true;
        }

        return false;
    }

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public boolean isChannelMatch(Channel c) {

        if (channel == c) {
            return true;
        }
        return false;
    }

    public int getAdbudget() {
        return adbudget;
    }

    public void setAdbudget(int adbudget) {
        this.adbudget = adbudget;
    }

}
