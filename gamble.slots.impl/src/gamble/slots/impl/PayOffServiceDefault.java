package gamble.slots.impl;

import gamble.slots.spi.PayOffServiceSPI;

public class PayOffServiceDefault implements PayOffServiceSPI {

  public static PayOffServiceSPI provider() {
    System.out.println("Service: PayOffServiceDefault(PSD) - loaded");
    return new PayOffServiceDefault();
  }

  public void hitTheJackPot() {
    System.out.println("\nPSD: Quit your job baby.");
  }

  public void threeInRow(SlotType s) {
    System.out.println("\nPSD: Dinner gained");
  }

  public void twoInRow(SlotType s) {
    System.out.println("\nPSD: 10 Credits gained");
  }
}