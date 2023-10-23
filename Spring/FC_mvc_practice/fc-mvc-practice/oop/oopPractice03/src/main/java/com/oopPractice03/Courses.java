package com.oopPractice03;

import java.util.List;

public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double muliplideCreditAndCourseGrade = 0;
        for (Course course : courses) {
            muliplideCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return muliplideCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
