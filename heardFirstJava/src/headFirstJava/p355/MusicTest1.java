package headFirstJava.p355;

import javax.sound.midi.*;

public class MusicTest1 {

  public void play() {
    /* Sequencer 객체가 필요. 이 객체는 우리가 사용할 미디 장치, 미디 악기의 중심부이다.
         모든 미디 정보를 '곡'으로 만들어주는 역할을 한다.
         하지만 새로운 객체를 직접 만들지 않고
       MidiSystem에 객체를 요구하는 방법을 사용한다. */
    try {
      Sequencer sequencer = MidiSystem.getSequencer();
      System.out.println("We got a sequencer");
    } catch (MidiUnavailableException ex) {
      System.out.println("Bummer");
    }
  }
  
  public static void main(String[] args) {
    MusicTest1 mt = new MusicTest1();
    mt.play();
  }
}
