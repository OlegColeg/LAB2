package usarb.task3;

class Point {
    private float x, y;

    // Constructor ce primește coordonatele
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Metoda pentru schimbarea coordonatelor
    public void changeCoords(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    // Funcția de afișare
    public void display() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

