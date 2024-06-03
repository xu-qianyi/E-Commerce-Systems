package SolutionOrders;

import model.MarketModel.MarketChannelAssignment;

public class SolutionOrder {
    SolutionOffer selectedsolutionoffer;
    // CustomerProfile customerprofile;
    MarketChannelAssignment marketChannelAssignment;

    public SolutionOrder(SolutionOffer so, MarketChannelAssignment mca) {
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;

    }

    public int getSolutionPrice() {
        return selectedsolutionoffer.getSolutionPrice();
    }

    public MarketChannelAssignment getMarketChannelCombo() {

        return marketChannelAssignment;

    }

}
