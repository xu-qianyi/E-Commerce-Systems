package model.MarketingManagement;

import java.util.ArrayList;

import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;

public class MarketChannelComboCatalog {

    ArrayList<MarketChannelAssignment> mcalist;

    public ArrayList<MarketChannelAssignment> getMcalist() {
        return mcalist;
    }

    public MarketChannelComboCatalog() {

        mcalist = new ArrayList();

    }

    public MarketChannelAssignment newMarketChannelCombo(Market m, Channel c) {
        MarketChannelAssignment mcc = new MarketChannelAssignment(m, c);
        mcalist.add(mcc);
        return mcc;

    }

    public MarketChannelAssignment finMarketChannelCombo(Market m, Channel c) {

        for (MarketChannelAssignment mca : mcalist) {
            if (mca.matches(m, c))
                return mca;
        }
        return null;

    }

}
