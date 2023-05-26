package gamble.slots.spi;

public interface PayOffServiceSPI {
  enum SlotType {
    FRUIT,
    JACKPOT,
    GOLDBAR_ONE,
    GOLDBAR_TWO,
    GOLDBAR_THREE;
  }

  public void hitTheJackPot();
  public void threeInRow(SlotType s);
  public void twoInRow(SlotType s);  }