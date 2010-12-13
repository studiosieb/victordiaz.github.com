package processing.android.test.sinusoides_aleatorias;

import processing.android.core.*; 
import processing.android.opengl.*; 
import processing.android.xml.*; 

public class sinusoides_aleatorias extends PApplet {

/*
@title: ""
@description: 
@date_and_time: //2008 :
@weather: 
@place: Japan -> Tokyo -> MyApartment -> theKitchen
@mood: 2 (1 minimum to 5 maximum)
@comments: 
*/

sinusoide[] q;

public void setup() {
  size(1920, 1200);
  //size(700, 300);
  
  background(0);
  noStroke();
  smooth();

  frameRate(30);
  
  q = new sinusoide[100];
  
  for (int i = 1; i < 100; i++) {
    fill(255, random(100));
    q[i] = new sinusoide(PApplet.parseInt(random(-50, 50))); 
  }
  
  for (int i = 1; i < 100; i++) {
    fill(255, random(100));
    q[i] = new sinusoide(PApplet.parseInt(random(-21, 21))); 
  }
  
}

public void draw() {
  
  for (int i = 1; i < 100; i++) {
    q[i].update();  
  }
  
  //save("img"+nCurvas+".png");
  
}


class sinusoide {
  int posicion = 0;
  float x = 0;
  float angle = 0;
  float y = 0;
  int rotacion;

  sinusoide(int posicion) {
    this.posicion = posicion;
    this.rotacion = 1;
  }

  public void update() {
    x = x + 1;
    y = height/2 - this.posicion - posicion * sin(angle);
    
    stroke(abs(posicion * 10), 1);
    
    ellipse(x, y, random(1, 10), random(1, 10));
    
    angle += 0.001f * posicion;
  }

}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "sinusoides_aleatorias" });
  }
}
