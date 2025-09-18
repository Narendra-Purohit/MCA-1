public class Matrix {
    private double[][] data;
    private int rows, cols;

    public Matrix() {
        this.rows = 2;
        this.cols = 2;
        this.data = new double[rows][cols];
    }

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive.");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public Matrix(double[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            throw new IllegalArgumentException("Matrix values cannot be null or empty.");
        }
        this.rows = values.length;
        this.cols = values[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = values[i][j];
            }
        }
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    public Matrix addition(Matrix m1) {
        if (m1 == null) throw new NullPointerException("Matrix cannot be null.");
        if (this.rows != m1.rows || this.cols != m1.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + m1.data[i][j];
            }
        }
        return result;
    }

    public static Matrix addition(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) throw new NullPointerException("Matrices cannot be null.");
        if (m1.rows != m2.rows || m1.cols != m2.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }
        Matrix result = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                result.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtraction(Matrix m1) {
        if (m1 == null) throw new NullPointerException("Matrix cannot be null.");
        if (this.rows != m1.rows || this.cols != m1.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - m1.data[i][j];
            }
        }
        return result;
    }

    public static Matrix subtraction(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) throw new NullPointerException("Matrices cannot be null.");
        if (m1.rows != m2.rows || m1.cols != m2.cols) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction.");
        }
        Matrix result = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                result.data[i][j] = m1.data[i][j] - m2.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiplication(Matrix m1) {
        if (m1 == null) throw new NullPointerException("Matrix cannot be null.");
        if (this.cols != m1.rows) {
            throw new IllegalArgumentException("Matrix multiplication not possible. Cols of A must match rows of B.");
        }
        Matrix result = new Matrix(this.rows, m1.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * m1.data[k][j];
                }
            }
        }
        return result;
    }

    public static Matrix multiplication(Matrix m1, Matrix m2) {
        if (m1 == null || m2 == null) throw new NullPointerException("Matrices cannot be null.");
        if (m1.cols != m2.rows) {
            throw new IllegalArgumentException("Matrix multiplication not possible. Cols of A must match rows of B.");
        }
        Matrix result = new Matrix(m1.rows, m2.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                for (int k = 0; k < m1.cols; k++) {
                    result.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return result;
    }

    public Matrix inverse() {
        if (rows != 2 || cols != 2) {
            throw new UnsupportedOperationException("Inverse implemented only for 2x2 matrices.");
        }
        double det = (data[0][0] * data[1][1]) - (data[0][1] * data[1][0]);
        if (det == 0) {
            throw new ArithmeticException("Matrix is singular and cannot be inverted.");
        }
        Matrix result = new Matrix(2, 2);
        result.data[0][0] = data[1][1] / det;
        result.data[0][1] = -data[0][1] / det;
        result.data[1][0] = -data[1][0] / det;
        result.data[1][1] = data[0][0] / det;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append("[ ");
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        double[][] a = {{1, 2}, {3, 4}};
        double[][] b = {{5, 6}, {7, 8}};

        Matrix m1 = new Matrix(a);
        Matrix m2 = new Matrix(b);

        System.out.println("Matrix m1:\n" + m1);
        System.out.println("Matrix m2:\n" + m2);

        System.out.println("Transpose of m1:\n" + m1.transpose());
        System.out.println("Addition (m1+m2):\n" + m1.addition(m2));
        System.out.println("Subtraction (m1-m2):\n" + m1.subtraction(m2));
        System.out.println("Multiplication (m1*m2):\n" + m1.multiplication(m2));
        System.out.println("Inverse of m1:\n" + m1.inverse());
    }
}
