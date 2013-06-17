package dungeon.ui.messages;

import dungeon.messages.Message;
import dungeon.models.Item;
import dungeon.models.Merchant;

public class SellCommand implements Message {
  private final Merchant merchant;

  private final Item item;

  public SellCommand (Merchant merchant, Item item) {
    this.merchant = merchant;
    this.item = item;
  }

  public Merchant getMerchant () {
    return this.merchant;
  }

  public Item getItem () {
    return this.item;
  }
}
