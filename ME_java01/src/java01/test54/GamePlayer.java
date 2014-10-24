package java01.test54;

public class GamePlayer {

  public static void main(String[] args) throws Exception {
    Class unitClass = Class.forName(args[0]);
    Unit unit = (Unit)unitClass.newInstance();
    unit.run();
    unit.run();
    unit.stop();
    

  }

}
