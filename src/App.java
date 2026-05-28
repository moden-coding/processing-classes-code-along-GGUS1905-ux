import java.util.ArrayList;

import processing.core.*;

public class App extends PApplet {
    // Bubble firstOne;
    ArrayList<Bubble> bubbles;
    double timer;
    int scene = 0;
    double highScore;
    double gameStart;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        bubbles = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            bubbleMaker();

        }
        scene = 0;
        gameStart = millis();
    }

    public void settings() {
        size(1200, 700);

    }

    public void draw() {
        background(0);
        if (scene == 0) {
            for (Bubble b : bubbles) {
                b.desplay();
                b.update();
            }
            fill(255);
            textSize(50);
            timer = millis() - gameStart;
            timer = ((int) timer / 100) / 10.0;
            text("" + timer, width - 100, 50);
            if (bubbles.size() == 0) {
                scene = 1;
                if (highScore < timer) {
                    highScore = timer;
                }
            }
        } else {
            text("score" + timer, 400, 400);
            text("highScore" + highScore, 400, 500);
        }

    }

    public void bubbleMaker() {
        int x = (int) random(800) + 125;
        int y = (int) random(800);
        Bubble bubble = new Bubble(x, y, this);
        bubbles.add(bubble);

    }

    public void keyPressed() {
        if (key == ' ') {
            if (scene == 0) {
                bubbles.clear();
            } else {
                setup();
            }
        }
    }

    public void mousePressed() {
        for (int i = 0; i < bubbles.size(); i++) {
            Bubble b = bubbles.get(i);
            b.checkTouch(mouseX, mouseY);

        }
    }
}
