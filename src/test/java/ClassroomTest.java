import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassroomTest {
    @Test
    void vol_test(){
        assertEquals(120, Classroom.volume(5, 3, 8));
    }


    @Test
    void area_test(){
        assertEquals(40, Classroom.area(5, 8));
    }

    @Test
    void  max_num_stu_test() { assertEquals(40, Classroom.getMaxNumStudents(40));}

    @Test
    void test_class_number() { assertEquals("Class number: 404", Classroom.getClassNumber("404"));}

    @Test
    void test_class_color() { assertEquals("The number of the windows in the class: 6", Classroom.getNumWindows(6));}
}

