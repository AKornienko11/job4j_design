package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).allSatisfy(e -> {
                            assertThat(e.length()).isLessThan(10);
                            assertThat(e.length()).isGreaterThan(0);
                        }
                )
                .anySatisfy(e -> {
                    assertThat(e.length()).isLessThan(6);
                    assertThat(e.length()).isEqualTo(4);
                })
                .allMatch(e -> e.length() < 10)
                .anyMatch(e -> e.length() == 4)
                .noneMatch(e -> e.length() < 1)
                .filteredOn(e -> e.length() > 4).first().isEqualTo("first");
        assertThat(list).filteredOnAssertions(e -> assertThat(e.length()).isGreaterThan(5))
                .hasSize(1)
                .first().isEqualTo("second");
        assertThat(list).first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).filteredOn(e -> e.length() <= 4).first().isEqualTo("four");
        assertThat(set).filteredOnAssertions(e -> assertThat(e.length()).isLessThan(5))
                .hasSize(2)
                .first().isEqualTo("four");


    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "four", "second")
                .containsValues(3, 4, 1)
                .doesNotContainKey("0")
                .doesNotContainValue(7)
                .containsEntry("four", 3);
    }
}
