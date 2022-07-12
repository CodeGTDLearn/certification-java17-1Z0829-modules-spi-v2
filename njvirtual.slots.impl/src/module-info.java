import gamble.slots.spi.PayOffServiceSPI;
import njvirtual.slots.impl.PayOffServiceNJ;

module njvirtual.slots.impl {
  requires gamble.slots.spi;
  provides PayOffServiceSPI with PayOffServiceNJ;
}