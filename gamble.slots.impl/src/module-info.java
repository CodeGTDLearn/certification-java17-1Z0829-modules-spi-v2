import gamble.slots.impl.PayOffServiceDefault;
import gamble.slots.spi.PayOffServiceSPI;

module gamble.slots.impl {
  requires gamble.slots.spi;
  provides PayOffServiceSPI with PayOffServiceDefault;
}