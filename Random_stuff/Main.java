class Student
{
    int rollno;
    String name;
    {
        this.name = "noname";
        this.rollno = 0;
    }
    Student(int r, String n)
    {
        this.rollno = r;
        this.name = n;
    }
}

class Main
{
    public static void main(String args[])
    {
        Student stu = new Student(45, "Ayush Salwani");
        System.out.println(stu.name);
    }
}
