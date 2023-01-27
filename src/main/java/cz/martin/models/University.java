package cz.martin.models;

public class University {
    private String university;
    private String country;
    private int students;
    private int teachers;

    public University(String university, String country, int students, int teachers) {
        this.university = university;
        this.country = country;
        this.students = students;
        this.teachers = teachers;
    }

    public String getUniversity() {
        return university;
    }

    public String getCountry() {
        return country;
    }

    public int getStudents() {
        return students;
    }

    public int getTeachers() {
        return teachers;
    }
}
