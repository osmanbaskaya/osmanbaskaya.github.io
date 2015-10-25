import org.jblas.DoubleMatrix;

class MyTest {

    public static void main(String[] args) {
        DoubleMatrix m1 = new DoubleMatrix(1000, 1000);
        System.out.println("Calculation is started.");
        for (int i=0; i<100; i++)
            m1 = m1.mmul(m1);
        System.out.println("Done.");
    }

}
