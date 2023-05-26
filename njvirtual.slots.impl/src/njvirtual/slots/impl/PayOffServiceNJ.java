package njvirtual.slots.impl;


import gamble.slots.spi.PayOffServiceSPI;

public class PayOffServiceNJ implements PayOffServiceSPI {
  public PayOffServiceNJ() {

    System.out.println("Service: Atlantic City PayOffService(PSA) - loaded");
  }

  @Override  public void hitTheJackPot() {

    System.out.println("\nPSA: Voucher for AtlantisHotel");
  }
  @Override  public void threeInRow(SlotType s) {

    System.out.println("\nPSA: Voucher for AtlantisHotel");
  }
  @Override  public void twoInRow(SlotType s) {

    System.out.println("\nPSA: Voucher for TrumpHotel");
  }      }