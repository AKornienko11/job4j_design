package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .startsWithIgnoringCase("S")
                .contains("Sph");
    }

    @Test
    void isThisUnknow() {
        Box box = new Box(3, 3);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object")
                .endsWith("object");

    }

    @Test
    void getNumberOfVertices() {
        Box box = new Box(4, 6);
        int count = box.getNumberOfVertices();
        assertThat(count).isEqualTo(4)
                .isGreaterThan(3);

    }

    @Test
    void getNumberOfVerticesShare() {
        Box box = new Box(-1, 0);
        int count = box.getNumberOfVertices();
        assertThat(count).isEqualTo(-1)
                .isLessThan(3);

    }

    @Test
    void getNumberOfVerticesUnknown() {
        Box box = new Box(0, 3);
        int count = box.getNumberOfVertices();
        assertThat(count).isEqualTo(-1)
                .isNotZero()
                .isNegative();

    }

    @Test
    void isExist() {
        Box box = new Box(8, 12);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isEqualTo(true);
    }

    @Test
    void isExistUnknovn() {
        Box box = new Box(6, 6);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isEqualTo(false);

    }

    @Test
    void getArea() {
        Box box = new Box(0, 3);
        double result = box.getArea();
        assertThat(result).isEqualTo(113.09733552923255);
        assertThat(result).isCloseTo(113.096d, withPrecision(0.002d));

    }

    @Test
    void getAreaTetrahedron() {
        Box box = new Box(4, 6);
        double result = box.getArea();
        assertThat(result).isCloseTo(62.352d, Percentage.withPercentage(1.0d))
                .isGreaterThan(62.35)
                .isCloseTo(62.3d, withPrecision(0.1d));
    }
}


