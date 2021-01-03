import processing.core.PApplet;

public class Processing extends PApplet {

    public static final int HEIGHT = 480;
    public static final int WIDTH = 640;
    private static final int SCREEN_SPLIT_UP = 5;
    private static final int DIAMETER = 20;
    private int xOffset = 0;

    public static void main(String[] args) {
        PApplet.main("Processing", args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        for (int position = 1; position < SCREEN_SPLIT_UP; position++) {
            Circle circle = instantiateCircle(position);
            circle.drawCircle();
        }
        xOffset++;
    }

    private Circle instantiateCircle(int position) {
        int yOffset = calculateyOffset(position);
        return new Circle(xOffset * position, yOffset, DIAMETER);
    }

    private int calculateyOffset(int position) {
        return (HEIGHT * position) / SCREEN_SPLIT_UP;
    }

    private class Circle {

        private final int yOffset;
        private final int xOffset;
        private final int diameter;

        public Circle(int xOffset, int yOffset, int diameter) {
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            this.diameter = diameter;
        }

        public void drawCircle() {
            ellipse(xOffset, yOffset, diameter, diameter);
        }

    }
}
