public class FindTriangle {
	public double largestArea(String[] points) {
		Vertex vertices[] = new Vertex[points.length];
		for (int i = 0; i < vertices.length; i++) {
			String fields[] = points[i].split(" ");
			vertices[i] = new Vertex(fields[0].charAt(0),
					Integer.parseInt(fields[1]), Integer.parseInt(fields[2]),
					Integer.parseInt(fields[3]));
		}
		double maxArea = 0;
		for (int i = 0; i < vertices.length; i++) {
			for (int j = i + 1; j < vertices.length; j++) {
				for (int k = j + 1; k < vertices.length; k++) {
					if ((vertices[i].color == vertices[j].color && vertices[j].color == vertices[k].color)
							|| (vertices[i].color != vertices[j].color
									&& vertices[j].color != vertices[k].color && vertices[k].color != vertices[i].color)) {
						Vertex v1 = Vertex.vector(vertices[i], vertices[j]);
						Vertex v2 = Vertex.vector(vertices[i], vertices[k]);
						double area = Math.sqrt(square(v1.x * v2.y - v1.y
								* v2.x)
								+ square(v1.y * v2.z - v1.z * v2.y)
								+ square(v1.z * v2.x - v1.x * v2.z)) / 2;
						maxArea = Math.max(maxArea, area);
					}
				}
			}
		}
		return maxArea;
	}

	long square(long number) {
		return number * number;
	}
}

class Vertex {
	char color;
	int x;
	int y;
	int z;

	public Vertex(char color, int x, int y, int z) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	static Vertex vector(Vertex from, Vertex to) {
		return new Vertex((char) 0, to.x - from.x, to.y - from.y, to.z - from.z);
	}
}