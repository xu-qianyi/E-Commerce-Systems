/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketingManagement;

import java.util.ArrayList;

import model.MarketModel.Market;

/**
 *
 * @author kal bugrara
 */
public class MarketCatalog {

    ArrayList<Market> markets;

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public MarketCatalog() {

        markets = new ArrayList();

    }

    public Market newMarket(String m) {

        Market market = new Market(m);
        markets.add(market);
        return market;
    }

}
