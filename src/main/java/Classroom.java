import java.lang.Math;

public class Classroom{
    private static String class_num;
    int length;
    int height;
    int width;
    int num_computers;
    int num_windows ;


    public Classroom(int l, int h, int w, int num_comps, int nw, String cn){
        this.length = l;
        this.height = h;
        this.width = w;
        this.num_computers = num_comps;
        this.class_num = cn;
        this.num_windows = nw;

    }

    public int getNumComputers(){
        return num_computers;
    }

    public String getClassNumber(){
        return class_num;
    }

    public int getNumWindows(){
        return num_windows;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getLength(){
        return length;
    }




    public static String getClassNumber(String classnumber){
        return "Class number: " + classnumber;
    }

    public static String getNumWindows(int numwindows){
        return "The number of the windows in the class: " + numwindows ;
    }

    public static int getMaxNumStudents(int numcomps){
        int total = numcomps;
        return total;
    }
    public static int area(int l, int w){
        int total = l*w;
        return total;
    }

    public static int volume(int l, int h, int w){
        int total = h*l*w;
        return total;
    }
    
    


    public static void main(String[] args){
        Classroom classroom = new Classroom(8, 3, 5, 40, 6,  "404");
        System.out.println("Area : " + area(classroom.getLength(), classroom.getWidth()));
        System.out.println("Volume: " + volume(classroom.getHeight(), classroom.getLength(), classroom.getWidth()));
        System.out.println("Max number students that can be in classroom: " + getMaxNumStudents(classroom.getNumComputers()));

        System.out.println("Class number: " + getClassNumber(classroom.getClassNumber()));
        System.out.println(getNumWindows(classroom.getNumWindows()));
        
        String oneMillionHello = "";
        for (int i = 0; i < 1000000; i++) {
            oneMillionHello = oneMillionHello + "Hello!";
        }
        System.out.println(oneMillionHello.substring(0, 6));

    }

}

