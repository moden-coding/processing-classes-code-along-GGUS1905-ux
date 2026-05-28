import processing.core.PApplet;

public class Bubble {
    private int x;
    private int y;
    private int size;
    private PApplet canvas;
    private int speed;
    private int color;
    private int health;

    public Bubble(int xPos, int yPos, PApplet c) {
        if (x < 25) {
            x = 25;
        } else if (x > 1000 - 25) {
            x = 1000 - 25;
        }

        x = xPos;
        y = yPos;
        size = 100;
        canvas = c;
        speed = 5;
        color = canvas.color(0, 255, 0);
        health = 3;

    }

    public void desplay() {
        canvas.circle(x, y, size);
       
        if (health == 2) {
            System.out.println("yellow!!!");
            color = canvas.color(255, 255, 0);
        } else if (health == 1) {
            color = canvas.color(255, 0, 0);
        }
        canvas.fill(color);

    }

    public void update() {
        x += speed;
        if (x + size / 2 > canvas.width || x - size / 2 < 0) {
            speed = -speed;

        }


    }

    public int randomColor() {
        return canvas.color(canvas.random(255), canvas.random(255), canvas.random(255));
    }

    public void checkTouch(int mouseX, int mouseY) {
        float distanceFromCenter = canvas.dist(x, y, mouseX, mouseY);
        if (distanceFromCenter < size / 2) {
            health--;
            System.out.println("touching!");
            System.out.println(health);
        }
        // if (health > 0) {
        //     return true;

        // } else {
        //     return false;
        // }

    }

}
