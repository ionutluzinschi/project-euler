package com.myproject.euler.exercises.exercise42;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TriangleValuesTest {

    @Test
    public void calculateTriangleValues() {
        TriangleValues triangleValues = new TriangleValues();
        triangleValues.calculateTriangleValues();
    }

    @Test
    public void isTriangle() {
        TriangleValues triangleValues = new TriangleValues();
        assertTrue(triangleValues.isTriangle("\"SKY\""));

    }
}