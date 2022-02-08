import javax.swing.*;
//--------------------------------------------------//
// MATH226 - Numerical Methods for EE
// Fall 2021 – 2022
// Project 2
// Name-Surname: <SAIT TALHA ULUTAŞ -  FIRAT KOÇ - ALP KUTAY ATASEVER >
// Student ID: < 041702004 – 041702019 – 041802055>
// We certify that no unauthorized assistance has been received or given
// in the completion of the project.
//---------------------------------------------------//
public class Methods {

    public static double toleranceRatio = 0.01;
    public static double e=2.718;

    public static double sysFunc(double x) { //user implement the function in this area
        //double func1 = x * x * x - 2 * x - 5;
        //return func1;


        //double func2 = Math.pow(e,-x)-x;
        //return func2;

        //double func3=x*Math.sin(x)-1;
        //return func3;
        //double func4= x*x*x-3*x*x+3*x-1;
        //return func4;
        //double func5=x*x-2*x+1;
        //return func5;

        double func6=0.5*x*Math.pow(e,-x*x);
        return func6;
        //double func7=Math.pow(x,2)+4*Math.cos(x);
        //return func7;



    }
    //Bisection Method
    public static void BisecMet(double x0, double x1) {

        if (sysFunc(x0) * sysFunc(x1) >= 0) {
            System.out.println("This function is not negative so it doesn't existence of root");
            return;
        }
        double middle_point = x0;
        float numofIterations = 0;

        while ((x1 - x0) >= toleranceRatio) { //this ratio for analyzing the how to close the roots. We setted parameters with using tolerance ratio
            numofIterations += 1;
            middle_point = (x0 + x1) / 2; //finding the middle point
            if (sysFunc(middle_point) == 0.0) {
                break;
            } else if (sysFunc(middle_point) * sysFunc(x0) < 0) { //It means when the two function multiple results is negative, it still has a roots.
                x1 = middle_point;

            } else {
                x0 = middle_point;
            }
        }
        System.out.printf("The value of root is : %.4f", middle_point);
        System.out.println("");
        System.out.print("num of iterations: "+ numofIterations);
    }

    public static void SecMeth(double x_0, double x_1) {


        double numofIT = 0;
        double x_middle, x_intermediate;
        double mul_func;


        if (sysFunc(x_0) * sysFunc(x_1) < 0) {
            do {
                x_intermediate = (x_0 * sysFunc(x_1) - x_1 * sysFunc(x_0)) / (sysFunc(x_1) - sysFunc(x_0)); // calculate the intermediate value

                mul_func = (sysFunc(x_0) * sysFunc(x_1)); // check if the x_in in existence of equation (like rootly);
                //according the interval, we will update it of values.
                x_0 = x_1;
                x_1 = x_intermediate;

                numofIT++; // counting the iteration number

                if (mul_func == 0)
                    break;

                x_middle = (x_0 * sysFunc(x_1)-x_1*sysFunc(x_0))/(sysFunc(x_1)-sysFunc(x_0));
            }
                 while (Math.abs(x_middle-x_intermediate)>= toleranceRatio);
                 System.out.println("Root of the" +
                    " given equation=" + x_intermediate);
                 System.out.println("No. of "
                    + "iterations = " + numofIT);
            }

                    else
                System.out.print("Can not find a"
                    + " root in the given interval");
    }

            public static void GoldenSearch (double x_low,double x_high){
            double numofIteration=0;
            double fl=sysFunc(x_low);
            double fu=sysFunc(x_high);

            double R= 0.5*(Math.sqrt(5)-1);
            double D = R*(x_high-x_low);

            double x_one= x_high-D;
            double x_two = x_low+D;

            double func_one=sysFunc(x_one);
            double func_two=sysFunc(x_two);

            double err_inf= Double.POSITIVE_INFINITY;

            while (err_inf> toleranceRatio){
                numofIteration++;
                if(func_one>func_two) {
                    x_high = x_two;
                    fu = func_two;
                    x_two = x_one;
                    func_two = func_one;

                    D = R * (x_high - x_low);
                    x_one = x_high - D;
                }
                    else if(func_two>func_one) {
                        x_low=x_one;
                        fl=func_one;
                        x_one=x_two;
                        func_one=func_two;
                        D=R*(x_high-x_low);
                        x_two=x_low+D;
                        func_two=sysFunc(x_two);
                    }
                    else {
                    x_low = (x_one + x_two) / 2;
                    x_low = x_high;
                }
                    err_inf=2*Math.abs((x_high-x_low)/(x_high+x_low));

                }

                double x_fin=(x_one+x_two)/2;

                System.out.printf("The value of roots:" + x_fin);
                System.out.println("");
                System.out.printf("The iteration num:"+ numofIteration);
                }


        public static void main (String[]args){
            //double x0 = 0, x1 = 3;
           // BisecMet(x0, x1);
           // System.out.println("             ");
            //double x_0=4, x_1=3;
            //SecMeth(x_0,x_1);
           // System.out.println("             ");
             double x_low=0;
            double x_high=2;
            GoldenSearch(x_low,x_high);

        }
    }








































