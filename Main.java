import java.util.Scanner;
//Complete this program that the user will be able to choose the quadilateral it wants to calculate its perimeter and area

class Main {
  public static void main(String[] args) {
    System.out.println("What quadilateral do you want to calculate");
            System.out.println("Input P for parallelogram, T for trapezoid, H for rhombus, S for square or R for rectangle");
            Scanner scan = new Scanner(System.in);
            //Declare a char to store the chosen quadilateral
            char quad = scan.next().charAt(0);



        //using a switch check what the user selected and use it to calculate the perimeter and area of the desired quadilateral
        switch (quad) {
            case 'P':
                //this should be in the parallelogram case
                System.out.println("This program calculates the area and perimeter of the parallelogram.");
                System.out.println("Input the base of your Parallelogram");
                float pBase = scan.nextFloat();
                System.out.println("Input the height of your Parallelogram");
                float pHeight = scan.nextFloat();
                Parallelogram p = new Parallelogram(pBase, pHeight);

                Quadilateral q = p;


                System.out.println("Input the dimension of the first pair of your Parallelogram");
                q.setLength(scan.nextFloat());
                System.out.println("Input the second pair of your Parallelogram");
                q.setBreadth(scan.nextFloat());

                System.out.printf("The area of the parallelogram with base %.2f and height %.2f is %.2f", pBase, pHeight, p.Area());

                System.out.println("");
                System.out.printf("The perimeter of the parallelogram with First Pair: %.2f and SecondPair: %.2f is %.2f", q.getLength(), q.getBreadth(), q.calculatePerimeter());
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;


            case 'T':
                //this should be in the Trapezoid case
                System.out.println("Calculation for a Trapezoid");
                System.out.println("Input the shorter parellel side side");
                float a = scan.nextFloat();
                System.out.println("Input the longer parallel side side");
                float b = scan.nextFloat();
                System.out.println("Input third side");
                float c = scan.nextFloat();
                System.out.println("Input fourth side");
                float d = scan.nextFloat();
                System.out.println("Input the height");
                float h = scan.nextFloat();
                Trapezoid t = new Trapezoid(a, b, c, d, h);
                System.out.printf("The perimeter of the Trapezoid with shorter parallel Side: %.2f, longer parallel Side: %.2f, Third Side: %.2f, and Fourth Side: %.2f is %.2f", a, b, c, d, t.calculatePerimeter());
                System.out.println("");
                System.out.printf("The area of the trapezoid with shorter parallel side: %.2f, longer parallel side: %.2f is %.2f", a, b, h, t.CalculateArea());
                System.out.println("");
                break;

            case 'H':
                //this should be in the Rhombus case
                System.out.println("Calculation for Rhombus");
                System.out.println("Input the length");
                float r = scan.nextFloat();
                System.out.println("Input the first diagonal");
                float d1 = scan.nextFloat();
                System.out.println("Input the second diagonal");
                float d2 = scan.nextFloat();
                Rhombus n = new Rhombus(r, d1, d2);
                System.out.printf("The perimeter of the Rhombus with length: %.2f is %.2f", r, n.calculatePerimeter());
                System.out.println("");
                System.out.printf("The area of the rhombus with first diagonal: %.2f and second diagonal: %.2f is %.2f", d1, d2, n.calculateArea());
                break;

            case 'S':
                //this should be in the Square case
                System.out.println("Calculation for Square");
                System.out.println("Input the length");
                float s = scan.nextFloat();
                Square x = new Square(s);
                System.out.printf("The perimeter of the square with length: %.2f is %.2f", s, x.calculatePerimeter());
                System.out.println("");
                System.out.printf("The area of the square with length: %.2f is %.2f", s, x.calculateArea());
                break;

            case 'R':
                //this should be in the Rectangle case
                System.out.println("Calculation for Rectangle");
                System.out.println("Input the length");
                float l = scan.nextFloat();
                System.out.println("Input the width");
                float w = scan.nextFloat();
                Rectangle j = new Rectangle(l, w);
                System.out.printf("The perimeter of the Rectangle with lenght %.2f and width %.2f is %.2f", l, w, j.calculateperimeter());
                System.out.println("");
                System.out.printf("The Area of the Rectangle with lenght %.2f and width %.2f is %.2f", l, w, j.calculateArea());
                break;
        }
    }
    }


                //Create class for Rhombus
        class Rhombus extends Quadilateral {
            private float length;
            private float diagonal1;
            private float diagonal2;

            public Rhombus(float r, float d1, float d2){
                length = r;
                diagonal1 = d1;
                diagonal2 = d2;
            }
            public float calculatePerimeter() {
                return length * 4;
            }
            public float calculateArea() {
                return (diagonal1 * diagonal2)/2;
            }
        }


                //Create class for square
            class Square extends Quadilateral {
                private float length;

                public Square(float s) {
                    length = s;
                }
                public float calculatePerimeter() {
                    return length * 4;
                }
                public float calculateArea() {
                    return length * length;
                }
            }

                //create class for Rectangle
            class Rectangle extends Quadilateral {
                 private float length;
                 private float width;

                 public Rectangle(float l, float w) {
                     length = l;
                     width = w;
                 }

                 public float calculateperimeter() {
                     return (length + width) * 2;
                 }
                 public float calculateArea() {
                     return length * width;
                 }
            }

        class Trapezoid extends Quadilateral {
            private float shorterParallelSide;
            private float longerParallelSide;
            private float side3;
            private float side4;
            private float height;

            public Trapezoid(float a, float b, float c, float d, float h) {
                shorterParallelSide = a;
                longerParallelSide = b;
                side3 = c;
                side4 = d;
                height = h;
            }

            public float calculatePerimeter() {
                return shorterParallelSide + longerParallelSide + side3 + side4;
            }
            public float CalculateArea() {
                return (((shorterParallelSide + longerParallelSide)/2) * height);
            }
        }
        class Parallelogram extends Quadilateral {
            private float base;
            private float height;

            public Parallelogram(float b, float h) {
                if (b <= 0) {
                    System.out.println("You cannot have a negative or zero base. Therfore base returns to default which is 1");
                    base = 1;
                } else
                    base = b;
                if (h <= 0) {
                    System.out.println("You cannot have a negative or zero height. Therfore height returns to default which is 1");
                    height = 1;
                } else
                    height = h;
            }

            public float Area() {
                return base * height;
            }

        }
        class Quadilateral {
            private float length;
            private float breadth;

            public void setLength(float l) {
                length = l;
            }

            public float getLength() {
                return length;
            }

            public void setBreadth(float b) {
                breadth = b;
            }

            public float getBreadth() {
                return breadth;
            }

            public float calculatePerimeter() {
                return 2 * (length + breadth);
  }  
}                  
