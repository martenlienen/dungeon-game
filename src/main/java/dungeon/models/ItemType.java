package dungeon.models;

import dungeon.game.Transaction;

public enum ItemType {
  HEALTH_POTION("Heiltrank", true, false, 5, 5, 0) {
    @Override
    public String getDescription () {
      return "Heilt " + this.getHitPointDelta() + " HP";
    }

    @Override
    public void use (Transaction transaction) {
      transaction.pushAndCommit(new Player.HitpointTransform(this.getHitPointDelta()));
    }
  },
  MANA_POTION("Manatrank", true, false, 5, 0, 5) {
    @Override
    public String getDescription () {
      return "Heilt " + this.getManaDelta() + " MP";
    }

    @Override
    public void use (Transaction transaction) {
      transaction.pushAndCommit(new Player.ManaTransform(this.getManaDelta()));
    }
  };

  private final String name;

  private final boolean useable;

  private final boolean equipable;

  private final int value;

  private final int hitPointDelta;

  private final int manaDelta;

  private ItemType (String name, boolean useable, boolean equipable, int value, int hitPointDelta, int manaDelta) {
    this.name = name;
    this.useable = useable;
    this.equipable = equipable;
    this.value = value;
    this.hitPointDelta = hitPointDelta;
    this.manaDelta = manaDelta;
  }

  public String getName () {
    return this.name;
  }

  public abstract String getDescription ();

  public boolean isUseable () {
    return this.useable;
  }

  public boolean isEquipable () {
    return this.equipable;
  }

  public int getValue () {
    return this.value;
  }

  public int getHitPointDelta () {
    return this.hitPointDelta;
  }

  public int getManaDelta () {
    return this.manaDelta;
  }

  /**
   * Use the item, e.g. apply the appropriate transforms.
   */
  public void use (Transaction transaction) {

  }

  @Override
  public String toString () {
    return "[" + this.name() + " useable=" + this.useable + ", equipable=" + this.equipable + ", hpDelta=" + this.hitPointDelta + ", mpDelta=" + this.manaDelta + "]";
  }
}
