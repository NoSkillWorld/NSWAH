package fr.nuggetreckt.nswah.listener;

import fr.nuggetreckt.nswah.AuctionHouse;
import fr.nuggetreckt.nswah.gui.impl.AuctionHouseGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

public class OnInvExit implements Listener {

    private final AuctionHouse instance;

    public OnInvExit(AuctionHouse instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onInvExit(@NotNull InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        InventoryView inventoryView = event.getView();
        AuctionHouseGUI auctionHouseGUI = (AuctionHouseGUI) instance.getGuiManager().registeredMenus.get(AuctionHouseGUI.class);

        if (inventoryView.getTitle().equalsIgnoreCase(auctionHouseGUI.getName())) {
            auctionHouseGUI.setCurrentPage(player, 0, true);
        }
    }
}
