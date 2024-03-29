package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return this.getSurname().equals(((Student) obj).getSurname())
                    && this.getName().equals(((Student) obj).getName())
                    && this.getYear() == ((Student) obj).getYear()
                    && this.getGPA() == ((Student) obj).getGPA();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{name=" + name
                + ", surname=" + surname
                + ", " + "GPA=" + GPA
                + ", year=" + year + '}';
    }

    @Override
    public int hashCode(){
        return (int) GPA * 1000 + year + name.hashCode() * 10000;
    }

}
