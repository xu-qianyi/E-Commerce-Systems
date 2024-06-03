/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import SolutionOrders.SolutionOffer;
import model.MarketingManagement.Channel;

/**
 *
 * @author kal bugrara
 */
public class Market {

  String name;

  ArrayList<Channel> validchannels;

  ArrayList<SolutionOffer> so;
  ArrayList<MarketChannelAssignment> channels;

  ArrayList<String> characteristics;// a way to describe in plain language what is that group
  ArrayList<Market> submarkets;
  int size;

  public Market(String n) {
    name = n;
    characteristics = new ArrayList<>();
    submarkets = new ArrayList<>();
    validchannels = new ArrayList<>();
    // characteristics.add(s); 原model的method
  }

  public void addCharactersitic(String c) {
    characteristics.add(c);
  }

  public void addValidChannel(Channel c) {

    validchannels.add(c);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Channel> getValidchannels() {
    return validchannels;
  }

  public ArrayList<MarketChannelAssignment> getChannels() {
    return channels;
  }

}
