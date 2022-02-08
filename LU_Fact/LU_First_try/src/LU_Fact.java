//--------------------------------------------------//
// MATH226 - Numerical Methods for EE
// Fall 2021 – 2022
// Project 1
// Name-Surname: <SAIT TALHA ULUTAŞ -  FIRAT KOÇ - ALP KUTAY ATASEVER >
// Student ID: < 041702004 – 041702019 – 041802055>
// We certify that no unauthorized assistance has been received or given
// in the completion of the project.
//---------------------------------------------------//
public class LU_Fact {


    public static void LU(double[][] matrix, int dim) {

        //First, we create a method called LU. We have determined the variables that we can put parameters into.
        // After factoring the matrix in the Double line, we wrote this line to keep the result in the matrix.
        // After that, we wrote nested for Upper Triangle and Lower Triangle.
        double[][] low_tri = new double[dim][dim];

        double[][] upp_tri = new double[dim][dim];

        //Matrix multiplication ; c_row,column= (Total up to K ) a_row,k * b_k,column

        for (int row = 0; row < dim; row++) {

            for (int term = row; term < dim; term++) { // Increase k in the overall formula to appear as a11, a12, a13 continue...
                double fin = 0;
                for (int column = 0; column < dim; column++) // for written to return columns

                    fin += (low_tri[row][column] * upp_tri[row][column]);

                //To draw the top matrix, we extract the matrix from the matrix with the obtained for operations.

                upp_tri[row][term] = matrix[row][term] - fin;
            }

            for (int term = row; term < dim; term++) { //here we get the beginning for to get the lower triangle
                if (row == term) // if k is equal to row we need to join here
                    low_tri[row][row] = 1; // operation 1
                else {
                    double fin = 0; // if not, assign a load variable here to keep the different values like we did with Upper
                    for (int column = 0; column < row; column++) // here we are trying to provide the rendered image to get the lower triangle.
                        fin += (low_tri[term][column] * upp_tri[column][row]);

                    //Finally, subtract from the total matrix to subtract the lower triangular matrix.
                    low_tri[term][row] = (matrix[term][row] - fin) / upp_tri[row][row];
                }
            }
        }
        // actions written to show the result

        System.out.println("   " + "Lower Triangular"
                + "            " + "Upper Triangular");

        for (int row = 0; row < dim; row++) {
            // Low_tri
            for (int column = 0; column < dim; column++)
                System.out.print("   " + low_tri[row][column]
                        + "\t");
            System.out.print("\t");

            // Upp_tri
            for (int column = 0; column < dim; column++)

                System.out.print("   " + upp_tri[row][column]
                        + "\t");
            System.out.print("\n");
        }
    } //Final line of first method

    public static double e = 1e-10;

    public static double[] Partial(double[][] matrix, double[] b) { // We would like to evaluate Ax=b with partial pivot. Here we setting parameters of methods.

        int dimension = b.length; // the dimension of matrix should be equal of length of b

        for (int pivot = 0; pivot < dimension; pivot++) {

            int max_value = pivot; // Here we set a variable that contains the maximum value of the pivot.

            //we will first take the absolute value of the largest value in the first column of the matrix and take the pivot up and
            // set the lower values to 0 so that we do the back substitution event.
            for (int row = pivot + 1; row < dimension; row++) {
                if (Math.abs(matrix[row][pivot]) > Math.abs(matrix[max_value][pivot])) {
                    max_value = row;
                }
            }
            double[] test_array = matrix[pivot]; // Here we have rewritten matrix A in a different matrix, in which the pivot is highest.
            matrix[pivot] = matrix[max_value];
            matrix[max_value] = test_array;

            double test_b = b[pivot]; // same situation for b matrix
            b[pivot] = b[max_value];
            b[max_value] = test_b;

            // now we will check if the matrix is singular.

            boolean singular;

            if (Math.abs(matrix[pivot][pivot]) <= e) {
                singular = true;
            } else {
                singular = false;
            }

        /*Scaled pivoting involves ratios. A prospective pivot is divided by the largest element in absolute value in its row, ignoring the last column.
        The result is compared to the ratios formed by dividing every
        element directly below the pivot by the largest element in absolute value in its respective row, again ignoring the last column.
         */

            for (int row = pivot + 1; row < dimension; row++) {
                double c_solution = matrix[row][pivot] / matrix[pivot][pivot]; // Meaning of compute solution component (c_solution).
                b[row] -= c_solution * b[pivot];
                for (int column = pivot; column < dimension; column++) {
                    matrix[row][column] -= c_solution * matrix[pivot][column];
                }
            }
        }
// Back Substituon,
        double[] fin_sol = new double[dimension]; // In this section, we defined the array that we will print as a final result. We will also keep the for loop we use for back substitution in this array.

        for (int row = dimension - 1; row >= 0; row--) { // Since we will do the operations in the opposite order here, we used the minus sign contrary to the previous expressions.
            double finalValue = 0.0;
            for (int column = row + 1; column < dimension; column++) {
                finalValue += matrix[row][column] * fin_sol[column];
            }

            fin_sol[row] = (b[row] - finalValue) / matrix[row][row];

        }
        return fin_sol;


    }




        public static void main (String[]args){
            double matrix[][] = {{1, 1, 1},
                    {2, 1, 3},
                    {1, 2, 1}};
            System.out.println("----------------------------------------------------\n");
            LU(matrix, 3);
            System.out.println("\n----------------------------------------------------\n");
            int dimension=3;
            double [] b = {3,4,5};
            double [] fin_sol = Partial(matrix,b);
            for(int row = 0; row <dimension;row++){
                System.out.println("X values are :"+fin_sol[row]);
            }
        }
    }


