package gamble.slots.game;

import gamble.slots.spi.PayOffServiceSPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class CherrySlot {
  public static void main(String[] args) {

    new CherrySlot().playGame();
  }

  private void playGame() {
    //    var defaultProvider = "gamble.slots.impl";
    //    PayOffServiceSPI service = getLastService();

    PayOffServiceSPI service = getServiceByDomain_Stream("njvirtual.slots.impl");
    if (service == null) System.out.println("Provider not found");
    else {
      System.out.println("\nCherrySlot: Congrats You're a winner!");
      service.threeInRow(PayOffServiceSPI.SlotType.GOLDBAR_ONE);
    }
  }

  private PayOffServiceSPI getLastService_ForEach() {

    List<PayOffServiceSPI> services = new ArrayList<>();
    final PayOffServiceSPI lastService;

    ServiceLoader.load(PayOffServiceSPI.class)
                 .forEach(services::add);

    if (services.size() > 0) {
      lastService = services.get(services.size() - 1);
      return lastService;
    }
    return null;
  }

  private PayOffServiceSPI getServiceByDomain_Stream(String servicePackageDomain) {

    List<PayOffServiceSPI> services =
         ServiceLoader.load(PayOffServiceSPI.class)
                      .stream()
                      .map(ServiceLoader.Provider::get)
                      .collect(Collectors.toList());

    Optional<PayOffServiceSPI> provider =
         services.stream()
                 .filter((s) -> s.getClass()
                                 .getName()
                                 .contains(servicePackageDomain))
                 .findFirst();

    if (provider.isEmpty()) {
      return services.stream()
                     .findFirst()
                     .orElse(null);
    } else return provider.get();

  }

  private PayOffServiceSPI getServiceByDomain_Stream2(String servicePackageDomain) {

    return
         ServiceLoader
              .load(PayOffServiceSPI.class)
              .stream()
              .map(ServiceLoader.Provider::get)
              .collect(Collectors.toList())
              .stream()
              .filter((s) -> s.getClass()
                              .getName()
                              .contains(servicePackageDomain))
              .findFirst()
              .orElse(null);
  }
}