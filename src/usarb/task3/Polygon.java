package usarb.task3;

class Polygon {
    private Point[] points;

    // Constructor ce primește doar numărul de colțuri
    public Polygon(int n) {
        points = new Point[n];
    }

    // Constructor ce primește un vector de 2n coordonate
    public Polygon(float[] coords) {
        int n = coords.length / 2;
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            float x = coords[2 * i];
            float y = coords[2 * i + 1];
            points[i] = new Point(x, y);
        }
    }

    // Afișează toate punctele din poligon
    public void displayPolygon() {
        for (Point p : points) {
            if (p != null) {
                p.display();
            }
        }
    }
}
